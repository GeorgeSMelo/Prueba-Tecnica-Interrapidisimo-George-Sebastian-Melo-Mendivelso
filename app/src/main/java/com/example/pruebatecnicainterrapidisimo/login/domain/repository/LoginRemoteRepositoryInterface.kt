package com.example.pruebatecnicainterrapidisimo.login.domain.repository

import com.example.pruebatecnicainterrapidisimo.core.internet.ApiResponseStatus
import com.example.pruebatecnicainterrapidisimo.login.domain.model.AutheticaUsuarioAppDomain
import com.example.pruebatecnicainterrapidisimo.login.domain.model.CredencialesAuthenticaUsuarioDomain

interface LoginRemoteRepositoryInterface {
    suspend fun validateCurrentVersion () : ApiResponseStatus<String>
    suspend fun authenticarUsuario (credencialesUsuario: CredencialesAuthenticaUsuarioDomain) : ApiResponseStatus<AutheticaUsuarioAppDomain>
}