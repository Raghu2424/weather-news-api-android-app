package com.example.weatherapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import kotlinx.coroutines.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var weatherText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        weatherText = TextView(this)
        setContentView(weatherText)

        getWeather()
    }

    private fun getWeather() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(ApiService::class.java)

        GlobalScope.launch(Dispatchers.IO) {
            try {
                val response = api.getWeather("London", "YOUR_API_KEY")
                runOnUiThread {
                    weatherText.text = "Temperature: ${response.main.temp}"
                }
            } catch (e: Exception) {
                runOnUiThread {
                    weatherText.text = "Error loading data"
                }
            }
        }
    }
}
