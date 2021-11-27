package com.example.practiceviewmodelandlivedata.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int> get() = _score

    private val _isMilestone = MutableLiveData<Boolean>()
    val isMilestone: LiveData<Boolean> get() = _isMilestone

    init {
        _score.value = 0
    }

    fun onTapPlus() {
        _score.value = (score.value)?.plus(1)
        if (_score.value?.rem(10) ?: 0 == 0) {
            _isMilestone.value = true
        }
    }

    fun onTapMinus() {
        if (_score.value == 0) {
            return
        }
        _score.value = (score.value)?.minus(1)
    }

    fun resetMileStone() {
        _isMilestone.value = false
    }
}