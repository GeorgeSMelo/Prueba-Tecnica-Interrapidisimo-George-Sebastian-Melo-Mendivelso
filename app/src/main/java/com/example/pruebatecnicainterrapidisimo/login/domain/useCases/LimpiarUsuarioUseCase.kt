package com.example.pruebatecnicainterrapidisimo.login.domain.useCases

import com.example.pruebatecnicainterrapidisimo.core.database.roomdb.daos.InformacionUsuarioDAO
import javax.inject.Inject

class LimpiarUsuarioUseCase @Inject  constructor(
    private val informacionUsuarioDAO: InformacionUsuarioDAO
) {
    suspend operator fun invoke(){
        informacionUsuarioDAO.limpiarInformacionUsuario()
    }
}