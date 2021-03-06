package com.example.httpgetpractice.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Customer::class], version = 1, exportSchema = false)
abstract class CustomerDatabase : RoomDatabase() {

    abstract val customerDatabaseDao: CustomerDatabaseDao

    companion object {

        @Volatile
        private var INSTANCE: CustomerDatabase? = null
        private const val DATABASE_NAME = "customer_database"

        fun getInstance(context: Context): CustomerDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        CustomerDatabase::class.java,
                        DATABASE_NAME
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}