package com.example.mvvmusecasecoordinatorrepositorypractice

import androidx.lifecycle.LiveData
import com.example.mvvmusecasecoordinatorrepositorypractice.database.AppDatabase
import com.example.mvvmusecasecoordinatorrepositorypractice.database.TodoDataClass


class Repository(private val database: AppDatabase) {
    fun getTodoList(): LiveData<List<TodoDataClass>> {
        return database.todoDatabaseDao().getAllTodos()
    }

    fun addTodo(todo: TodoDataClass) {
        database.todoDatabaseDao().insert(todo)
    }
}