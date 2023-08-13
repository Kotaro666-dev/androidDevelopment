package com.example.koin_ktor_sample.weather

import com.example.koin_ktor_sample.model.Weather

sealed class WeatherUiState {
    data class Success(val weather: Weather) : WeatherUiState()

    data object Loading : WeatherUiState()

    data object Error : WeatherUiState()
}
