package com.example.httpgetpractice.main

import androidx.lifecycle.ViewModel

class MainViewModel(
    private val coordinator: MainCoordinator,
    private val useCase: MainUseCase
) : ViewModel() {

    fun getCustomerInfo() {
        useCase.getCustomerInfo()
    }
}