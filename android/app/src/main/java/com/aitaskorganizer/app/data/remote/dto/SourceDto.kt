package com.aitaskorganizer.app.data.remote.dto

import com.google.gson.annotations.SerializedName

data class SourceDto(
    val id: Long,
    val type: String,
    val filename: String?,
    @SerializedName("original_text")
    val originalText: String?,
    @SerializedName("created_at")
    val createdAt: String
)
