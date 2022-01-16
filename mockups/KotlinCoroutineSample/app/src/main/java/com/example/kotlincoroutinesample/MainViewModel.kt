package com.example.kotlincoroutinesample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _dataFromApi1 = MutableLiveData<String>()
    val dataFromApi1: LiveData<String> = _dataFromApi1

    private val _dataFromApi2 = MutableLiveData<String>()
    val dataFromApi2: LiveData<String> = _dataFromApi2

    private val _dataFromApi3 = MutableLiveData<String>()
    val dataFromApi3: LiveData<String> = _dataFromApi3

    fun requestApi() {
        viewModelScope.launch {
            _isLoading.value = true
            fetchApi1()
            fetchApi2()
            fetchApi3()
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
        _dataFromApi3.postValue("Great!")
    }
}