package com.aitaskorganizer.app.ui.tasks.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aitaskorganizer.app.data.local.entities.ReminderEntity
import com.aitaskorganizer.app.data.local.entities.TaskEntity
import com.aitaskorganizer.app.data.model.Priority
import com.aitaskorganizer.app.data.model.TaskStatus
import com.aitaskorganizer.app.data.repository.ReminderRepository
import com.aitaskorganizer.app.data.repository.TaskRepository
import com.aitaskorganizer.app.notifications.ReminderScheduler
import android.content.Context
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDateTime

sealed class EditTaskUiState {
    object Loading : EditTaskUiState()
    data class Success(val task: TaskEntity) : EditTaskUiState()
    data class Error(val message: String) : EditTaskUiState()
    object Saved : EditTaskUiState()
}

class EditTaskViewModel(
    private val repository: TaskRepository,
    private val reminderRepository: ReminderRepository,
    private val taskId: Long // 0 if new task
) : ViewModel() {

    private val _uiState = MutableStateFlow<EditTaskUiState>(EditTaskUiState.Loading)
    val uiState: StateFlow<EditTaskUiState> = _uiState.asStateFlow()

    // Form states
    var title by mutableStateOf("")
    var description by mutableStateOf("")
    var priority by mutableStateOf(Priority.MEDIUM)
    var category by mutableStateOf("General")
    var subject by mutableStateOf("")
    var deadline by mutableStateOf<LocalDateTime?>(null)

    // Optional suggested reminder offset state (e.g. true if user wants a reminder)
    var hasReminder by mutableStateOf(false)
    var reminderTime by mutableStateOf<LocalDateTime?>(null)

    private var originalTask: TaskEntity? = null


    init {
        if (taskId > 0) {
            loadTask()
        } else {
            _uiState.value = EditTaskUiState.Success(createEmptyTask())
        }
    }

    private fun loadTask() {
        viewModelScope.launch {
            try {
                val task = repository.getTaskById(taskId)
                if (task != null) {
                    originalTask = task
                    title = task.title
                    description = task.description
                    priority = task.priority
                    category = task.category
                    subject = task.subject
                    deadline = task.deadline
                    _uiState.value = EditTaskUiState.Success(task)
                } else {
                    _uiState.value = EditTaskUiState.Error("Task not found")
                }
            } catch (e: Exception) {
                _uiState.value = EditTaskUiState.Error(e.message ?: "Unknown error")
            }
        }
    }

    private fun createEmptyTask() = TaskEntity(
        title = "",
        description = "",
        deadline = null,
        priority = Priority.MEDIUM,
        category = "General",
        subject = "",
        status = TaskStatus.PENDING,
        isAiGenerated = false,
        sourceId = null,
        createdAt = LocalDateTime.now(),
        updatedAt = LocalDateTime.now()
    )

    fun saveTask(context: Context) {
        if (title.isBlank()) return

        viewModelScope.launch {
            try {
                val taskToSave = originalTask?.copy(
                    title = title,
                    description = description,
                    priority = priority,
                    category = category,
                    subject = subject,
                    deadline = deadline,
                    updatedAt = LocalDateTime.now()
                ) ?: createEmptyTask().copy(
                    title = title,
                    description = description,
                    priority = priority,
                    category = category,
                    subject = subject,
                    deadline = deadline
                )

                val savedId = if (taskToSave.id > 0) {
                    repository.updateTask(taskToSave)
                    taskToSave.id
                } else {
                    repository.insertTask(taskToSave)
                }

                if (hasReminder) {
                    val finalReminderTime = reminderTime ?: deadline?.minusHours(1) ?: LocalDateTime.now().plusMinutes(30)
                    val reminderEntity = ReminderEntity(
                        taskId = savedId,
                        reminderTime = finalReminderTime
                    )
                    val reminderId = reminderRepository.insertReminder(reminderEntity)
                    
                    val scheduler = ReminderScheduler(context)
                    scheduler.scheduleReminder(
                        reminderEntity.copy(id = reminderId),
                        title,
                        description.ifBlank { "Task Reminder" }
                    )
                }

                _uiState.value = EditTaskUiState.Saved
            } catch (e: Exception) {
                _uiState.value = EditTaskUiState.Error(e.message ?: "Failed to save task")
            }
        }
    }
}
