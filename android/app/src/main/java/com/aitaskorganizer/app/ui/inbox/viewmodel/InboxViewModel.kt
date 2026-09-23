package com.aitaskorganizer.app.ui.inbox.viewmodel

import android.content.ContentResolver
import android.net.Uri
import android.provider.OpenableColumns
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aitaskorganizer.app.data.repository.SourceRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.toRequestBody

sealed class InboxUiState {
    object Idle : InboxUiState()
    object Loading : InboxUiState()
    data class Success(val sourceId: Long) : InboxUiState()
    data class Error(val message: String) : InboxUiState()
}

class InboxViewModel(private val repository: SourceRepository) : ViewModel() {
    private val _uiState = MutableStateFlow<InboxUiState>(InboxUiState.Idle)
    val uiState: StateFlow<InboxUiState> = _uiState.asStateFlow()

    fun analyzeText(text: String) {
        if (text.isBlank()) return

        viewModelScope.launch {
            _uiState.value = InboxUiState.Loading
            try {
                val result = repository.analyzeText(text)
                _uiState.value = InboxUiState.Success(result.id)
            } catch (e: Exception) {
                _uiState.value = InboxUiState.Error(e.message ?: "Unknown error")
            }
        }
    }

    fun uploadFile(uri: Uri, contentResolver: ContentResolver, type: String) {
        viewModelScope.launch {
            _uiState.value = InboxUiState.Loading
            try {
                val (bytes, fileName, mediaType) = withContext(Dispatchers.IO) {
                    val inputStream = contentResolver.openInputStream(uri)
                    val fileBytes = inputStream?.readBytes() ?: throw Exception("Could not read file")
                    inputStream.close()
                    val name = getFileName(uri, contentResolver) ?: "upload_file"
                    val mType = contentResolver.getType(uri)?.toMediaTypeOrNull() ?: "application/octet-stream".toMediaTypeOrNull()
                    Triple(fileBytes, name, mType)
                }

                val requestFile = bytes.toRequestBody(mediaType)
                val body = MultipartBody.Part.createFormData("file", fileName, requestFile)

                val result = repository.uploadFile(type, body)
                _uiState.value = InboxUiState.Success(result.id)
            } catch (e: Exception) {
                _uiState.value = InboxUiState.Error(e.message ?: "Upload failed")
            }
        }
    }

    private fun getFileName(uri: Uri, contentResolver: ContentResolver): String? {
        var name: String? = null
        val cursor = contentResolver.query(uri, null, null, null, null)
        cursor?.use {
            if (it.moveToFirst()) {
                val index = it.getColumnIndex(OpenableColumns.DISPLAY_NAME)
                if (index != -1) {
                    name = it.getString(index)
                }
            }
        }
        return name
    }

    fun resetState() {
        _uiState.value = InboxUiState.Idle
    }
}
