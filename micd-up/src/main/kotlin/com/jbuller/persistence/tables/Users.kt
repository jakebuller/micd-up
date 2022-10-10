package com.jbuller.persistence.tables


import org.jetbrains.exposed.dao.id.UUIDTable

object Users : UUIDTable() {
    val name = varchar("name", 100)
    val city = varchar("city", 100) // TODO validate
    val email = varchar("email", 100).uniqueIndex()
}
