package com.example.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherApiResponse(
    val days: List<WeatherApiDayData>
)
@Serializable
data class WeatherApiDayData(
    @SerialName("datetime")
    val datetime: String,
    @SerialName("tempmax")
    val maxTemperature: Double,
    @SerialName("tempmin")
    val minTemperature: Double,
)