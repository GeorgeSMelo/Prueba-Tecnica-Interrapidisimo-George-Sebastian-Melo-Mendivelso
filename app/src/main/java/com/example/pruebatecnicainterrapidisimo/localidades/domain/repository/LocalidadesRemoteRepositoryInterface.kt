package com.example.pruebatecnicainterrapidisimo.localidades.domain.repository

import com.example.pruebatecnicainterrapidisimo.core.internet.ApiResponseStatus
import com.example.pruebatecnicainterrapidisimo.localidades.domain.model.LocalidadesDomain

interface LocalidadesRemoteRepositoryInterface {
    suspend fun obtenerLocalidades() : ApiResponseStatus<List<LocalidadesDomain>>
}