package com.example.myforecast.presentation.app

import android.app.Application
import com.example.myforecast.data.repository.WeatherRepository
import com.example.myforecast.data.storage.WeatherDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class WeatherApplication: Application() {
    private val applicationScope = CoroutineScope(SupervisorJob())

    private val database by lazy { WeatherDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { WeatherRepository(database.weatherDao()) }
}