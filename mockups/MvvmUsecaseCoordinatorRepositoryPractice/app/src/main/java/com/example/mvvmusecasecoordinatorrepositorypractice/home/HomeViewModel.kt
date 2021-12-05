package com.example.mvvmusecasecoordinatorrepositorypractice.home

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmusecasecoordinatorrepositorypractice.database.TodoDataClass
import kotlinx.coroutines.launch


class HomeViewModel(
    private val coordinator: HomeCoordinator,
    private val useCase: HomeUseCase,
) : ViewModel() {

    private val _todoList = useCase.getTodoList()
    val todoList: LiveData<List<TodoDataClass>>
        get() = _todoList

    fun goToAddTodoScreen(context: Context) {
        coordinator.start(context)
    }

    fun clearTodoList() {
        viewModelScope.launch {
            useCase.clearTodoList()
        }
    }
}