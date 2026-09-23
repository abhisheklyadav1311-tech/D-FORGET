package com.aitaskorganizer.app.data.model

import com.aitaskorganizer.app.data.local.entities.TaskEntity

/**
 * Maps Room [TaskEntity] to UI-layer [TaskUiModel].
 *
 * TaskEntity is the database representation; TaskUiModel is the display model
 * used by HomeScreen, TasksScreen, and TaskCard composables.
 */
fun TaskEntity.toUiModel(): TaskUiModel = TaskUiModel(
    id = id,
    title = title,
    description = description,
    deadline = deadline,
    priority = priority,
    category = category,
    subject = subject,
    status = status,
    isAiGenerated = isAiGenerated,
    hasReminder = false, // Will be enriched by reminder lookup in future
    reminderTime = null,
    sourceId = sourceId,
    createdAt = createdAt
)

/**
 * Maps a list of [TaskEntity] to [TaskUiModel].
 */
fun List<TaskEntity>.toUiModels(): List<TaskUiModel> = map { it.toUiModel() }
