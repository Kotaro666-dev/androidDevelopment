package com.example.httpgetpractice.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModelFactory(
    private val coordinator: MainCoordinator,
    private val useCase: MainUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(coordinator, useCase) as T
    }

}