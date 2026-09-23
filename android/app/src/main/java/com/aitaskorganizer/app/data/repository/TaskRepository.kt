package com.aitaskorganizer.app.data.repository

import com.aitaskorganizer.app.data.local.dao.TaskDao
import com.aitaskorganizer.app.data.local.entities.TaskEntity
import com.aitaskorganizer.app.data.model.TaskStatus
import kotlinx.coroutines.flow.Flow
import java.time.LocalDateTime

class TaskRepository(private val taskDao: TaskDao) {
    val allTasks: Flow<List<TaskEntity>> = taskDao.getAllTasks()

    fun getTasksByStatus(status: TaskStatus): Flow<List<TaskEntity>> {
        return taskDao.getTasksByStatus(status)
    }

    suspend fun getTaskById(id: Long): TaskEntity? {
        return taskDao.getTaskById(id)
    }

    suspend fun insertTask(task: TaskEntity): Long {
        return taskDao.insertTask(task)
    }

    suspend fun updateTask(task: TaskEntity) {
        taskDao.updateTask(task)
    }

    suspend fun deleteTask(task: TaskEntity) {
        taskDao.deleteTask(task)
    }

    suspend fun updateTaskStatus(id: Long, status: TaskStatus, completedAt: LocalDateTime? = null) {
        taskDao.updateTaskStatus(id, status, completedAt)
    }
}
