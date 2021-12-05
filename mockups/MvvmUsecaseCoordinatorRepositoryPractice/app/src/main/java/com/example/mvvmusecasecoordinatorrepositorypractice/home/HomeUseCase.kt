package com.example.mvvmusecasecoordinatorrepositorypractice.home

import androidx.lifecycle.LiveData
import com.example.mvvmusecasecoordinatorrepositorypractice.Repository
import com.example.mvvmusecasecoordinatorrepositorypractice.database.TodoDataClass

class HomeUseCase(
    private val repository: Repository
) {
    fun getTodoList(): LiveData<List<TodoDataClass>> {
        return repository.getTodoList()
    }
}