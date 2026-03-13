package com.example.weatherapp

data class WeatherResponse(
    val main: Main
)

data class Main(
    val temp: Double
)
