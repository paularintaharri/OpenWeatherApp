package com.example

import com.example.database.DAOFacadeImpl
import com.example.database.DatabaseSingleton
import com.example.plugins.configureRouting
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.testing.*
import kotlinx.coroutines.runBlocking
import module
import org.junit.*
import kotlin.test.assertEquals

class ApplicationTest {

    @Before
    fun setUp() {
        DatabaseSingleton.initDatabase("jdbc:h2:file:./build/dbTEST")
        val testDatabase = DAOFacadeImpl()
        runBlocking {
            testDatabase.addNewDay("2024-01-13", 25.0, 15.0)
            testDatabase.addNewDay("2024-01-14", 24.0, 10.0)
            testDatabase.addNewDay("2024-01-15", 14.0, 2.0)
        }
    }

    @Test
    fun testGetAllDays() = testApplication {
        application {
            configureRouting()
            install(ContentNegotiation) {
                json()
            }
        }
        val response = client.get("/days")
        assertEquals(HttpStatusCode.OK, response.status)
    }


    @Test
    fun testGetDayById() = testApplication {
        application {
            configureRouting()
            install(ContentNegotiation) {
                json()
            }
        }
        val response = client.get("/days/1")
        assertEquals(HttpStatusCode.OK, response.status)
    }


    @Test
    fun testCreateNewDay() = testApplication {
        application {
            configureRouting()
            install(ContentNegotiation) {
                json()
            }
        }
        val response = client.post("/days")
        assertEquals(HttpStatusCode.OK, response.status)
    }

    @Test
    fun testUpdateDay() = testApplication {
        application {
            configureRouting()
            install(ContentNegotiation) {
                json()
            }
        }
        val response = client.put("/days/1")
        assertEquals(HttpStatusCode.OK, response.status)
    }

    @Test
    fun testDeleteDay() = testApplication {
        application {
            configureRouting()
            install(ContentNegotiation) {
                json()
            }
        }
        val response = client.delete("/days/1")
        assertEquals(HttpStatusCode.OK, response.status)
    }

    @After
    fun tearDown() {
        val testDatabase = DAOFacadeImpl()
        runBlocking {
            testDatabase.close()
        }
    }

}

