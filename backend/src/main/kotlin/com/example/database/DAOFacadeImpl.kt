package com.example.database

import com.example.model.Days
import com.example.model.DayData
import com.example.database.DatabaseSingleton.dbQuery
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq

class DAOFacadeImpl : DAOFacade {
    private fun resultRowToDay(row: ResultRow) = DayData(
        id = row[Days.id],
        datetime = row[Days.datetime],
        maxTemperature = row[Days.maxTemperature],
        minTemperature = row[Days.minTemperature],
    )

    override suspend fun allDays(): List<DayData> = dbQuery {
        Days.selectAll().map(::resultRowToDay)
    }

    override suspend fun day(id: Int): DayData? = dbQuery {
        Days
            .select { Days.id eq id }
            .map(::resultRowToDay)
            .singleOrNull()
    }

    override suspend fun addNewDay(
        datetime: String,
        maxTemperature: Double,
        minTemperature: Double
    ): DayData? = dbQuery {
        val insertStatement = Days.insert {
            it[Days.datetime] = datetime
            it[Days.maxTemperature] = maxTemperature
            it[Days.minTemperature] = minTemperature
        }
        insertStatement.resultedValues?.singleOrNull()?.let(::resultRowToDay)
    }

    override suspend fun updateDay(
        id: Int,
        datetime: String,
        maxTemperature: Double,
        minTemperature: Double,
    ): Boolean {
        return transaction {
            Days.update({ Days.id eq id }) {
                it[Days.datetime] = datetime
                it[Days.maxTemperature] = maxTemperature
                it[Days.minTemperature] = minTemperature
            } > 0
        }
    }

    override suspend fun deleteDay(id: Int): Boolean {
        return transaction {
            Days.deleteWhere { Days.id eq id } > 0
        }
    }

    override suspend fun close() {
        return transaction {
            Days.deleteAll();
        }
    }


}
