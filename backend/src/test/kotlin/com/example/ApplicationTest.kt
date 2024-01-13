package com.example

import com.example.database.DAOFacadeImpl
import com.example.database.DatabaseSingleton
import com.example.plugins.configureRouting
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlinx.coroutines.runBlocking
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

    @After
    fun tearDown() {
        val testDatabase = DAOFacadeImpl()
        runBlocking {
            testDatabase.close()
        }
    }

    @Test
    fun testGetAllDays() = testApplication {
        application {
            configureRouting()
        }
        client.get("/days").apply {
            assertEquals(HttpStatusCode.OK, status)
        }
    }

    @Test
    fun testGetDayById() = testApplication {
        application {
            configureRouting()
        }
        client.get("/days/1").apply {
            assertEquals(HttpStatusCode.OK, status)
        }
    }

    @Test
    fun testCreateNewDay() = testApplication {
        application {
            configureRouting()
        }
        client.post("/days").apply {
            assertEquals(HttpStatusCode.OK, status)
        }
    }

    @Test
    fun testUpdateDay() = testApplication {
        application {
            configureRouting()
        }
        client.put("/days/1").apply {
            assertEquals(HttpStatusCode.OK, status)
        }
    }

    @Test
    fun testDeleteDay() = testApplication {
        application {
            configureRouting()
        }
        client.delete("days/1").apply {
            assertEquals(HttpStatusCode.OK, status)        }
    }

}

