package crud_bd.routes


import io.ktor.server.application.*
import io.ktor.http.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import crud_bd.models.lista_pedido
import kotlin.collections.sumOf


fun Route.listadepedidos() {
    get("/pedido") {
        if (lista_pedido.isNotEmpty()) {
            call.respond(lista_pedido)
        }
        fun Route.id_pedido() {
            get("/pedido/{id?}") {
                val id = call.parameters["id"] ?: return@get
                call.respondText(
                    "Id não recebido",
                    status = HttpStatusCode.BadRequest)
            }
            }

    }
}
fun Route.pedidoid() {
    get("/pedido/{id?}") {
        val id = call.parameters["id"] ?: return@get call.respondText("Bad Request", status = HttpStatusCode.BadRequest)
        val order = lista_pedido.find { it.numero == id } ?: return@get call.respondText(
            "Not Found",
            status = HttpStatusCode.NotFound
        )
        call.respond(order)
    }

}
fun Route.totalpedido() {
    get("/pedido/{id?}/total") {
        val id = call.parameters["id"] ?: return@get call.respondText("Negado/Bad Request", status = HttpStatusCode.BadRequest)
        val pedido = lista_pedido.find { it.numero == id } ?: return@get call.respondText(
            "Não encontrado",
            status = HttpStatusCode.NotFound
        )
        val total = pedido.conteudo.sumOf { it.preco * it.quantidade }
        call.respond(total)
    }
}

