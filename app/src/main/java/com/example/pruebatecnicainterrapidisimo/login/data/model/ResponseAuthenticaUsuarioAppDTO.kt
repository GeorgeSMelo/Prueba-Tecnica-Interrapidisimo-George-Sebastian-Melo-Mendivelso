package com.example.pruebatecnicainterrapidisimo.login.data.model

import com.example.pruebatecnicainterrapidisimo.login.domain.model.AutheticaUsuarioAppDomain
import com.google.gson.annotations.SerializedName

data class ResponseAuthenticaUsuarioAppDTO(
    @SerializedName("Usuario") val usuario : String?,
    @SerializedName("Identificacion") val identificacion : String?,
    @SerializedName("Nombre" ) val nombre : String?,
    @SerializedName("Apellido1") val apellido1 : String?,
    @SerializedName("Apellido2") val apellido2  : String?,
    @SerializedName("Cargo") val cargo: String?,
    @SerializedName("Aplicaciones") val aplicaciones: String?,
    @SerializedName("Ubicaciones") val ubicaciones: String?,
    @SerializedName("MensajeResultado") val mensajeResultado: String?,
    @SerializedName("IdLocalidad") val idLocalidad: String?,
    @SerializedName("NombreLocalidad") val nombreLocalidad: String?,
    @SerializedName("NomRol") val nomRol: String?,
    @SerializedName("IdRol") val idRol: String?,
    @SerializedName("TokenJWT") val tokenJWT: String?,
    @SerializedName("ModulosApp") val modulosApp: String?
)

fun ResponseAuthenticaUsuarioAppDTO
        .transformarResponseAuthenticaUsuarioAppDTOAAutheticaUsuarioAppDomain() : AutheticaUsuarioAppDomain{
    return AutheticaUsuarioAppDomain(
        usuario = usuario,
        identificacion = identificacion,
        nombre = nombre,
        apellido1 = apellido1,
        apellido2 = apellido2,
        cargo = cargo,
        aplicaciones = aplicaciones,
        ubicaciones = ubicaciones,
        mensajeResultado = mensajeResultado,
        idLocalidad = idLocalidad,
        nombreLocalidad = nombreLocalidad,
        nomRol = nomRol,
        idRol = idRol,
        tokenJWT = tokenJWT,
        modulosApp = modulosApp
    )
}