package com.example.mvvmusecasecoordinatorrepositorypractice.addTodo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmusecasecoordinatorrepositorypractice.database.TodoDataClass
import kotlinx.coroutines.launch

class AddTodoViewModel(
    private val coordinator: AddTodoCoordinator,
    private val useCase: AddTodoUseCase,
) : ViewModel() {
    fun addTodo(todo: TodoDataClass) {
        viewModelScope.launch {
            useCase.addTodo(todo)
        }
    }
}