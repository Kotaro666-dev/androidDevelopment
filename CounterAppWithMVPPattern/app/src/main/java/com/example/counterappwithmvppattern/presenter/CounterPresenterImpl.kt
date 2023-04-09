package com.example.counterappwithmvppattern.presenter

import com.example.counterappwithmvppattern.data.CounterRepository
import com.example.counterappwithmvppattern.ui.CounterView
import javax.inject.Inject

class CounterPresenterImpl @Inject constructor(
    private val view: CounterView,
    private val repository: CounterRepository
) : CounterPresenter {


    override fun loadCounter() {
        val currentCount = repository.getCounter().count
        view.showValue(currentCount)
    }

    override fun onIncrementButtonClicked() {
        repository.incrementCounter()
        loadCounter()
    }

    override fun onDecrementButtonClicked() {
        repository.decrementCounter()
        loadCounter()
    }
}