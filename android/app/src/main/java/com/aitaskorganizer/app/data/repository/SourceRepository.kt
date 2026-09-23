package com.aitaskorganizer.app.data.repository

import com.aitaskorganizer.app.data.remote.api.SourceApi
import com.aitaskorganizer.app.data.remote.dto.SourceDto
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.toRequestBody

class SourceRepository(private val api: SourceApi) {
    suspend fun analyzeText(text: String): SourceDto {
        val textBody = text.toRequestBody("text/plain".toMediaTypeOrNull())
        return api.createSource(
            type = "text",
            text = textBody
        )
    }

    suspend fun uploadFile(type: String, filePart: MultipartBody.Part): SourceDto {
        return api.createSource(
            type = type,
            file = filePart
        )
    }

    suspend fun getSources(): List<SourceDto> {
        return api.getSources()
    }

    suspend fun getSource(id: Long): SourceDto {
        return api.getSource(id)
    }
}
