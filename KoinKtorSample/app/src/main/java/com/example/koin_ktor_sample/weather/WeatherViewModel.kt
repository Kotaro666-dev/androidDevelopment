package com.example.koin_ktor_sample.weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.koin_ktor_sample.data.WeatherRepository
import com.example.koin_ktor_sample.model.Weather
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch

class WeatherViewModel(private val repository: WeatherRepository) : ViewModel() {

   val weatherUiState: StateFlow<WeatherUiState> = combine(

   )

    fun updateCurrentWeather() {
        viewModelScope.launch {
            repository.getCurrentWeather().let { weather ->
                _currentWeather.value = weather ?: Weather(temperature = 0.0)
            }
        }
    }
}