package com.example.httpgetpractice.menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MenuViewModelFactory(
    private val coordinator: MenuCoordinator,
    private val useCase: MenuUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MenuViewModel(coordinator, useCase) as T
    }
}