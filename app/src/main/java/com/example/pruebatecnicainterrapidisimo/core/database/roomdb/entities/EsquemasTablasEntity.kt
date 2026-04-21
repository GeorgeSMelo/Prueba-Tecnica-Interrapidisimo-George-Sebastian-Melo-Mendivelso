package com.example.pruebatecnicainterrapidisimo.core.database.roomdb.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pruebatecnicainterrapidisimo.tablas.domain.model.InformacionTablasDomain

@Entity("EsquemasTablas")
data class EsquemasTablasEntity(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val nombreTabla : String,
    val queryCreacion : String
)

fun List<EsquemasTablasEntity>.transformarListadoEsquemasTablasEntityAListadoInformacionTablasDomain(): List<InformacionTablasDomain> {
    val listadoInformacionTablasDomain = mutableListOf<InformacionTablasDomain>()
    this.forEach { esquemaTablasEntity ->
        listadoInformacionTablasDomain.add(
            esquemaTablasEntity.tranformarEsquemasTablasEntityAInformacionTablasDomain()
        )
    }
    return listadoInformacionTablasDomain

}
fun EsquemasTablasEntity.tranformarEsquemasTablasEntityAInformacionTablasDomain(): InformacionTablasDomain{
    return InformacionTablasDomain(
        nombreTabla = nombreTabla,
        queryCreacion = queryCreacion
    )
}