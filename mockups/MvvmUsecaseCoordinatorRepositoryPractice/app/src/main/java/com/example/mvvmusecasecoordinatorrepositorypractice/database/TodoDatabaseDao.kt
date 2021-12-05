package com.example.mvvmusecasecoordinatorrepositorypractice.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TodoDatabaseDao {
    @Insert
    suspend fun insert(todo: TodoDataClass)

    @Update
    suspend fun update(todo: TodoDataClass)

    @Query("DELETE FROM todo_table")
    suspend fun clear()

    @Query("SELECT * FROM todo_table ORDER BY id DESC")
    fun getAllTodos(): LiveData<List<TodoDataClass>>
}