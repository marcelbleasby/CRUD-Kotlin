package crud_bd.routes

import crud_bd.models.armazenamento
import crud_bd.models.cliente
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*


import io.ktor.server.routing.*

fun Route.rotacliente() {
    route("/cliente") {
        get {
            if(armazenamento.isNotEmpty()) {
                call.respond(armazenamento)
            }
            else{
                call.respondText("Cliente não encontrado", status = HttpStatusCode.OK )
            }
        }

        get("{id?}") {
            val id = call.parameters["id"] ?: return@get
            call.respondText ("Id não recebido",
                status = HttpStatusCode.BadRequest
            )
            val cliente = armazenamento.find { it.id == id } ?: return@get
            call.respondText  ("Não há cliente com id:$id",
                status = HttpStatusCode.NotFound
            )
        call.respond(cliente)
        }
        post {
            val cliente = call.receive<cliente>()
            armazenamento.add(cliente)
            call.respondText ("Cliente Cadastrado",status = HttpStatusCode.Created)
        }

        delete("{id?}") {
            val id = call.parameters["id"] ?: return@delete call.respond(HttpStatusCode.BadRequest)
                if ( armazenamento.removeIf { it.id == id }){
                   call.respondText ("Apagado com sucesso",
                   status = HttpStatusCode.Accepted
                   )}
                else{
                    call.respondText("Não encontrado")
                    }

        }
    }
}
