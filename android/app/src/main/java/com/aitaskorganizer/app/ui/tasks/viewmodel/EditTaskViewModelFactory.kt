package com.aitaskorganizer.app.ui.tasks.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aitaskorganizer.app.data.repository.ReminderRepository
import com.aitaskorganizer.app.data.repository.TaskRepository

class EditTaskViewModelFactory(
    private val taskRepository: TaskRepository,
    private val reminderRepository: ReminderRepository,
    private val taskId: Long
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EditTaskViewModel::class.java)) {
            return EditTaskViewModel(taskRepository, reminderRepository, taskId) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
