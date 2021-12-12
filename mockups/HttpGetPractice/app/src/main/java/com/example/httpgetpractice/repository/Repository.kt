package com.example.httpgetpractice.repository

import com.example.httpgetpractice.const.Constants
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
    private val client = OkHttpClient()
    private val gson = Gson()
    private var result: String = ""

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
                result = get("${Constants.URL}/json")
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
            depositAmount = customerInfo.depositAmount
        )
        withContext(Dispatchers.IO) {
            customerDatabase.customerDatabaseDao.insert(customer)
        }
    }

    suspend fun get(): CustomerInfo? {
        var customer: Customer?
        withContext(Dispatchers.IO) {
            customer = customerDatabase.customerDatabaseDao.get()
        }
        if (customer == null) {
            return null
        }
        return CustomerInfo(
            id = customer!!.id,
            name = customer!!.name,
            accountNumber = customer!!.accountNumber,
            isLoggedIn = customer!!.isLoggedIn,
            depositAmount = customer!!.depositAmount
        )
    }
}