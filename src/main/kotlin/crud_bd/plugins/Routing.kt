package crud_bd.plugins

import crud_bd.routes.listadepedidos
import crud_bd.routes.pedidoid
import crud_bd.routes.rotacliente
import crud_bd.routes.totalpedido
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
    rotacliente()
    listadepedidos()
    pedidoid()
    totalpedido()
        }
    }

