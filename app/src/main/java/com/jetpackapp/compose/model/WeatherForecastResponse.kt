package com.jetpackapp.compose.model

data class WeatherForecastResponse(
    val list: List<Forecast>
)

data class Forecast(
    val dt_txt: String,
    val main: Main,
    val weather: List<Weather>
)

data class Main(
    val temp: Double
)

data class Weather(
    val description: String
)
