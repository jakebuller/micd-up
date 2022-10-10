package com.jbuller

import com.jbuller.persistence.tables.Users
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

class Database {
    fun connect() {
        println("Connecting to database...")
        Database.connect("jdbc:mysql://localhost:3306/micd_up_dev", user = "root", password = "")
        println("Connected")
    }

    fun runMigrations() {
        println("Running migrations")
        transaction {
            SchemaUtils.create(*DATABASE_TABLES.toTypedArray())
        }
    }

    companion object {
        val DATABASE_TABLES = listOf(
            Users
        )
    }
}
