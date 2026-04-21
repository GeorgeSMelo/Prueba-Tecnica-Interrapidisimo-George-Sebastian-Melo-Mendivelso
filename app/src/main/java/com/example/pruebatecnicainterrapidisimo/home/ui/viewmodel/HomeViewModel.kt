package com.example.pruebatecnicainterrapidisimo.home.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebatecnicainterrapidisimo.core.internet.ApiResponseStatus
import com.example.pruebatecnicainterrapidisimo.home.domain.model.EsquemaBaseDatosDomain
import com.example.pruebatecnicainterrapidisimo.home.domain.model.InformacionUsuarioDomain
import com.example.pruebatecnicainterrapidisimo.home.domain.useCases.GuardarEsquemasTablasUseCase
import com.example.pruebatecnicainterrapidisimo.home.domain.useCases.ObtenerEsquemaBaseDatosRemoteUseCase
import com.example.pruebatecnicainterrapidisimo.home.domain.useCases.ObtenerInformacionUsuarioUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val obtenerInformacionUsuarioUseCase: ObtenerInformacionUsuarioUseCase,
    private val obtenerEsquemaBaseDatosRemoteUseCase: ObtenerEsquemaBaseDatosRemoteUseCase,
    private val guardarEsquemasTablasUseCase: GuardarEsquemasTablasUseCase
) : ViewModel() {

    var estadoObtenerEsquemas = MutableLiveData<ApiResponseStatus<List<EsquemaBaseDatosDomain>>>()
        private set
    var estadoInformacionLocalUsuario = MutableLiveData<InformacionUsuarioDomain>()
        private set

    fun obtenerInformacionUsuario() = viewModelScope.launch{
        estadoInformacionLocalUsuario.value = obtenerInformacionUsuarioUseCase()
    }
    fun obtenerEsquemasBaseDatosRemote() = viewModelScope.launch {
        estadoObtenerEsquemas.value = ApiResponseStatus.Loading()
        val respuestaApi = obtenerEsquemaBaseDatosRemoteUseCase()
        if (respuestaApi is ApiResponseStatus.Success){
            guardarEsquemasTablasUseCase(
                listadoEsquemas = respuestaApi.data
            )
        }
        estadoObtenerEsquemas.value = respuestaApi
    }
}