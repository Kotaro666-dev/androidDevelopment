package com.example.mvvmusecasecoordinatorrepositorypractice.home

import androidx.lifecycle.LiveData
import com.example.mvvmusecasecoordinatorrepositorypractice.database.TodoDataClass
import com.example.mvvmusecasecoordinatorrepositorypractice.room.Repository

class HomeUseCase(
    private val repository: Repository
) {
    fun getTodoList(): LiveData<List<TodoDataClass>> {
        return repository.getTodoList()
    }

    suspend fun clearTodoList() {
        repository.clearTodoList()
    }
}