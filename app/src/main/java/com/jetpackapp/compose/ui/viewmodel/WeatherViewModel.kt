package com.jetpackapp.compose.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jetpackapp.compose.repository.WeatherRepository
import com.jetpackapp.compose.ui.intent.WeatherIntent
import com.jetpackapp.compose.ui.state.WeatherViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository
) : ViewModel() {

    val intent = Channel<WeatherIntent>(Channel.UNLIMITED)
    private val _state = MutableStateFlow(WeatherViewState())
    val state: StateFlow<WeatherViewState> get() = _state

    init {
        handleIntents()
    }

    private fun handleIntents() {
        viewModelScope.launch {
            for (intent in intent) {
                when (intent) {
                    is WeatherIntent.FetchWeather -> fetchWeather("Casablanca", "a365d98d7a3bc9dfb5df51536e0bd76b")
                }
            }
        }
    }


    private fun fetchWeather(city: String, apiKey: String) {
        viewModelScope.launch {
            _state.value = WeatherViewState(isLoading = true)
            try {
                val weatherList = repository.getWeatherForecast(city, apiKey)
                _state.value = WeatherViewState(weatherList = weatherList)
            } catch (e: Exception) {
                _state.value = WeatherViewState(error = e.message)
            }
        }
    }
}
