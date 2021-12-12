package com.example.httpgetpractice.menu

import androidx.lifecycle.ViewModel

class MenuViewModel(
    private val coordinator: MenuCoordinator,
    private val useCase: MenuUseCase
) : ViewModel() {

}