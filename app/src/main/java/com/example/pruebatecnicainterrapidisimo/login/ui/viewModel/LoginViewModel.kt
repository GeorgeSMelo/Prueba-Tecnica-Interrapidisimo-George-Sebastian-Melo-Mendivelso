package com.example.pruebatecnicainterrapidisimo.login.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebatecnicainterrapidisimo.core.internet.ApiResponseStatus
import com.example.pruebatecnicainterrapidisimo.login.domain.model.AutheticaUsuarioAppDomain
import com.example.pruebatecnicainterrapidisimo.login.domain.model.CredencialesAuthenticaUsuarioDomain
import com.example.pruebatecnicainterrapidisimo.login.domain.model.EnumChequeoVersion
import com.example.pruebatecnicainterrapidisimo.login.domain.useCases.GuardarUsuarioUseCase
import com.example.pruebatecnicainterrapidisimo.login.domain.useCases.IniciarSesionUseCase
import com.example.pruebatecnicainterrapidisimo.login.domain.useCases.LimpiarUsuarioUseCase
import com.example.pruebatecnicainterrapidisimo.login.domain.useCases.ValidateControlVersionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val validateControlVersionUseCase: ValidateControlVersionUseCase,
    private val iniciarSesionUseCase: IniciarSesionUseCase,
    private val guardarUsuarioUseCase: GuardarUsuarioUseCase,
    private val limpiarUsuarioUseCase: LimpiarUsuarioUseCase
): ViewModel(
){
    var estadoVersion : EnumChequeoVersion? = null
        private set
    var stateCurrentVersionRemote = MutableLiveData<ApiResponseStatus<String>>()
        private set

    var stateIniciarSesion = MutableLiveData<ApiResponseStatus<AutheticaUsuarioAppDomain>>()
        private set

    fun validateControlVersion(versionLocal: String) = viewModelScope.launch {
        stateCurrentVersionRemote.value = ApiResponseStatus.Loading()
        val respuestaApi = validateControlVersionUseCase()
        if (respuestaApi is  ApiResponseStatus.Success){
            validarEstadoVersion(
                versionApi = respuestaApi.data,
                versionLocal = versionLocal
            )
        }
        stateCurrentVersionRemote.value = respuestaApi
    }

    fun iniciarSesion() = viewModelScope.launch {

        stateIniciarSesion.value = ApiResponseStatus.Loading()
        val credencialesUsuario = CredencialesAuthenticaUsuarioDomain(
            mac = "",
            nomAplicacion = "Controller APP",
            password = "SW50ZXIyMDIx\n",
            path = "",
            usuario = "cGFtLm1lcmVkeTIx\n"
        )
        val respuestaApi = iniciarSesionUseCase(
            credencialesUsuario = credencialesUsuario
        )
        if(respuestaApi is ApiResponseStatus.Success){
            limpiarUsuarioUseCase()
            guardarUsuarioUseCase(
                informacionUsuario = respuestaApi.data
            )
        }

        stateIniciarSesion.value = respuestaApi
    }

    private fun validarEstadoVersion(versionApi: String, versionLocal : String) {
        val numeroVersionApi = if(versionApi.isEmpty()) 0 else versionApi.toInt()
        val numeroVersionLocal = if(versionLocal.isEmpty()) 0 else versionLocal.toInt()

        if (numeroVersionLocal == numeroVersionApi) {
            estadoVersion = EnumChequeoVersion.VERSION_IGUAL
            return
        }
        if (numeroVersionLocal < numeroVersionApi){
            estadoVersion = EnumChequeoVersion.VERSION_MENOR
            return
        }
        estadoVersion = EnumChequeoVersion.VERSION_MAYOR
    }
}
