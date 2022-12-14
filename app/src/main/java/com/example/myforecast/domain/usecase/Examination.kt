package com.example.myforecast.domain.usecase

import com.example.myforecast.data.storage.Weather

class Examination() {

    fun execute(weather: Weather): Boolean {
        return (weather.nameCity.isNotEmpty()
                && weather.populationCity.isNotEmpty()
                && weather.weatherSum.isNotEmpty()
                && weather.weatherAut.isNotEmpty()
                && weather.weatherSpring.isNotEmpty()
                && weather.weatherWint.isNotEmpty())
    }

}