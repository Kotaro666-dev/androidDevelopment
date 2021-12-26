package com.example.daggerhiltandpokeapi

import com.example.daggerhiltandpokeapi.repository.Repository
import javax.inject.Inject

class MainUseCase @Inject constructor(
    private val repository: Repository
) {

    fun getTest(): String {
        return repository.getTest()
    }
}