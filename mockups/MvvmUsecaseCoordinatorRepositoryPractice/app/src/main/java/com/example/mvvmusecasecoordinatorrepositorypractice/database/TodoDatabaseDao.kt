package com.example.mvvmusecasecoordinatorrepositorypractice.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TodoDatabaseDao {
    @Insert
    fun insert(todo: TodoDataClass)

    @Update
    fun update(todo: TodoDataClass)

    @Query("DELETE FROM todo_table")
    fun clear()

    @Query("SELECT * FROM todo_table ORDER BY id DESC")
    fun getAllTodos(): LiveData<List<TodoDataClass>>
}