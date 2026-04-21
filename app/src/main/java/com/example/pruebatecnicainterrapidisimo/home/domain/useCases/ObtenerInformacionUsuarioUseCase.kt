package com.example.pruebatecnicainterrapidisimo.home.domain.useCases

import com.example.pruebatecnicainterrapidisimo.home.domain.model.InformacionUsuarioDomain
import com.example.pruebatecnicainterrapidisimo.home.domain.repository.HomeLocalRepositoryInterface
import javax.inject.Inject

class ObtenerInformacionUsuarioUseCase @Inject constructor(
    private val homeLocalRepositoryInterface: HomeLocalRepositoryInterface

) {
    suspend operator fun invoke() : InformacionUsuarioDomain{
        return homeLocalRepositoryInterface.obtenerInformacioUsuario()
    }
}