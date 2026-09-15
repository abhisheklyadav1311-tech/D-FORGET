package com.aitaskorganizer.app.data.model

import java.time.LocalDateTime

/**
 * UI-layer task model used for display.
 *
 * This is separate from the Room entity (Phase 11).
 * Later, a mapper will convert Room entities to this model.
 */
data class TaskUiModel(
    val id: Long,
    val title: String,
    val description: String = "",
    val deadline: LocalDateTime? = null,
    val priority: Priority = Priority.MEDIUM,
    val category: String = "",
    val subject: String = "",
    val status: TaskStatus = TaskStatus.PENDING,
    val isAiGenerated: Boolean = false,
    val hasReminder: Boolean = false,
    val reminderTime: LocalDateTime? = null,
    val sourceId: Long? = null,
    val createdAt: LocalDateTime = LocalDateTime.now()
)
