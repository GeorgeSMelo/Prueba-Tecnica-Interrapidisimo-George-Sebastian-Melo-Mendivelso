package com.example.pruebatecnicainterrapidisimo.home.domain.repository

import com.example.pruebatecnicainterrapidisimo.core.internet.ApiResponseStatus
import com.example.pruebatecnicainterrapidisimo.home.domain.model.EsquemaBaseDatosDomain

interface HomeRemoteRepositoryInterface {
    suspend fun obtenerEsquemaBaseDatosRemota(): ApiResponseStatus<List<EsquemaBaseDatosDomain>>
}