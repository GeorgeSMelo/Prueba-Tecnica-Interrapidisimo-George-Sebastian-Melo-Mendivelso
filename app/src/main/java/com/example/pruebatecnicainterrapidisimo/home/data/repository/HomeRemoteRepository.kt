package com.example.pruebatecnicainterrapidisimo.home.data.repository

import com.example.pruebatecnicainterrapidisimo.core.ERROR_ESQUEMAS_TABLAS
import com.example.pruebatecnicainterrapidisimo.core.internet.ApiResponseStatus
import com.example.pruebatecnicainterrapidisimo.core.internet.InterrapidisimoApi
import com.example.pruebatecnicainterrapidisimo.home.data.model.transformarListadoDeResponseObtenerEsquemaDTOAListadoEsquemaBaseDatosDomain
import com.example.pruebatecnicainterrapidisimo.home.domain.model.EsquemaBaseDatosDomain
import com.example.pruebatecnicainterrapidisimo.home.domain.repository.HomeRemoteRepositoryInterface
import javax.inject.Inject

class HomeRemoteRepository @Inject constructor(
    private val interrapidisimoApi: InterrapidisimoApi
) : HomeRemoteRepositoryInterface {
    override suspend fun obtenerEsquemaBaseDatosRemota(): ApiResponseStatus<List<EsquemaBaseDatosDomain>> {
        try {
            val call = interrapidisimoApi.getObtenerEsquema()
            if (call.isSuccessful) {
                val esquemas = call.body() ?: return ApiResponseStatus.Error(ERROR_ESQUEMAS_TABLAS)
                return ApiResponseStatus.Success(esquemas.transformarListadoDeResponseObtenerEsquemaDTOAListadoEsquemaBaseDatosDomain())
            }
            return ApiResponseStatus.Error(ERROR_ESQUEMAS_TABLAS)
        } catch (e: Exception) {
            return ApiResponseStatus.Error(ERROR_ESQUEMAS_TABLAS)
        }
    }

}