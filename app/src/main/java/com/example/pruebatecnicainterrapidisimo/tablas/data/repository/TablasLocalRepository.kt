package com.example.pruebatecnicainterrapidisimo.tablas.data.repository

import com.example.pruebatecnicainterrapidisimo.core.database.roomdb.daos.EsquemasTablasDAO
import com.example.pruebatecnicainterrapidisimo.core.database.roomdb.entities.transformarListadoEsquemasTablasEntityAListadoInformacionTablasDomain
import com.example.pruebatecnicainterrapidisimo.tablas.domain.model.InformacionTablasDomain
import com.example.pruebatecnicainterrapidisimo.tablas.domain.repository.TablasLocalRepositoryInterface
import javax.inject.Inject

class TablasLocalRepository @Inject constructor(
    private val esquemasTablasDAO: EsquemasTablasDAO

) : TablasLocalRepositoryInterface {
    override suspend fun consultarInformacionTablas(): List<InformacionTablasDomain> {
        val listadoEsquemasEntity = esquemasTablasDAO.obtenerEsquemas()
        return listadoEsquemasEntity.transformarListadoEsquemasTablasEntityAListadoInformacionTablasDomain()


    }
}