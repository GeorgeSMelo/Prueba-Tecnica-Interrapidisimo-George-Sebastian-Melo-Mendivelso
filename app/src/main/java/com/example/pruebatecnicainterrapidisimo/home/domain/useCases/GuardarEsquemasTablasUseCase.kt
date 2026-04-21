package com.example.pruebatecnicainterrapidisimo.home.domain.useCases

import com.example.pruebatecnicainterrapidisimo.home.domain.model.EsquemaBaseDatosDomain
import com.example.pruebatecnicainterrapidisimo.home.domain.repository.HomeLocalRepositoryInterface
import javax.inject.Inject

class GuardarEsquemasTablasUseCase @Inject constructor(
    private val homeLocalRepositoryInterface: HomeLocalRepositoryInterface
)  {
    suspend operator fun invoke(
        listadoEsquemas: List<EsquemaBaseDatosDomain>
    ){
        homeLocalRepositoryInterface.guardarEsquemasBaseDatos(
            listadoEsquemas = listadoEsquemas
        )
    }
}