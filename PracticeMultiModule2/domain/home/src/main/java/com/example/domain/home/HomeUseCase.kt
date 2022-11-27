package com.example.domain.home

import com.example.repository.HomeRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeUseCase @Inject constructor(
    private val homeRepository: HomeRepository,
) {

    fun getValue() : String {
        val value = homeRepository.getValue()
        return "$value, sent by HomeUseCase"
    }
}