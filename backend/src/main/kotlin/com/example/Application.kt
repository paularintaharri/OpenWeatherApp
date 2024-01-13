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
    DatabaseSingleton.initDatabase("jdbc:h2:file:./build/db")
    configureRouting()
    runBlocking {
        // Fetch data from https://weather.visualcrossing.com Api
        fetchWeatherData("Helsinki")
    }
}
