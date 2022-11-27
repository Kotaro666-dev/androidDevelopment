package com.example.repository

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeRepository @Inject constructor() {
    fun getValue(): String {
        return "This is value from Repository"
    }
}