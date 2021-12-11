package com.example.httpgetpractice.main

import com.example.httpgetpractice.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainUseCase(
    private val repository: Repository
) {

    suspend fun getCustomerInfo() {
        // call http repository
        withContext(Dispatchers.IO) {
            repository.fetchCustomerInfo()
        }
        // Insert room
        repository.insert()
    }
}