package com.example.httpgetpractice.repository

import com.example.httpgetpractice.model.CustomerInfo
import com.example.httpgetpractice.room.Customer
import com.example.httpgetpractice.room.CustomerDatabase
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request


class Repository(
    private val customerDatabase: CustomerDatabase
) {

    companion object {
        private const val LOCALHOST_IP_ADDRESS = "192.168.11.10"
        const val URL = "http://$LOCALHOST_IP_ADDRESS:8080"
    }

    private val client = OkHttpClient()
    private var result: String = ""
    private val gson = Gson()

    fun get(url: String): String {
        val request = Request.Builder()
            .url(url)
            .build()
        val response = client.newCall(request).execute()
        return response.body?.string().orEmpty()
    }

    suspend fun fetchCustomerInfo() {
        withContext(Dispatchers.IO) {
            try {
                result = get(URL)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    suspend fun insert() {
        val customerInfo = gson.fromJson(result, CustomerInfo::class.java)
        val customer = Customer(
            id = customerInfo.id,
            name = customerInfo.name,
            accountNumber = customerInfo.accountNumber,
            isLoggedIn = customerInfo.isLoggedIn,
            depositNumber = customerInfo.depositNumber
        )
        withContext(Dispatchers.IO) {
            customerDatabase.customerDatabaseDao.insert(customer)
        }
    }
}