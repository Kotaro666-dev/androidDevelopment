package com.example.mvvmusecasecoordinatorrepositorypractice.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TodoDataClass::class], version = 2, exportSchema = false)
abstract class TodoDatabase : RoomDatabase() {
    abstract val todoDatabaseDao: TodoDatabaseDao

    companion object {
        @Volatile
        private var INSTANCE: TodoDatabase? = null

        fun getInstance(context: Context): TodoDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        TodoDatabase::class.java,
                        "todo_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                        .also {
                            INSTANCE = it
                        }

                }
                return instance
            }
        }

        fun close() {
            INSTANCE?.close()
            INSTANCE = null
        }
    }
}