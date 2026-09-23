package com.aitaskorganizer.app.data.repository

import com.aitaskorganizer.app.data.local.dao.ReminderDao
import com.aitaskorganizer.app.data.local.entities.ReminderEntity
import kotlinx.coroutines.flow.Flow

class ReminderRepository(private val reminderDao: ReminderDao) {
    fun getRemindersForTask(taskId: Long): Flow<List<ReminderEntity>> {
        return reminderDao.getRemindersForTask(taskId)
    }

    suspend fun getReminderById(id: Long): ReminderEntity? {
        return reminderDao.getReminderById(id)
    }

    suspend fun getAllActiveReminders(): List<ReminderEntity> {
        return reminderDao.getAllActiveReminders()
    }

    suspend fun insertReminder(reminder: ReminderEntity): Long {
        return reminderDao.insertReminder(reminder)
    }

    suspend fun updateReminder(reminder: ReminderEntity) {
        reminderDao.updateReminder(reminder)
    }

    suspend fun deleteReminder(reminder: ReminderEntity) {
        reminderDao.deleteReminder(reminder)
    }

    suspend fun deleteRemindersForTask(taskId: Long) {
        reminderDao.deleteRemindersForTask(taskId)
    }
}
