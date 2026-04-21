package com.example.pruebatecnicainterrapidisimo.localidades.data.model

import com.example.pruebatecnicainterrapidisimo.localidades.domain.model.LocalidadesDomain
import com.google.gson.annotations.SerializedName

data class RespuestaApiLocalidadesDTO (
    @SerializedName("NombreCompleto") val nombreCompleto : String,
    @SerializedName("AbreviacionCiudad") val abreviacionCiudad : String,
)
fun List<RespuestaApiLocalidadesDTO>.transformarListaRespuestaApiLocalidadesDTOAListaLocalidadesDomain() : List<LocalidadesDomain>{
    val listadoLocalidadesDomain = mutableListOf<LocalidadesDomain>()
    this.forEach { respuestaApiLocalidades ->
        listadoLocalidadesDomain.add(
            respuestaApiLocalidades.transformarRespuestaApiLocalidadesDTOALocalidadesDomain()

        )
    }
    return listadoLocalidadesDomain
}
fun RespuestaApiLocalidadesDTO.transformarRespuestaApiLocalidadesDTOALocalidadesDomain() : LocalidadesDomain {
    return LocalidadesDomain(
        abreviacionCiudad = abreviacionCiudad,
        nombreCompleto = nombreCompleto
    )
}


