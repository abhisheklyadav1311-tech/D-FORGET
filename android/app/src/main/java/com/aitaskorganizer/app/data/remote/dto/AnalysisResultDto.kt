package com.aitaskorganizer.app.data.remote.dto

import com.google.gson.annotations.SerializedName

data class AnalysisResultDto(
    val summary: String,
    @SerializedName("action_required")
    val actionRequired: Boolean,
    val tasks: List<ProposedTaskDto>,
    @SerializedName("confidence_score")
    val confidenceScore: Float,
    @SerializedName("source_id")
    val sourceId: Long
)

data class ProposedTaskDto(
    val title: String,
    val description: String?,
    val deadline: String?,
    val priority: String,
    val category: String,
    val subject: String?
)
