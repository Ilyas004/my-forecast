package com.example.myforecast.presentation.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myforecast.data.storage.Weather
import com.example.myforecast.databinding.ActivityMainBinding
import com.example.myforecast.presentation.adapter.ListForecastAdapter
import com.example.myforecast.presentation.app.WeatherApplication
import com.example.myforecast.presentation.viewmodel.WeatherViewModel
import com.example.myforecast.presentation.viewmodel.WeatherViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ListForecastAdapter

    private val viewModel: WeatherViewModel by viewModels {
        WeatherViewModelFactory((application as WeatherApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = ListForecastAdapter()
        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = LinearLayoutManager(this)

        viewModel.allForecast.observe(this, Observer { forecast ->
            forecast?.let { adapter.submitList(it) }
        })

        binding.btAddCity.setOnClickListener {
            intent = Intent(this, EditActivity::class.java)
            startActivity(intent)
        }

    }
}