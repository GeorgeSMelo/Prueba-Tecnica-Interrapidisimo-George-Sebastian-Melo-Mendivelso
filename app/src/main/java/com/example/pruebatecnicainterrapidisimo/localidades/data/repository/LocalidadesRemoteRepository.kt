package com.example.pruebatecnicainterrapidisimo.localidades.data.repository

import com.example.pruebatecnicainterrapidisimo.core.ERROR_CONSULTAR_LOCALIDADES
import com.example.pruebatecnicainterrapidisimo.core.internet.ApiResponseStatus
import com.example.pruebatecnicainterrapidisimo.core.internet.InterrapidisimoApi
import com.example.pruebatecnicainterrapidisimo.localidades.data.model.transformarListaRespuestaApiLocalidadesDTOAListaLocalidadesDomain
import com.example.pruebatecnicainterrapidisimo.localidades.domain.model.LocalidadesDomain
import com.example.pruebatecnicainterrapidisimo.localidades.domain.repository.LocalidadesRemoteRepositoryInterface
import javax.inject.Inject

class LocalidadesRemoteRepository @Inject constructor(
    private val interrapidisimoApi: InterrapidisimoApi
) : LocalidadesRemoteRepositoryInterface {
    override suspend fun obtenerLocalidades(): ApiResponseStatus<List<LocalidadesDomain>> {
        try {
            val call = interrapidisimoApi.getLocalidades()
            if (call.isSuccessful) {
                val localidades = call.body() ?: return ApiResponseStatus.Error(ERROR_CONSULTAR_LOCALIDADES)
                return ApiResponseStatus.Success(data = localidades.transformarListaRespuestaApiLocalidadesDTOAListaLocalidadesDomain())
            } else {
                return ApiResponseStatus.Error(ERROR_CONSULTAR_LOCALIDADES)
            }

        } catch (e: Exception) {
            return ApiResponseStatus.Error(ERROR_CONSULTAR_LOCALIDADES)
        }
    }

}