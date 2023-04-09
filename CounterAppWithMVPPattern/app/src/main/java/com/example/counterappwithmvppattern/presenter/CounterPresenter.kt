package com.example.counterappwithmvppattern.presenter

interface CounterPresenter {
    fun updateCounterView()
    fun onIncrementButtonClicked()
    fun onDecrementButtonClicked()
}