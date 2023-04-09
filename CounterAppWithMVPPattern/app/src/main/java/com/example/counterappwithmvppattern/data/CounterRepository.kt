package com.example.counterappwithmvppattern.data

import com.example.counterappwithmvppattern.model.Counter
import kotlinx.coroutines.flow.Flow

interface CounterRepository {
    fun getCounter(): Flow<Counter>
    fun incrementCounter()
    fun decrementCounter()
}