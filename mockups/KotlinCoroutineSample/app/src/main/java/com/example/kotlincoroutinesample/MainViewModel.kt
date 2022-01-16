package com.example.kotlincoroutinesample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

class MainViewModel : ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _dataFromApi1 = MutableLiveData<String>()
    val dataFromApi1: LiveData<String> = _dataFromApi1

    private val _dataFromApi2 = MutableLiveData<String>()
    val dataFromApi2: LiveData<String> = _dataFromApi2

    private val _dataFromApi3 = MutableLiveData<String>()
    val dataFromApi3: LiveData<String> = _dataFromApi3

    /**
     * 並行処理
     */
    fun requestApi() {
        viewModelScope.launch {
            _isLoading.value = true
            fetchApi1()
            fetchApi2()
            fetchApi3()
            _isLoading.value = false
        }
    }

    /**
     * 並列処理 with async/await
     */
    fun requestApiWithAsyncAndAwait() {
        viewModelScope.launch {
            _isLoading.value = true
            val apiAsyncList = listOf(
                async { fetchApi1() },
                async { fetchApi2() },
                async { fetchApi3() },
            )
            apiAsyncList.awaitAll()
            _isLoading.value = false
        }
    }

    /**
     * 並列処理 with launch/join
     */
    fun requestApiWithLaunchAndJoin() {
        viewModelScope.launch {
            _isLoading.value = true
            val apiJobsList = listOf(
                launch { fetchApi1() },
                launch { fetchApi2() },
                launch { fetchApi3() },
            )
            apiJobsList.joinAll()
            _isLoading.value = false
        }
    }

    private suspend fun fetchApi1() = withContext(Dispatchers.IO) {
        delay(3_000)
        _dataFromApi1.postValue("Kotlin")
    }

    private suspend fun fetchApi2() = withContext(Dispatchers.IO) {
        delay(3_000)
        _dataFromApi2.postValue("Is")
    }

    private suspend fun fetchApi3() = withContext(Dispatchers.IO) {
        delay(3_000)
        _dataFromApi3.postValue("Great")
    }
}