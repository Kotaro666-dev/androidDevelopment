package com.example.okhttpretryrequestsample.repository

import com.example.okhttpretryrequestsample.model.CatFact
import com.squareup.moshi.Moshi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Repository {

    companion object {
        private const val REQUEST_FAILURE_MESSAGE = "Your request failed after 3 retries."
    }

    private val apiClient = ApiClient()

    suspend fun getText() = withContext(Dispatchers.IO) {
        try {
            val response = apiClient.get()
            return@withContext getCatFact(response)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return@withContext REQUEST_FAILURE_MESSAGE
    }

    private fun getCatFact(response: String) : String {
        val adapter = Moshi.Builder().build().adapter(CatFact::class.java)
        val data = adapter.fromJson(response)
        return data?.fact.orEmpty()
    }

}