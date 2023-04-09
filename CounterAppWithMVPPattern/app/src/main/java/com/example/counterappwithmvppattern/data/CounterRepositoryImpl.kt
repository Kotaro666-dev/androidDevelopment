package com.example.counterappwithmvppattern.data

import com.example.counterappwithmvppattern.model.Counter
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class CounterRepositoryImpl : CounterRepository {
    private val counterFlow = MutableStateFlow(Counter(0))

    override fun getCounter(): Flow<Counter> = counterFlow

    override fun incrementCounter() {
        val currentCount = counterFlow.value.count
        counterFlow.value = Counter(currentCount + 1)
    }

    override fun decrementCounter() {
        val currentCount = counterFlow.value.count
        counterFlow.value = Counter(currentCount - 1)
    }
}