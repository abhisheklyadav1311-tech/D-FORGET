package com.aitaskorganizer.app.ui.source.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.aitaskorganizer.app.data.remote.dto.SourceDto
import com.aitaskorganizer.app.data.repository.SourceRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class SourceDetailUiState {
    object Loading : SourceDetailUiState()
    data class Success(val source: SourceDto) : SourceDetailUiState()
    data class Error(val message: String) : SourceDetailUiState()
}

class SourceDetailViewModel(
    private val repository: SourceRepository,
    private val sourceId: Long
) : ViewModel() {

    private val _uiState = MutableStateFlow<SourceDetailUiState>(SourceDetailUiState.Loading)
    val uiState: StateFlow<SourceDetailUiState> = _uiState.asStateFlow()

    init {
        loadSource()
    }

    fun loadSource() {
        viewModelScope.launch {
            _uiState.value = SourceDetailUiState.Loading
            try {
                val source = repository.getSource(sourceId)
                _uiState.value = SourceDetailUiState.Success(source)
            } catch (e: Exception) {
                _uiState.value = SourceDetailUiState.Error(e.message ?: "Failed to load source transparency log")
            }
        }
    }
}

class SourceDetailViewModelFactory(
    private val repository: SourceRepository,
    private val sourceId: Long
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SourceDetailViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SourceDetailViewModel(repository, sourceId) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
