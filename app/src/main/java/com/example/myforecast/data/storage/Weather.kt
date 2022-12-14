package com.example.myforecast.data.storage

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather_table")
data class Weather(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    @ColumnInfo(name = "name_city") val nameCity: String,
    @ColumnInfo(name = "population_city") val populationCity: String,
    @ColumnInfo(name = "summer") val weatherSum: String,
    @ColumnInfo(name = "autumn") val weatherAut: String,
    @ColumnInfo(name = "winter") val weatherWint: String,
    @ColumnInfo(name = "spring") val weatherSpring: String
)
