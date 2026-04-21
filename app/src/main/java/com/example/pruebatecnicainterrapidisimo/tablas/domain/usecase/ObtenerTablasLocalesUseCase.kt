package com.example.pruebatecnicainterrapidisimo.tablas.domain.usecase

import com.example.pruebatecnicainterrapidisimo.tablas.domain.model.InformacionTablasDomain
import com.example.pruebatecnicainterrapidisimo.tablas.domain.repository.TablasLocalRepositoryInterface
import javax.inject.Inject

class ObtenerTablasLocalesUseCase @Inject constructor(
    private val tablasLocalRepositoryInterface: TablasLocalRepositoryInterface
) {
    suspend operator fun invoke(): List<InformacionTablasDomain>{
        return tablasLocalRepositoryInterface.consultarInformacionTablas()
    }

}