package com.example.pruebatecnicainterrapidisimo.login.domain.useCases

import com.example.pruebatecnicainterrapidisimo.login.domain.model.AutheticaUsuarioAppDomain
import com.example.pruebatecnicainterrapidisimo.login.domain.repository.LoginLocalRepositoryInterface
import javax.inject.Inject

class GuardarUsuarioUseCase @Inject constructor(
    private val loginLocalRepositoryInterface: LoginLocalRepositoryInterface
) {
    
    suspend operator fun invoke(
        informacionUsuario : AutheticaUsuarioAppDomain
    ){
        return loginLocalRepositoryInterface.guadarUsuario(
            informacionUsuario = informacionUsuario
        )
    }
}