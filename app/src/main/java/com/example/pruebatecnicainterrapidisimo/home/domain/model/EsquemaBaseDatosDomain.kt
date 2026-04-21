package com.example.pruebatecnicainterrapidisimo.home.domain.model

import com.example.pruebatecnicainterrapidisimo.core.database.roomdb.entities.EsquemasTablasEntity

data class EsquemaBaseDatosDomain(
    val nombreTabla: String,
    val pk: String,
    val queryCreacion: String,
    val batchSize: Int,
    val filtro: String,
    val error: String?,
    val numeroCampos: Int,
    val metodoApp: String?,
    val fechaActualizacionSincro: String
)

fun List<EsquemaBaseDatosDomain>.transformarListadoEsquemaBaseDatosDomainAListadoEsquemasTablasEntity(): List<EsquemasTablasEntity> {

    val listadoEsquemasEntity = mutableListOf<EsquemasTablasEntity>()
    this.forEach { esquemaBaseDatosDomain ->
        listadoEsquemasEntity.add(esquemaBaseDatosDomain.transformarEsquemaBaseDatosDomainAEsquemasTablasEntity())

    }
    return listadoEsquemasEntity

}

fun EsquemaBaseDatosDomain.transformarEsquemaBaseDatosDomainAEsquemasTablasEntity(): EsquemasTablasEntity {
    return EsquemasTablasEntity(
        nombreTabla = nombreTabla,
        queryCreacion = queryCreacion
    )
}