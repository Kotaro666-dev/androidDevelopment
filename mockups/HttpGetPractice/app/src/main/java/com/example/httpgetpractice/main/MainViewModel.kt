package com.example.httpgetpractice.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel(
    private val coordinator: MainCoordinator,
    private val useCase: MainUseCase
) : ViewModel() {

    fun getCustomerInfo() {
        viewModelScope.launch {
            useCase.getCustomerInfo()
        }
    }
}