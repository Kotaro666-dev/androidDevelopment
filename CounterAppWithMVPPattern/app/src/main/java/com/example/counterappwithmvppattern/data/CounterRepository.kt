package com.example.counterappwithmvppattern.data

import com.example.counterappwithmvppattern.model.Counter

interface CounterRepository {
    fun getCounter(): Counter
    fun incrementCounter()
    fun decrementCounter()
}