package com.example.pruebatecnicainterrapidisimo.login.domain.useCases

import com.example.pruebatecnicainterrapidisimo.core.internet.ApiResponseStatus
import com.example.pruebatecnicainterrapidisimo.login.domain.model.AutheticaUsuarioAppDomain
import com.example.pruebatecnicainterrapidisimo.login.domain.model.CredencialesAuthenticaUsuarioDomain
import com.example.pruebatecnicainterrapidisimo.login.domain.repository.LoginRemoteRepositoryInterface
import javax.inject.Inject

class IniciarSesionUseCase @Inject constructor(
    private val loginRemoteRepositoryInterface: LoginRemoteRepositoryInterface
) {
    suspend operator fun invoke(credencialesUsuario: CredencialesAuthenticaUsuarioDomain): ApiResponseStatus<AutheticaUsuarioAppDomain> {
        return loginRemoteRepositoryInterface.authenticarUsuario(credencialesUsuario)
    }
}