package com.aitaskorganizer.app.ui.tasks.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.aitaskorganizer.app.data.model.TaskStatus
import com.aitaskorganizer.app.data.model.TaskUiModel
import com.aitaskorganizer.app.data.model.toUiModels
import com.aitaskorganizer.app.data.repository.TaskRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalDateTime

/**
 * ViewModel for the Tasks list screen.
 *
 * Observes all tasks from Room and provides filtered lists by tab.
 */
class TasksViewModel(private val repository: TaskRepository) : ViewModel() {

    private val _allPending = MutableStateFlow<List<TaskUiModel>>(emptyList())
    val allPending: StateFlow<List<TaskUiModel>> = _allPending.asStateFlow()

    private val _todayTasks = MutableStateFlow<List<TaskUiModel>>(emptyList())
    val todayTasks: StateFlow<List<TaskUiModel>> = _todayTasks.asStateFlow()

    private val _upcomingTasks = MutableStateFlow<List<TaskUiModel>>(emptyList())
    val upcomingTasks: StateFlow<List<TaskUiModel>> = _upcomingTasks.asStateFlow()

    private val _overdueTasks = MutableStateFlow<List<TaskUiModel>>(emptyList())
    val overdueTasks: StateFlow<List<TaskUiModel>> = _overdueTasks.asStateFlow()

    init {
        observeTasks()
    }

    private fun observeTasks() {
        viewModelScope.launch {
            repository.allTasks.collect { entities ->
                val today = LocalDate.now()
                val tasks = entities.toUiModels()
                val pending = tasks.filter { it.status == TaskStatus.PENDING }

                _allPending.value = pending
                _todayTasks.value = pending.filter { it.deadline?.toLocalDate() == today }
                _upcomingTasks.value = pending.filter {
                    it.deadline != null && it.deadline.toLocalDate().isAfter(today)
                }
                _overdueTasks.value = pending.filter {
                    it.deadline != null && it.deadline.isBefore(LocalDateTime.now()) && it.deadline.toLocalDate() != today
                }
            }
        }
    }

    fun toggleTaskCompletion(taskId: Long) {
        viewModelScope.launch {
            val task = repository.getTaskById(taskId) ?: return@launch
            val newStatus = if (task.status == TaskStatus.COMPLETED) TaskStatus.PENDING else TaskStatus.COMPLETED
            val completedAt = if (newStatus == TaskStatus.COMPLETED) LocalDateTime.now() else null
            repository.updateTaskStatus(taskId, newStatus, completedAt)
        }
    }
}

class TasksViewModelFactory(
    private val repository: TaskRepository
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TasksViewModel(repository) as T
    }
}
