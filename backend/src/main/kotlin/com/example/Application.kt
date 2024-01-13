import com.example.database.*
import com.example.plugins.*
import com.example.service.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import kotlinx.coroutines.runBlocking
import io.ktor.server.plugins.cors.routing.*


fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    install(CORS) {
        anyHost()
        allowHeader(HttpHeaders.ContentType)
        allowMethod(HttpMethod.Options)
        allowMethod(HttpMethod.Put)
        allowMethod(HttpMethod.Patch)
        allowMethod(HttpMethod.Delete)
    }
    install(ContentNegotiation) {
        json()
    }
    DatabaseSingleton.initDatabase("jdbc:h2:file:./build/db")
    configureRouting()
    runBlocking {
        // Fetch data from https://weather.visualcrossing.com Api
        fetchWeatherData("Helsinki")
    }
}
