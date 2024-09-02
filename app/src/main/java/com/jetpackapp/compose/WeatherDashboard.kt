package com.jetpackapp.compose

import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jetpackapp.compose.ui.intent.WeatherIntent
import com.jetpackapp.compose.ui.viewmodel.WeatherViewModel

@Composable
fun WeatherDashboardLayout(viewModel: WeatherViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.intent.send(WeatherIntent.FetchWeather)
    }

    when {
        state.isLoading -> CircularProgressIndicator(modifier = Modifier.fillMaxSize())
        state.weatherList != null -> {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                val currentWeather = state.weatherList!!.first()
                WeatherInfoCard(
                    city = "Casablanca",
                    temperature = currentWeather.temperature,
                    description = currentWeather.description
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Hourly Forecast",
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color(0xFF1E88E5)
                    )
                )
                DailyForecastColumn(forecastList = state.weatherList)
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Weather Details",
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color(0xFFFFC107)
                    )
                )
                WeatherDetailsGrid()
            }
        }
        state.error != null -> {
            Text(
                text = state.error ?: "An error occurred",
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewWeatherDashboardLayout() {
    WeatherDashboardLayout()
}
