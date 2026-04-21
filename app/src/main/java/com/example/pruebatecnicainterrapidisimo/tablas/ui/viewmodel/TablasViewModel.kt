package com.example.pruebatecnicainterrapidisimo.tablas.ui.viewmodel

import androidx.compose.runtime.remember
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebatecnicainterrapidisimo.tablas.domain.model.InformacionTablasDomain
import com.example.pruebatecnicainterrapidisimo.tablas.domain.usecase.ObtenerTablasLocalesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class TablasViewModel @Inject constructor(
    private val obtenerTablasLocalesUseCase: ObtenerTablasLocalesUseCase
) : ViewModel() {
    var listadoTablasLocales = MutableLiveData<List<InformacionTablasDomain>>()
    private set
    fun obtenerTablasLocales() = viewModelScope.launch {
        listadoTablasLocales.value = obtenerTablasLocalesUseCase()

    }

}