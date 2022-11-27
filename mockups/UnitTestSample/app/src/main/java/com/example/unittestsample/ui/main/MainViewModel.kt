package com.example.unittestsample.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _isVisible = MutableLiveData<Boolean>()
    val isVisible: MutableLiveData<Boolean>
        get() = _isVisible

    init {
        val targetDate = getTargetDate()
        _isVisible.postValue(isDateInRange(targetDate))
    }

    /**
     * 通常であればリポジトリから引っ張る
     */
    private fun getTargetDate(): String {
        // ここでは仮の日付を返します
        return "20220115"
    }

    /**
     *　日付が 10 日から 20 日の間であるかを判定する
     */
    fun isDateInRange(date: String): Boolean {
        if (date.length != DATE_EXPECTED_LENGTH) {
            return false
        }
        val day = date.substring(START_INDEX)
        if (day in STARTING_DAY..ENDING_DAY) {
            return true
        }
        return false
    }

    companion object {
        private const val DATE_EXPECTED_LENGTH = 8
        private const val STARTING_DAY = "10"
        private const val ENDING_DAY = "20"
        private const val START_INDEX = 6
    }
}