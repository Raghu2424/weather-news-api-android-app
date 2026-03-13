package com.example.weatherapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers

class WeatherViewModel : ViewModel() {

    private val repository = Repository()

    fun getWeather(city: String, apiKey: String) = liveData(Dispatchers.IO) {
        val data = repository.getWeather(city, apiKey)
        emit(data)
    }
}
