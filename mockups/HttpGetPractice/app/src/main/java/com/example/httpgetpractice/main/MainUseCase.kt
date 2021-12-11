package com.example.httpgetpractice.main

import com.example.httpgetpractice.repository.Repository

class MainUseCase(
    private val repository: Repository
) {

    fun getCustomerInfo() {
        // call http repository
        repository.fetchCustomerInfo()
        // Insert room
        repository.insert()
    }
}