package com.example.pruebatecnicainterrapidisimo.login.data.repository

import android.util.Log
import com.example.pruebatecnicainterrapidisimo.core.internet.ApiResponseStatus
import com.example.pruebatecnicainterrapidisimo.core.internet.InterrapidisimoApi
import com.example.pruebatecnicainterrapidisimo.login.data.model.transformarResponseAuthenticaUsuarioAppDTOAAutheticaUsuarioAppDomain
import com.example.pruebatecnicainterrapidisimo.login.domain.model.AutheticaUsuarioAppDomain
import com.example.pruebatecnicainterrapidisimo.login.domain.model.CredencialesAuthenticaUsuarioDomain
import com.example.pruebatecnicainterrapidisimo.login.domain.model.transformarCredencialesAuthenticaUsuarioDomainABodyAuthenticaUsuarioAppDTO
import com.example.pruebatecnicainterrapidisimo.login.domain.repository.LoginRemoteRepositoryInterface
import org.json.JSONObject
import javax.inject.Inject


class LoginRemoteRepository @Inject constructor(
    private val interrapidisimoApi: InterrapidisimoApi
) : LoginRemoteRepositoryInterface {
    override suspend fun validateCurrentVersion() : ApiResponseStatus<String> {
         try {
            val call = interrapidisimoApi.getVPStoreAppControl()
            if (call.isSuccessful) {
                val respuestaBody = call.body() ?: return ApiResponseStatus.Error("fallo")
                return ApiResponseStatus.Success(data = respuestaBody)
            }else {
                return ApiResponseStatus.Error( "fallo")
            }
        }catch (e: Exception) {
            return ApiResponseStatus.Error( "fallo")
        }
    }

    override suspend fun authenticarUsuario(
        credencialesUsuario: CredencialesAuthenticaUsuarioDomain
    ) : ApiResponseStatus<AutheticaUsuarioAppDomain>{
        try {
            val call = interrapidisimoApi.postAuthenticaUsuario(
                body = credencialesUsuario.transformarCredencialesAuthenticaUsuarioDomainABodyAuthenticaUsuarioAppDTO()
            )
            if (call.isSuccessful){
                val respuestaUsuario = call.body() ?: return ApiResponseStatus.Error("fallo")

                return ApiResponseStatus.Success(respuestaUsuario.transformarResponseAuthenticaUsuarioAppDTOAAutheticaUsuarioAppDomain())
            }else{
                val mensajeErrorJson = call.errorBody()?.string()
                val errorBody = JSONObject(mensajeErrorJson ?: "")
                val mensajeError = errorBody.getString("Message")
                return ApiResponseStatus.Error(message = mensajeError)
            }

        }catch(e : Exception) {
        Log.e("error", e.message.toString())
            return ApiResponseStatus.Error("fallo")
        }
    }
}