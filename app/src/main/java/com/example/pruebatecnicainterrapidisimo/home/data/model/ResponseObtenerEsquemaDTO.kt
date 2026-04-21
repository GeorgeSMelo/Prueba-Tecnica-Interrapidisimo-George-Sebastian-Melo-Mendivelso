package com.example.pruebatecnicainterrapidisimo.home.data.model

import com.example.pruebatecnicainterrapidisimo.home.domain.model.EsquemaBaseDatosDomain
import com.google.gson.annotations.SerializedName

data class ResponseObtenerEsquemaDTO(
    @SerializedName("NombreTabla") val nombreTabla : String,
    @SerializedName("Pk") val pk : String,
    @SerializedName("QueryCreacion") val queryCreacion : String,
    @SerializedName("BatchSize") val batchSize : Int,
    @SerializedName("Filtro") val filtro : String,
    @SerializedName("Error") val error : String?,
    @SerializedName("NumeroCampos") val numeroCampos : Int,
    @SerializedName("MetodoApp") val metodoApp : String?,
    @SerializedName("FechaActualizacionSincro") val fechaActualizacionSincro : String
)

fun List<ResponseObtenerEsquemaDTO>.transformarListadoDeResponseObtenerEsquemaDTOAListadoEsquemaBaseDatosDomain(): List<EsquemaBaseDatosDomain> {
    val listadoEsquemaBaseDeDatosDomain = mutableListOf<EsquemaBaseDatosDomain>()
    this.forEach { esquemaDTO ->
        listadoEsquemaBaseDeDatosDomain.add(
            esquemaDTO.transformarResponseObtenerEsquemaDTOAEsquemaBaseDatosDomain()

        )
    }
    return listadoEsquemaBaseDeDatosDomain
}
fun ResponseObtenerEsquemaDTO.transformarResponseObtenerEsquemaDTOAEsquemaBaseDatosDomain() : EsquemaBaseDatosDomain {
    return EsquemaBaseDatosDomain(
        nombreTabla = nombreTabla,
        pk = pk,
        queryCreacion = queryCreacion,
        batchSize = batchSize,
        filtro = filtro,
        error = error,
        numeroCampos = numeroCampos,
        metodoApp = metodoApp,
        fechaActualizacionSincro = fechaActualizacionSincro
    )
}
