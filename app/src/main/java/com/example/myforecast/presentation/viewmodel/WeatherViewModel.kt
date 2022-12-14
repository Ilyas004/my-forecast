package com.example.myforecast.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.myforecast.data.repository.WeatherRepository
import com.example.myforecast.data.storage.Weather
import kotlinx.coroutines.launch

class WeatherViewModel(private val repository: WeatherRepository) : ViewModel() {
    val allForecast: LiveData<List<Weather>> = repository.allForecast.asLiveData()

    fun insert(weather: Weather) = viewModelScope.launch {
        repository.addForecast(weather)
    }

}