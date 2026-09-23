package com.aitaskorganizer.app.ui.analysis.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aitaskorganizer.app.data.remote.api.SourceApi
import com.aitaskorganizer.app.data.repository.TaskRepository

class AnalysisViewModelFactory(
    private val sourceApi: SourceApi,
    private val taskRepository: TaskRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AnalysisViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AnalysisViewModel(sourceApi, taskRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
