package com.example.service

import com.example.database.DAOFacadeImpl
import com.example.model.WeatherApiDayData
import com.example.model.WeatherApiResponse
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.json.Json
import io.github.cdimascio.dotenv.*
import io.ktor.client.engine.cio.*
import io.ktor.client.statement.*

// Fetch the weather data from https://weather.visualcrossing.com Api
suspend fun fetchWeatherData(city: String): List<WeatherApiDayData> {
    val client = HttpClient(CIO)
    val dotenv = dotenv()
    val apiKey = dotenv.get("API_KEY")

    val response =
        client.request("https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/$city?unitGroup=metric&key=$apiKey&contentType=json") {
            method = HttpMethod.Get
        }

    val weatherResponse = Json { ignoreUnknownKeys = true }.decodeFromString<WeatherApiResponse>(response.bodyAsText())
    val days = weatherResponse.days.map {
        WeatherApiDayData(
            datetime = it.datetime,
            maxTemperature = it.maxTemperature,
            minTemperature = it.minTemperature,
        )
    }

    insertData(days)

    return days
}

suspend fun insertData(days: List<WeatherApiDayData>) {
    val database = DAOFacadeImpl()
    for (day in days) {
        database.addNewDay(day.datetime, day.maxTemperature, day.minTemperature)
    }
}