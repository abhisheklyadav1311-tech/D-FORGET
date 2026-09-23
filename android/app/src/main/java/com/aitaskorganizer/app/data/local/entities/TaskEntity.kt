package com.aitaskorganizer.app.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.aitaskorganizer.app.data.model.Priority
import com.aitaskorganizer.app.data.model.TaskStatus
import java.time.LocalDateTime

@Entity(tableName = "tasks")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String,
    val description: String,
    val deadline: LocalDateTime?,
    val priority: Priority,
    val category: String,
    val subject: String,
    val status: TaskStatus,
    val isAiGenerated: Boolean,
    val sourceId: Long?,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
    val completedAt: LocalDateTime? = null
)
