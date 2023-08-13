package com.example.koin_ktor_sample.weather

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.koin_ktor_sample.model.Weather
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun WeatherScreenRoot(viewModel: WeatherViewModel = koinViewModel()) {

    LaunchedEffect(key1 = Unit) {
        viewModel.updateCurrentWeather()
    }

    val weather = viewModel.currentWeather.collectAsStateWithLifecycle()

    Scaffold { contentPadding ->
        // ローディング中だった場合、LoadingIndicator を表示する
        WeatherScreenBody(
            contentPadding = contentPadding,
            weather = weather.value
        )
    }

}

@Composable
private fun WeatherScreenBody(
    contentPadding: PaddingValues,
    weather: Weather,
) {
    Column {
        Text(text = "Current temperature: ${weather.temperature}")
    }
}