package com.example.mvvmusecasecoordinatorrepositorypractice.addTodo

import com.example.mvvmusecasecoordinatorrepositorypractice.database.TodoDataClass
import com.example.mvvmusecasecoordinatorrepositorypractice.room.Repository

class AddTodoUseCase(
    private val repository: Repository
) {
    suspend fun addTodo(todo: TodoDataClass) {
        repository.addTodo(todo)
    }
}