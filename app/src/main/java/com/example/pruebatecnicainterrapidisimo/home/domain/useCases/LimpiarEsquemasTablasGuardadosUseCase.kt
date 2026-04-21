package com.example.pruebatecnicainterrapidisimo.home.domain.useCases

import com.example.pruebatecnicainterrapidisimo.home.domain.repository.HomeLocalRepositoryInterface
import javax.inject.Inject

class LimpiarEsquemasTablasGuardadosUseCase @Inject constructor(
    private val homeLocalRepositoryInterface : HomeLocalRepositoryInterface
) {
    suspend operator fun invoke(){
        homeLocalRepositoryInterface.limpiarEsquemasBaseDatos()

    }
}