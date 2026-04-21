package com.example.pruebatecnicainterrapidisimo.login.data.repository

import com.example.pruebatecnicainterrapidisimo.core.database.roomdb.daos.InformacionUsuarioDAO
import com.example.pruebatecnicainterrapidisimo.login.domain.model.AutheticaUsuarioAppDomain
import com.example.pruebatecnicainterrapidisimo.login.domain.model.transformarAutheticaUsuarioAppDomainAInformacionUsuarioEntity
import com.example.pruebatecnicainterrapidisimo.login.domain.repository.LoginLocalRepositoryInterface
import javax.inject.Inject

class LoginLocalRepository @Inject constructor(
    private val informacionUsuarioDAO: InformacionUsuarioDAO
) : LoginLocalRepositoryInterface {
    override suspend fun guadarUsuario(informacionUsuario: AutheticaUsuarioAppDomain) {
        informacionUsuarioDAO.guardarUsuario(informacionUsuarioEntity = informacionUsuario.transformarAutheticaUsuarioAppDomainAInformacionUsuarioEntity())
    }
}