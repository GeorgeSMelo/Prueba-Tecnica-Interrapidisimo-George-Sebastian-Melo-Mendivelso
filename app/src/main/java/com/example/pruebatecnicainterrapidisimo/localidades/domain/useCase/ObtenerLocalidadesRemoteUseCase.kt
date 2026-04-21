package com.example.pruebatecnicainterrapidisimo.localidades.domain.useCase

import com.example.pruebatecnicainterrapidisimo.core.internet.ApiResponseStatus
import com.example.pruebatecnicainterrapidisimo.localidades.domain.model.LocalidadesDomain
import com.example.pruebatecnicainterrapidisimo.localidades.domain.repository.LocalidadesRemoteRepositoryInterface
import javax.inject.Inject

class ObtenerLocalidadesRemoteUseCase @Inject constructor(
    private val localidadesRemoteRepositoryInterface: LocalidadesRemoteRepositoryInterface
){
    suspend operator fun invoke() : ApiResponseStatus<List<LocalidadesDomain>> {
        return localidadesRemoteRepositoryInterface.obtenerLocalidades()
    }
}