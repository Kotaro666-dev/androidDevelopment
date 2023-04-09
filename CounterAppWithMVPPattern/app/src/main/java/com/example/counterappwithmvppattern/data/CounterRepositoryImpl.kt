package com.example.counterappwithmvppattern.data

import com.example.counterappwithmvppattern.model.Counter
import javax.inject.Inject

class CounterRepositoryImpl @Inject constructor() : CounterRepository {
    private var counter = Counter(0)

    override fun getCounter(): Counter {
        return counter
    }

    override fun incrementCounter() {
        val currentCount = counter.count
        counter = Counter(currentCount + 1)
    }

    override fun decrementCounter() {
        val currentCount = counter.count
        if (currentCount <= 0) {
            return
        }
        counter = Counter(currentCount - 1)
    }
}