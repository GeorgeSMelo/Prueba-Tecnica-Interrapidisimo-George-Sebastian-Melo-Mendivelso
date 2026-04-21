package com.example.pruebatecnicainterrapidisimo.home.data.repository

import com.example.pruebatecnicainterrapidisimo.core.database.roomdb.daos.EsquemasTablasDAO
import com.example.pruebatecnicainterrapidisimo.core.database.roomdb.daos.InformacionUsuarioDAO
import com.example.pruebatecnicainterrapidisimo.core.database.roomdb.entities.transformarInformacionUsuarioEntityAInformacionUsuarioDomain
import com.example.pruebatecnicainterrapidisimo.home.domain.model.EsquemaBaseDatosDomain
import com.example.pruebatecnicainterrapidisimo.home.domain.model.InformacionUsuarioDomain
import com.example.pruebatecnicainterrapidisimo.home.domain.model.transformarListadoEsquemaBaseDatosDomainAListadoEsquemasTablasEntity
import com.example.pruebatecnicainterrapidisimo.home.domain.repository.HomeLocalRepositoryInterface
import javax.inject.Inject

class HomeLocalRepository @Inject constructor(
    private val informacionUsuarioDAO: InformacionUsuarioDAO,
    private val esquemasTablasDAO: EsquemasTablasDAO
) : HomeLocalRepositoryInterface {
    override suspend fun obtenerInformacioUsuario(): InformacionUsuarioDomain {
        val informacionDeUsuarioLocal = informacionUsuarioDAO.obtenerUltimoUsuario()
        return informacionDeUsuarioLocal.transformarInformacionUsuarioEntityAInformacionUsuarioDomain()
    }
    override suspend fun guardarEsquemasBaseDatos(
        listadoEsquemas: List<EsquemaBaseDatosDomain>
    ){
        esquemasTablasDAO.guardarEsquemas(
            listaDeEsquemas = listadoEsquemas.transformarListadoEsquemaBaseDatosDomainAListadoEsquemasTablasEntity()
        )
    }
}