package com.jetpackapp.compose

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WeatherForecastRow(time: String, temperature: String, description: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = time,
            style = MaterialTheme.typography.bodyLarge.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color(0xFF1E88E5)
            )
        )
        Text(
            text = "$temperature°C",
            style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                color = Color(0xFFFFC107)
            )
        )
        Text(
            text = description,
            style = MaterialTheme.typography.bodySmall.copy(
                fontWeight = FontWeight.Light,
                fontSize = 14.sp,
                color = Color(0xFF757575)
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewWeatherForecastRow() {
    WeatherForecastRow(time = "12:00 PM", temperature = "24", description = "Partly Cloudy")
}
