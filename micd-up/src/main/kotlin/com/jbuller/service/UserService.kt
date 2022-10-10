package com.jbuller.service

import User
import org.jetbrains.exposed.sql.transactions.transaction

class UserService {
    fun createUser(
        name: String,
        city: String,
        email: String,
    ) {
        transaction {
            User.new {
                this.name = name
                this.city = city
                this.email = email
            }
        }
    }
}
