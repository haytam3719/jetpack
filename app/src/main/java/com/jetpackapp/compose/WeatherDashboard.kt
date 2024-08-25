package com.jetpackapp.compose

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WeatherDashboardLayout() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        WeatherInfoCard(city = "Casablanca", temperature = "26", description = "Sunny")
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Hourly Forecast",
            style = MaterialTheme.typography.headlineSmall.copy(
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color(0xFF1E88E5)
        ))
        DailyForecastColumn(forecastList = listOf(
            WeatherForecast(day = "Monday", temperature = "26", description = "Sunny"),
            WeatherForecast(day = "Tuesday", temperature = "22", description = "Rainy"),
            WeatherForecast(day = "Wednesday", temperature = "24", description = "Cloudy"),
            WeatherForecast(day = "Thursday", temperature = "25", description = "Partly Cloudy"),
            WeatherForecast(day = "Friday", temperature = "27", description = "Sunny")
        ))
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Weather Details",style = MaterialTheme.typography.headlineSmall.copy(
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color(0xFFFFC107)
        ))
        WeatherDetailsGrid()
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewWeatherDashboardLayout() {
    WeatherDashboardLayout()
}
