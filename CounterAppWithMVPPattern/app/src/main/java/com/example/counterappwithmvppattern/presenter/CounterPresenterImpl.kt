package com.example.counterappwithmvppattern.presenter

import com.example.counterappwithmvppattern.data.CounterRepository
import com.example.counterappwithmvppattern.ui.CounterView
import javax.inject.Inject

class CounterPresenterImpl @Inject constructor(
    private val view: CounterView,
    private val repository: CounterRepository
) : CounterPresenter {

    override fun updateCounterView() {
        val currentCount = repository.getCounter().count
        view.showCount(currentCount)
    }

    override fun onIncrementButtonClicked() {
        repository.incrementCounter()
        updateCounterView()
    }

    override fun onDecrementButtonClicked() {
        repository.decrementCounter()
        updateCounterView()
    }
}