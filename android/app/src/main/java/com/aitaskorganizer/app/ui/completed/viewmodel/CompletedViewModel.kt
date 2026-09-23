package com.aitaskorganizer.app.ui.completed.viewmodel

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
import java.time.LocalDateTime

class CompletedViewModel(private val repository: TaskRepository) : ViewModel() {

    private val _completedTasks = MutableStateFlow<List<TaskUiModel>>(emptyList())
    val completedTasks: StateFlow<List<TaskUiModel>> = _completedTasks.asStateFlow()

    init {
        observeCompletedTasks()
    }

    private fun observeCompletedTasks() {
        viewModelScope.launch {
            repository.getTasksByStatus(TaskStatus.COMPLETED).collect { entities ->
                _completedTasks.value = entities.toUiModels()
            }
        }
    }

    fun undoComplete(taskId: Long) {
        viewModelScope.launch {
            repository.updateTaskStatus(taskId, TaskStatus.PENDING, null)
        }
    }
}

class CompletedViewModelFactory(
    private val repository: TaskRepository
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CompletedViewModel(repository) as T
    }
}
