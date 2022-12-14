package com.example.myforecast.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.myforecast.data.storage.Weather
import com.example.myforecast.databinding.ActivityEditBinding
import com.example.myforecast.domain.usecase.Examination
import com.example.myforecast.presentation.app.WeatherApplication
import com.example.myforecast.presentation.viewmodel.WeatherViewModel
import com.example.myforecast.presentation.viewmodel.WeatherViewModelFactory

class EditActivity : AppCompatActivity() {

    private val viewModel: WeatherViewModel by viewModels {
        WeatherViewModelFactory((application as WeatherApplication).repository)
    }
    private val examination = Examination()
    private lateinit var binding: ActivityEditBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btSave.setOnClickListener {
            val weather = Weather(
                id = null,
                nameCity = binding.edNameCity.text.toString(),
                populationCity = binding.edPopulation.text.toString(),
                weatherSum = binding.edSummer.text.toString(),
                weatherAut = binding.edAutumn.text.toString(),
                weatherWint = binding.edWinter.text.toString(),
                weatherSpring = binding.edSpring.text.toString(),
            )
            if (examination.execute(weather)) {
                Toast.makeText(this, "Прогноз добавлен", Toast.LENGTH_SHORT).show()
                viewModel.insert(weather)
                finish()
            } else {
                Toast.makeText(this, "Не заполнено одно из полей", Toast.LENGTH_SHORT).show()
            }
        }
    }
}