package com.example.pruebatecnicainterrapidisimo.localidades.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebatecnicainterrapidisimo.core.internet.ApiResponseStatus
import com.example.pruebatecnicainterrapidisimo.localidades.domain.model.LocalidadesDomain
import com.example.pruebatecnicainterrapidisimo.localidades.domain.useCase.ObtenerLocalidadesRemoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocalidadesViewModel @Inject constructor(
    private val obtenerLocalidadesRemoteUseCase: ObtenerLocalidadesRemoteUseCase
): ViewModel(){
    var estadoConsultarListadoLocalidadesRemote = MutableLiveData< ApiResponseStatus<List<LocalidadesDomain>>>()
        private set
    fun obtenerLocalidadesRemote() = viewModelScope.launch {
        estadoConsultarListadoLocalidadesRemote.value = ApiResponseStatus.Loading()
        estadoConsultarListadoLocalidadesRemote.value = obtenerLocalidadesRemoteUseCase()
    }
}