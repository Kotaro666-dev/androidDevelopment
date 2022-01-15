package com.example.unittestsample.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _isVisible = MutableLiveData<Boolean>()
    val isVisible: MutableLiveData<Boolean>
        get() = _isVisible

    init {
        val targetDate = getTargetDate()
        _isVisible.postValue(isCurrentDateInRange(targetDate))
    }

    /**
     * 通常であればリポジトリから引っ張る
     */
    private fun getTargetDate(): String {
        return "20220119"
    }

    /**
     *　targetDate の日付が10日から20日の間であるかを判定する
     */
    private fun isCurrentDateInRange(date: String): Boolean {
        val currentDay = date.substring(START_INDEX)
        if (currentDay in STARTING_DAY..ENDING_DAY) {
            return true
        }
        return false
    }

    companion object {
        private const val STARTING_DAY = "10"
        private const val ENDING_DAY = "20"
        private const val START_INDEX = 6
    }
}