package com.example.pruebatecnicainterrapidisimo.home.domain.useCases

import com.example.pruebatecnicainterrapidisimo.core.internet.ApiResponseStatus
import com.example.pruebatecnicainterrapidisimo.home.domain.model.EsquemaBaseDatosDomain
import com.example.pruebatecnicainterrapidisimo.home.domain.repository.HomeRemoteRepositoryInterface
import javax.inject.Inject

class ObtenerEsquemaBaseDatosRemoteUseCase @Inject constructor(
    private val homeRemoteRepositoryInterface: HomeRemoteRepositoryInterface
) {
    suspend operator fun invoke() : ApiResponseStatus<List<EsquemaBaseDatosDomain>> {
        return homeRemoteRepositoryInterface.obtenerEsquemaBaseDatosRemota()
    }
}