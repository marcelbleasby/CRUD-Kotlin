package crud_bd.models
import kotlinx.serialization.Serializable

@Serializable
data class item_pedido(val item: String,
                     val quantidade: Int,
                     val preco: Double
)
@Serializable
data class pedido(val numero: String,
                 val conteudo: List<item_pedido>
) {

}

val lista_pedido = listOf(pedido(
    "2020-04-06-01", listOf(
        item_pedido("Ham Sandwich", 2, 5.50),
        item_pedido("Water", 1, 1.50),
        item_pedido("Beer", 3, 2.30),
        item_pedido("Cheesecake", 1, 3.75)
    )),
    pedido("2020-04-03-01", listOf(
        item_pedido("Cheeseburger", 1, 8.50),
        item_pedido("Water", 2, 1.50),
        item_pedido("Coke", 2, 1.76),
        item_pedido("Ice Cream", 1, 2.35)
    ))
)