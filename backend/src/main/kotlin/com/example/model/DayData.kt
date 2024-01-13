package com.example.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Table

@Serializable
data class DayData(
    val id: Int,
    @SerialName("datetime")
    val datetime: String,
    @SerialName("tempmax")
    val maxTemperature: Double,
    @SerialName("tempmin")
    val minTemperature: Double
)
object Days : Table() {
    val id = integer("id").autoIncrement()
    val datetime = varchar("datetime", 255)
    val maxTemperature = double("max_temperature")
    val minTemperature = double("min_temperature")

    override val primaryKey = PrimaryKey(id)
}
