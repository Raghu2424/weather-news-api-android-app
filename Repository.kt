package com.example.weatherapp

class Repository {

    private val api = ApiClient.retrofit.create(ApiService::class.java)

    suspend fun getWeather(city: String, apiKey: String): WeatherResponse {
        return api.getWeather(city, apiKey)
    }
}
