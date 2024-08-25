package com.jetpackapp.compose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class WeatherForecast(
    val day: String,
    val temperature: String,
    val description: String
)


@Composable
fun DailyForecastColumn(forecastList: List<WeatherForecast>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        items(forecastList) { forecast ->
            WeatherForecastRow(
                time = forecast.day,
                temperature = forecast.temperature,
                description = forecast.description
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDailyForecastColumn() {
    DailyForecastColumn(
        forecastList = listOf(
            WeatherForecast(day = "Monday", temperature = "26", description = "Sunny"),
            WeatherForecast(day = "Tuesday", temperature = "22", description = "Rainy"),
            WeatherForecast(day = "Wednesday", temperature = "24", description = "Cloudy"),
            WeatherForecast(day = "Thursday", temperature = "25", description = "Partly Cloudy"),
            WeatherForecast(day = "Friday", temperature = "27", description = "Sunny")
        )
    )
}
