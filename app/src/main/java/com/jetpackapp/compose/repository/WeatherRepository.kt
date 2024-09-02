package com.jetpackapp.compose.repository

import com.jetpackapp.compose.model.WeatherForecast
import com.jetpackapp.compose.network.WeatherApi
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val api: WeatherApi) {

    suspend fun getWeatherForecast(city: String, apiKey: String): List<WeatherForecast> {
        val response = api.getWeatherForecast(city = city, apiKey = apiKey)

        return response.list.map { forecast ->
            WeatherForecast(
                day = forecast.dt_txt,
                temperature = forecast.main.temp.toString(),
                description = forecast.weather[0].description
            )
        }
    }
}
