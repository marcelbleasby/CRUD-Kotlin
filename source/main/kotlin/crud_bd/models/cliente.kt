package crud_bd.models

import kotlinx.serialization.Serializable

@Serializable
data class cliente(val id: String,
                   val nome: String,
                   val sobrenome: String,
                   val email: String
)
val armazenamento = mutableListOf<cliente>()
