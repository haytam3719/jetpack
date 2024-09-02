package com.jetpackapp.compose.ui.intent

sealed class WeatherIntent {
    object FetchWeather : WeatherIntent()
}
