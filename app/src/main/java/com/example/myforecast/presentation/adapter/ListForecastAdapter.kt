package com.example.myforecast.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myforecast.R
import com.example.myforecast.data.storage.Weather
import com.example.myforecast.databinding.RecyclerViewBinding

class ListForecastAdapter: ListAdapter<Weather, ListForecastAdapter.ViewHolder>(WeatherComparator()) {

     class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val binding = RecyclerViewBinding.bind(view)

        fun bind(forecastAdapter: Weather) = with(binding) {
            tvNameCity.text = forecastAdapter.nameCity
            tvPopulationCity.text = "По населенности ${forecastAdapter.populationCity}"

            btContent.setOnClickListener {
                if (frameContent.visibility == View.GONE) {
                    btContent.setImageResource(R.drawable.close_content)
                    frameContent.visibility = View.VISIBLE
                } else {
                    btContent.setImageResource(R.drawable.ic_recyc)
                    frameContent.visibility = View.GONE

                }
            }

            btSum.setOnClickListener {
                tvForecast.text = "Средняя температура за Лето = ${forecastAdapter.weatherSum}"
            }

            btAut.setOnClickListener {
                tvForecast.text = "Средняя температура за Осень = ${forecastAdapter.weatherAut}"
            }

            btWind.setOnClickListener {
                tvForecast.text = "Средняя температура за Зиму = ${forecastAdapter.weatherWint}"
            }

            btSpring.setOnClickListener {
                tvForecast.text = "Средняя температура за Весну = ${forecastAdapter.weatherSpring}"
            }
        }

        companion object {
            fun create(parent: ViewGroup): ViewHolder {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recycler_view, parent, false)
                return ViewHolder(view)
            }
        }
    }

    class WeatherComparator: DiffUtil.ItemCallback<Weather>() {
        override fun areItemsTheSame(oldItem: Weather, newItem: Weather): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Weather, newItem: Weather): Boolean {
            return  (oldItem.nameCity == newItem.nameCity
                    && oldItem.populationCity == newItem.populationCity)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current)
    }

}