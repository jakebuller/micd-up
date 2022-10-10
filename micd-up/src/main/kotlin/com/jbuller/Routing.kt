package com.jbuller

import com.jbuller.service.UserService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable

fun Application.configureRouting() {
    routing {
        get("/") {
            println("handling request")
            call.respondText("Hello World!")
        }
        post("/users") {
            val createUserRequest = call.receive<CreateUserRequest>()
            UserService().createUser(
                name = createUserRequest.name,
                createUserRequest.city,
                createUserRequest.email
            )

            call.respond(status = HttpStatusCode.Created, "")
        }
    }
}

@Serializable
data class CreateUserRequest(
    val name: String,
    val city: String,
    val email: String,
)

