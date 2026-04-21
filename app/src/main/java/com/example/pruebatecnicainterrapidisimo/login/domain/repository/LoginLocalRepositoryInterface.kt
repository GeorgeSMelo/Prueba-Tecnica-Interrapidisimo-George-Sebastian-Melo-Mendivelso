package com.example.pruebatecnicainterrapidisimo.login.domain.repository

import com.example.pruebatecnicainterrapidisimo.login.domain.model.AutheticaUsuarioAppDomain

interface LoginLocalRepositoryInterface {
    suspend fun guadarUsuario(informacionUsuario : AutheticaUsuarioAppDomain)
}