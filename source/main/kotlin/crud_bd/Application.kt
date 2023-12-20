package crud_bd

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import crud_bd.plugins.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.cors.routing.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun main() {
    embeddedServer(Netty, port = 5173, host = "127.0.0.1") {


    }.start(wait = true)

}

fun Application.module() {
    configureSerialization()
    configureRouting()
}
