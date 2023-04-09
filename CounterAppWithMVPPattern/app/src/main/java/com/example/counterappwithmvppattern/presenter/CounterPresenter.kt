package com.example.counterappwithmvppattern.presenter

interface CounterPresenter {
    fun loadCounter()
    fun onIncrementButtonClicked()
    fun onDecrementButtonClicked()
}