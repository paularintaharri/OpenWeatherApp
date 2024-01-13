import com.example.database.*
import com.example.model.WeatherApiDayData
import com.example.plugins.*
import com.example.service.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import kotlinx.coroutines.runBlocking

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    DatabaseSingleton.initDatabase()
    configureRouting()
    runBlocking {
        // Fetch data from https://weather.visualcrossing.com Api
        val days = fetchWeatherData("Helsinki")
        // Insert data to sqlite db
        insertData(days)
    }
}

suspend fun insertData(days: List<WeatherApiDayData>) {
    val database = DAOFacadeImpl()
    for (day in days) {
        database.addNewDay(day.datetime, day.maxTemperature, day.minTemperature)
    }
}
