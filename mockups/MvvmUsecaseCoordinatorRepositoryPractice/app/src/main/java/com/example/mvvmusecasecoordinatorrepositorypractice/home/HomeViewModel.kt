package com.example.mvvmusecasecoordinatorrepositorypractice.home

import android.content.Context
import androidx.lifecycle.ViewModel

class HomeViewModel(
    private val coordinator: HomeCoordinator,
    private val useCase: HomeUseCase,
) : ViewModel() {

    fun goToAddTodoScreen(context: Context) {
        coordinator.start(context)
    }
}