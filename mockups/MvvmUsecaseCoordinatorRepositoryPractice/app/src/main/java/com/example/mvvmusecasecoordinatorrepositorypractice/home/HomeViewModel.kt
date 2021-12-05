package com.example.mvvmusecasecoordinatorrepositorypractice.home

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmusecasecoordinatorrepositorypractice.database.TodoDataClass


class HomeViewModel(
    private val coordinator: HomeCoordinator,
    useCase: HomeUseCase,
) : ViewModel() {

    private val _todoList = useCase.getTodoList()
    val todoList: LiveData<List<TodoDataClass>>
        get() = _todoList

    fun goToAddTodoScreen(context: Context) {
        coordinator.start(context)
    }
}