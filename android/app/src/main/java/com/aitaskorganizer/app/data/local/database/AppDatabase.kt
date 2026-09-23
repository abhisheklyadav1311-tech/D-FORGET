package com.aitaskorganizer.app.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.aitaskorganizer.app.data.local.dao.ReminderDao
import com.aitaskorganizer.app.data.local.dao.TaskDao
import com.aitaskorganizer.app.data.local.entities.ReminderEntity
import com.aitaskorganizer.app.data.local.entities.TaskEntity

@Database(entities = [TaskEntity::class, ReminderEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
    abstract fun reminderDao(): ReminderDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "ai_task_organizer_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
