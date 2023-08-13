package com.example.koin_ktor_sample.data

import com.example.koin_ktor_sample.model.Weather

interface WeatherRepository {
    fun getCurrentWeather(): Weather?
}

class WeatherRepositoryImpl : WeatherRepository {
    override fun getCurrentWeather(): Weather {
        return Weather(temperature = 33.0)
    }
}