package com.example.okhttpretryrequestsample.repository

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class ApiClient {
    companion object {
//        private const val URL = "https://catfact.ninja/fact"
        private const val URL = "https://catfact.ninja/this_path_does_not_exist"
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(RetryInterceptor())
        .build()

    fun get(): String {
        val request = Request.Builder()
            .url(URL)
            .build()

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) {
                throw IOException("Unexpected code $response")
            }

            return response.body?.string().orEmpty()
        }
    }
}

// 参考資料：https://square.github.io/okhttp/interceptors/
class RetryInterceptor : Interceptor {
    companion object {
        private const val MAX_RETRY_COUNT = 3
        private const val FORMAT_PATTERN = "yyyy/MM/dd/HH:mm:ss.SSS"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        // 最初のリクエストを行う
        var response = chain.proceed(request)

        var retryCount = 0
        // リクエストに失敗した場合には最大3回のリトライを行う
        while (!response.isSuccessful && retryCount < MAX_RETRY_COUNT) {
            println("リトライ回数: $retryCount（${getCurrentTime()}）")
            retryCount++

            // リトライ前に取得済みのレスポンスをクローズ
            response.close()
            // リクエストをリトライ
            response = chain.proceed(request)
        }
        return response
    }

    private fun getCurrentTime(): String {
        val date = Date(System.currentTimeMillis())
        val dateFormat = SimpleDateFormat(FORMAT_PATTERN, Locale.JAPANESE)
        return dateFormat.format(date)
    }
}