package com.example.httpgetpractice.repository

import okhttp3.*
import okio.IOException


class Repository {

    companion object {
        private const val LOCALHOST_IP_ADDRESS = "10.18.126.135"
        const val URL = "http://$LOCALHOST_IP_ADDRESS:8080"
    }

    private val client = OkHttpClient()

    fun fetchCustomerInfo() {
        val request = Request.Builder()
            .url(URL)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                response.use {
                    if (!response.isSuccessful) throw IOException("Unexpected code $response")

                    println(response.body!!.string())
                }
            }
        })
    }

    fun insert() {

    }
}