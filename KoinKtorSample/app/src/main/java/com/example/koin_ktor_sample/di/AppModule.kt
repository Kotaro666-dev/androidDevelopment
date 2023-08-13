package com.example.koin_ktor_sample.di

import com.example.koin_ktor_sample.data.WeatherRepository
import com.example.koin_ktor_sample.data.WeatherRepositoryImpl
import com.example.koin_ktor_sample.weather.WeatherViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<WeatherRepository> { WeatherRepositoryImpl() }
    viewModel { WeatherViewModel(get<WeatherRepository>()) }
}