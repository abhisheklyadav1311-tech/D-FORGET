package com.aitaskorganizer.app.ui.analysis.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aitaskorganizer.app.data.local.entities.TaskEntity
import com.aitaskorganizer.app.data.model.Priority
import com.aitaskorganizer.app.data.model.TaskStatus
import com.aitaskorganizer.app.data.remote.api.SourceApi
import com.aitaskorganizer.app.data.remote.dto.AnalysisResultDto
import com.aitaskorganizer.app.data.remote.dto.ProposedTaskDto
import com.aitaskorganizer.app.data.repository.TaskRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDateTime

sealed class AnalysisUiState {
    object Idle : AnalysisUiState()
    object Loading : AnalysisUiState()
    data class Success(val result: AnalysisResultDto) : AnalysisUiState()
    data class Error(val message: String) : AnalysisUiState()
}

class AnalysisViewModel(
    private val sourceApi: SourceApi,
    private val taskRepository: TaskRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<AnalysisUiState>(AnalysisUiState.Idle)
    val uiState: StateFlow<AnalysisUiState> = _uiState.asStateFlow()

    fun analyzeSource(sourceId: Long) {
        viewModelScope.launch {
            _uiState.value = AnalysisUiState.Loading
            try {
                val result = sourceApi.analyzeSource(sourceId)
                _uiState.value = AnalysisUiState.Success(result)
            } catch (e: Exception) {
                _uiState.value = AnalysisUiState.Error(e.message ?: "Analysis failed")
            }
        }
    }

    fun confirmTask(proposedTask: ProposedTaskDto, sourceId: Long) {
        viewModelScope.launch {
            val taskEntity = TaskEntity(
                title = proposedTask.title,
                description = proposedTask.description ?: "",
                deadline = proposedTask.deadline?.let { LocalDateTime.parse(it) },
                priority = try { Priority.valueOf(proposedTask.priority.uppercase()) } catch (e: Exception) { Priority.MEDIUM },
                category = proposedTask.category,
                subject = proposedTask.subject ?: "",
                status = TaskStatus.PENDING,
                isAiGenerated = true,
                sourceId = sourceId,
                createdAt = LocalDateTime.now(),
                updatedAt = LocalDateTime.now()
            )
            taskRepository.insertTask(taskEntity)
        }
    }
}
