package com.example.practiceviewmodelandlivedata.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int> get() = _score

    init {
        _score.value = 0
    }

    fun onTapPlus() {
        _score.value = (score.value)?.plus(1)
    }

    fun onTapMinus() {
        if (_score.value == 0) {
            return
        }
        _score.value = (score.value)?.minus(1)
    }
}