package com.example.myforecast.data.storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherDao {

    @Insert(entity = Weather::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun addForecast(weather: Weather)


    @Query("SELECT * FROM weather_table ORDER BY id ASC")
    fun readAllData(): Flow<List<Weather>>

}