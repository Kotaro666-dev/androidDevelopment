package com.example.httpgetpractice.main

import com.example.httpgetpractice.model.CustomerInfo
import com.example.httpgetpractice.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainUseCase(
    private val repository: Repository
) {

    suspend fun fetchCustomerInfo() {
        withContext(Dispatchers.IO) {
            // call http repository
            repository.fetchCustomerInfo()
            // Insert room
            repository.insert()
        }
    }

    suspend fun displayCustomerInfo(): CustomerInfo? {
        var customerInfo: CustomerInfo?
        withContext(Dispatchers.IO) {
            customerInfo = repository.get()
        }
        return customerInfo
    }
}