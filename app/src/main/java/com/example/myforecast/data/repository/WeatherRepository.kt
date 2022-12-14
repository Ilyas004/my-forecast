package com.example.myforecast.data.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.myforecast.data.storage.Weather
import com.example.myforecast.data.storage.WeatherDao
import kotlinx.coroutines.flow.Flow

class WeatherRepository(private val weatherDao: WeatherDao) {
    val allForecast: Flow<List<Weather>> = weatherDao.readAllData()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun addForecast(weather: Weather) {
        weatherDao.addForecast(weather)
    }
}