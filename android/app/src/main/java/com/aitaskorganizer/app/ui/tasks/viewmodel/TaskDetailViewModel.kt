package com.aitaskorganizer.app.ui.tasks.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aitaskorganizer.app.data.local.entities.TaskEntity
import com.aitaskorganizer.app.data.model.TaskStatus
import com.aitaskorganizer.app.data.repository.TaskRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDateTime

sealed class TaskDetailUiState {
    object Loading : TaskDetailUiState()
    data class Success(val task: TaskEntity) : TaskDetailUiState()
    data class Error(val message: String) : TaskDetailUiState()
}

class TaskDetailViewModel(
    private val repository: TaskRepository,
    private val taskId: Long
) : ViewModel() {

    private val _uiState = MutableStateFlow<TaskDetailUiState>(TaskDetailUiState.Loading)
    val uiState: StateFlow<TaskDetailUiState> = _uiState.asStateFlow()

    init {
        loadTask()
    }

    private fun loadTask() {
        viewModelScope.launch {
            try {
                val task = repository.getTaskById(taskId)
                if (task != null) {
                    _uiState.value = TaskDetailUiState.Success(task)
                } else {
                    _uiState.value = TaskDetailUiState.Error("Task not found")
                }
            } catch (e: Exception) {
                _uiState.value = TaskDetailUiState.Error(e.message ?: "Unknown error")
            }
        }
    }

    fun toggleTaskCompletion() {
        val currentState = _uiState.value
        if (currentState is TaskDetailUiState.Success) {
            val task = currentState.task
            val newStatus = if (task.status == TaskStatus.COMPLETED) TaskStatus.PENDING else TaskStatus.COMPLETED
            val completedAt = if (newStatus == TaskStatus.COMPLETED) LocalDateTime.now() else null
            
            viewModelScope.launch {
                repository.updateTaskStatus(task.id, newStatus, completedAt)
                loadTask() // Refresh UI
            }
        }
    }

    fun deleteTask(onDeleted: () -> Unit) {
        val currentState = _uiState.value
        if (currentState is TaskDetailUiState.Success) {
            viewModelScope.launch {
                repository.deleteTask(currentState.task)
                onDeleted()
            }
        }
    }
}
