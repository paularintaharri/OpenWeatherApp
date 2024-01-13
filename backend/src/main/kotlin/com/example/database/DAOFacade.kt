package com.example.database
import com.example.model.*

interface DAOFacade {
    suspend fun allDays(): List<DayData>
    suspend fun day(id: Int): DayData?
    suspend fun addNewDay(datetime: String, maxTemperature: Double, minTemperature: Double): DayData?
    suspend fun updateDay(id: Int, datetime: String, maxTemperature: Double, minTemperature: Double): Boolean
    suspend fun deleteDay(id: Int): Boolean
    suspend fun close()

}