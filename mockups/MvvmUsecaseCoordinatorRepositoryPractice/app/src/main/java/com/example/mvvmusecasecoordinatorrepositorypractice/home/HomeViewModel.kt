package com.example.mvvmusecasecoordinatorrepositorypractice.home

import android.content.Context
import androidx.lifecycle.ViewModel


class HomeViewModel(
    private val coordinator: HomeCoordinator,
    useCase: HomeUseCase,
) : ViewModel() {

    private val todoList = useCase.getTodoList()
    
    fun goToAddTodoScreen(context: Context) {
        coordinator.start(context)
    }
}