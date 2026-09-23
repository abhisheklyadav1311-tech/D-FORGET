package com.aitaskorganizer.app.data.local.database

import androidx.room.TypeConverter
import com.aitaskorganizer.app.data.model.Priority
import com.aitaskorganizer.app.data.model.TaskStatus
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Converters {
    private val formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME

    @TypeConverter
    fun fromTimestamp(value: String?): LocalDateTime? {
        return value?.let { LocalDateTime.parse(it, formatter) }
    }

    @TypeConverter
    fun dateToTimestamp(date: LocalDateTime?): String? {
        return date?.format(formatter)
    }

    @TypeConverter
    fun fromPriority(priority: Priority): String {
        return priority.name
    }

    @TypeConverter
    fun toPriority(value: String): Priority {
        return Priority.valueOf(value)
    }

    @TypeConverter
    fun fromStatus(status: TaskStatus): String {
        return status.name
    }

    @TypeConverter
    fun toStatus(value: String): TaskStatus {
        return TaskStatus.valueOf(value)
    }
}
