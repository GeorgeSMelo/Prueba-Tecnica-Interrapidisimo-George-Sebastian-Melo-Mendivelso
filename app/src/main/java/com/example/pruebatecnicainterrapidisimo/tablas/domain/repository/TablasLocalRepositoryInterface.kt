package com.example.pruebatecnicainterrapidisimo.tablas.domain.repository

import com.example.pruebatecnicainterrapidisimo.tablas.domain.model.InformacionTablasDomain

interface TablasLocalRepositoryInterface {
    suspend fun consultarInformacionTablas() : List<InformacionTablasDomain>
}