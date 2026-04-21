package com.example.pruebatecnicainterrapidisimo.core.database.roomdb.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pruebatecnicainterrapidisimo.home.domain.model.InformacionUsuarioDomain

@Entity("InformacionUsuario")
data class InformacionUsuarioEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val usuario: String,
    val identificacion: String,
    val nombre: String
)
fun InformacionUsuarioEntity?.transformarInformacionUsuarioEntityAInformacionUsuarioDomain() : InformacionUsuarioDomain{
    return InformacionUsuarioDomain(
        usuario = this?.usuario?: "",
        identificacion = this?.identificacion ?: "",
        nombre = this?.nombre ?: ""
    )
}