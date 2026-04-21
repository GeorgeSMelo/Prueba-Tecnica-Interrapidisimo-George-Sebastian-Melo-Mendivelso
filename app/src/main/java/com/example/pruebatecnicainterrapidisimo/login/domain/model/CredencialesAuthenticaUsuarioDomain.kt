package com.example.pruebatecnicainterrapidisimo.login.domain.model

import com.example.pruebatecnicainterrapidisimo.login.data.model.BodyAuthenticaUsuarioAppDTO

data class CredencialesAuthenticaUsuarioDomain(
    val mac: String,
    val nomAplicacion: String,
    val password: String,
    val path: String,
    val usuario: String,
)

fun CredencialesAuthenticaUsuarioDomain
    .transformarCredencialesAuthenticaUsuarioDomainABodyAuthenticaUsuarioAppDTO() : BodyAuthenticaUsuarioAppDTO {
    return BodyAuthenticaUsuarioAppDTO(
        mac = mac,
        nomAplicacion = nomAplicacion,
        password = password,
        path = path,
        usuario = usuario
    )
}