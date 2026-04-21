package com.example.pruebatecnicainterrapidisimo.login.domain.model

import com.example.pruebatecnicainterrapidisimo.core.database.roomdb.entities.InformacionUsuarioEntity

data class AutheticaUsuarioAppDomain(
    val usuario: String?,
    val identificacion: String?,
    val nombre: String?,
    val apellido1: String?,
    val apellido2: String?,
    val cargo: String?,
    val aplicaciones: String?,
    val ubicaciones: String?,
    val mensajeResultado: String?,
    val idLocalidad: String?,
    val nombreLocalidad: String?,
    val nomRol: String?, val idRol: String?,
    val tokenJWT: String?,
    val modulosApp: String?
)

fun AutheticaUsuarioAppDomain.transformarAutheticaUsuarioAppDomainAInformacionUsuarioEntity(): InformacionUsuarioEntity{
    return InformacionUsuarioEntity(
        usuario = usuario ?: "",
        identificacion = identificacion ?: "",
        nombre = nombre ?: ""
    )
}