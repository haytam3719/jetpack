package com.jetpackapp.compose.ui.state

import com.jetpackapp.compose.model.WeatherForecast

data class WeatherViewState(
    val isLoading: Boolean = false,
    val weatherList: List<WeatherForecast>? = null,
    val error: String? = null
)
