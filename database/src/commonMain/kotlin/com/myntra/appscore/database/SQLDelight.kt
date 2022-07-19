package com.myntra.appscore.database

import com.squareup.sqldelight.db.SqlDriver
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import com.myntra.appscore.MainDatabase
import kotlin.js.JsExport
/*
Koin Annotations didn't work.
Will try on a standalone project first
 */


expect class DriverProvider {
    suspend fun get(): SqlDriver
}

class SQLDatabase(private val driverProvider: DriverProvider) {
    private var mainDatabase: MainDatabase? = null

    suspend operator fun <R> invoke(block: suspend MainDatabase.() -> R): R {
        if (mainDatabase == null) {
            val driver = driverProvider.get()
            mainDatabase = MainDatabase(driver)
        }
        return mainDatabase!!.block()
    }
}



fun runQuery(sqlDatabase: SQLDatabase) {
    println("PRINT SQL DATA")
    GlobalScope.launch {
        println("PRINT SQL DATA")
        sqlDatabase {
            println("PRINT SQL DATA")
            helloQueries.selectAll { player_number, full_name ->
                println("PRINT SQL DATA, $player_number, $full_name")
            }.executeAsList()
        }
    }
}
