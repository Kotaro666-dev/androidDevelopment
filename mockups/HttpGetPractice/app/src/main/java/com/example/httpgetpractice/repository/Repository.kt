package com.example.httpgetpractice.repository

import com.example.httpgetpractice.room.CustomerDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject


class Repository(
    private val customerDatabase: CustomerDatabase
) {

    companion object {
        private const val LOCALHOST_IP_ADDRESS = "192.168.11.10"
        const val URL = "http://$LOCALHOST_IP_ADDRESS:8080"
    }

    private val client = OkHttpClient()
    private var result: JSONObject? = null

    fun get(url: String): JSONObject {
        val request = Request.Builder()
            .url(url)
            .build()
        val response = client.newCall(request).execute()
        return JSONObject(response.body?.string().orEmpty())
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

    fun insert() {
        println(result)
    }
}