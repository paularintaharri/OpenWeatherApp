package com.example.plugins

import com.example.database.DAOFacadeImpl
import com.example.model.DayData
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.util.*

fun Application.configureRouting() {
    val database = DAOFacadeImpl()

    routing {

        // Read all days
        get ("/days"){
            val days = database.allDays()
            call.respond(days)
        }

        // TODO Fix the POST call, currently returns 415 Unsupported Media Type error
        // Create new day
        post("/days") {
            val dayData = call.receive<DayData>()
            val day = database.addNewDay(dayData.datetime, dayData.maxTemperature, dayData.minTemperature)
            if (day != null) {
                call.respond(HttpStatusCode.Created, day.id)
            } else {
                call.respondText("Date not found", ContentType.Text.Html)
            }
        }

        // Read day by id
        get("/days/{id}") {
            val id = call.parameters.getOrFail<Int>("id").toInt()
            val day = database.day(id)
            if (day != null) {
                call.respond(day)
            } else {
                call.respondText("Creation failed")
            }
        }

        // TODO Fix the PUT call
        // Update day
        put("days/{id}") {
            val id = call.parameters.getOrFail<Int>("id").toInt()
            val formParameters = call.receiveParameters()
            val datetime = formParameters.getOrFail("datetime")
            val maxTemperature = formParameters.getOrFail("maxTemperature").toDouble()
            val minTemperature = formParameters.getOrFail("minTemperature").toDouble()

            if (database.updateDay(id, datetime, maxTemperature, minTemperature)) {
                call.respondText("Day updated successfully", ContentType.Text.Html)
            } else {
                call.respondText("Day not found or update failed", ContentType.Text.Html, HttpStatusCode.NotFound)
            }
        }

        // Delete day
        delete("days/{id}") {
            val id = call.parameters.getOrFail<Int>("id").toInt()
            if (database.deleteDay(id)) {
                call.respondText("Day deleted successfully", ContentType.Text.Html, HttpStatusCode.OK)
            } else {
                call.respondText("Day not found or delete failed", ContentType.Text.Html, HttpStatusCode.NotFound)
            }
        }
    }
}

