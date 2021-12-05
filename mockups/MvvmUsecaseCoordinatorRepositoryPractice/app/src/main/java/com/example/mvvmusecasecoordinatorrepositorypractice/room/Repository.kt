package com.example.mvvmusecasecoordinatorrepositorypractice.room

import androidx.lifecycle.LiveData
import com.example.mvvmusecasecoordinatorrepositorypractice.database.AppDatabase
import com.example.mvvmusecasecoordinatorrepositorypractice.database.TodoDataClass
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class Repository(private val database: AppDatabase) {
    fun getTodoList(): LiveData<List<TodoDataClass>> {
        return database.todoDatabaseDao().getAllTodos()
    }

    suspend fun addTodo(todo: TodoDataClass) {
        withContext(Dispatchers.IO) {
            database.todoDatabaseDao().insert(todo)
        }
    }
}