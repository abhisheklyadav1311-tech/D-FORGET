package com.aitaskorganizer.app.ui.home.viewmodel

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
 * ViewModel for the Home Dashboard.
 *
 * Observes all tasks from Room and computes:
 * - Today's tasks
 * - Upcoming task count
 * - Overdue task count
 * - AI inbox count (placeholder)
 */
class HomeViewModel(private val repository: TaskRepository) : ViewModel() {

    private val _todayTasks = MutableStateFlow<List<TaskUiModel>>(emptyList())
    val todayTasks: StateFlow<List<TaskUiModel>> = _todayTasks.asStateFlow()

    private val _overdueTasks = MutableStateFlow<List<TaskUiModel>>(emptyList())
    val overdueTasks: StateFlow<List<TaskUiModel>> = _overdueTasks.asStateFlow()

    private val _upcomingCount = MutableStateFlow(0)
    val upcomingCount: StateFlow<Int> = _upcomingCount.asStateFlow()

    private val _overdueCount = MutableStateFlow(0)
    val overdueCount: StateFlow<Int> = _overdueCount.asStateFlow()

    private val _todayCount = MutableStateFlow(0)
    val todayCount: StateFlow<Int> = _todayCount.asStateFlow()

    // Placeholder — will be wired to SourceRepository later
    val aiInboxCount: StateFlow<Int> = MutableStateFlow(0)

    init {
        observeTasks()
    }

    private fun observeTasks() {
        viewModelScope.launch {
            repository.allTasks.collect { entities ->
                val today = LocalDate.now()
                val tasks = entities.toUiModels()
                val pending = tasks.filter { it.status == TaskStatus.PENDING }

                val todayList = pending.filter { it.deadline?.toLocalDate() == today }
                val overdueList = pending.filter {
                    it.deadline != null && it.deadline.isBefore(LocalDateTime.now()) && it.deadline.toLocalDate() != today
                }
                val upcomingList = pending.filter {
                    it.deadline != null && it.deadline.toLocalDate().isAfter(today)
                }

                _todayTasks.value = todayList
                _overdueTasks.value = overdueList
                _todayCount.value = todayList.size
                _overdueCount.value = overdueList.size
                _upcomingCount.value = upcomingList.size
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

class HomeViewModelFactory(
    private val repository: TaskRepository
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeViewModel(repository) as T
    }
}
