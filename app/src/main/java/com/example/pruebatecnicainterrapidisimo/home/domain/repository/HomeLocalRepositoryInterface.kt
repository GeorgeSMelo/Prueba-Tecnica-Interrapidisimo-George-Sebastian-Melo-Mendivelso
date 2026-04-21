package com.example.pruebatecnicainterrapidisimo.home.domain.repository

import com.example.pruebatecnicainterrapidisimo.home.domain.model.EsquemaBaseDatosDomain
import com.example.pruebatecnicainterrapidisimo.home.domain.model.InformacionUsuarioDomain

interface HomeLocalRepositoryInterface {
    suspend fun obtenerInformacioUsuario() : InformacionUsuarioDomain
    suspend fun guardarEsquemasBaseDatos(listadoEsquemas: List<EsquemaBaseDatosDomain>)
    suspend fun limpiarEsquemasBaseDatos()
}
