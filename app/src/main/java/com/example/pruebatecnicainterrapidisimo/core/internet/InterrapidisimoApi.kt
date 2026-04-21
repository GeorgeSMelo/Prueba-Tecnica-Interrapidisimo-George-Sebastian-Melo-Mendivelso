package com.example.pruebatecnicainterrapidisimo.core.internet

import com.example.pruebatecnicainterrapidisimo.home.data.model.ResponseObtenerEsquemaDTO
import com.example.pruebatecnicainterrapidisimo.localidades.data.model.RespuestaApiLocalidadesDTO
import com.example.pruebatecnicainterrapidisimo.login.data.model.BodyAuthenticaUsuarioAppDTO
import com.example.pruebatecnicainterrapidisimo.login.data.model.ResponseAuthenticaUsuarioAppDTO
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface InterrapidisimoApi {
    @GET("apicontrollerpruebas/api/ParametrosFramework/ConsultarParametrosFramework/VPStoreAppControl")
    suspend fun getVPStoreAppControl() : Response<String>


    @POST("FtEntregaElectronica/MultiCanales/ApiSeguridadPruebas/api/Seguridad/AuthenticaUsuarioApp")
    suspend fun postAuthenticaUsuario(
        @Body body : BodyAuthenticaUsuarioAppDTO,
        @Header("Usuario") usuario : String = "pam.meredy21",
        @Header("Identificacion") identificacion : String = "987204545",
        @Header("IdUsuario") idUsuario : String = "pam.meredy21",
        @Header("IdCentroServicio") idCentroServicio : String = "1295",
        @Header("NombreCentroServicio") nombreCentroServicio : String = "PTO/BOGOTA/CUND/COL/OF PRINCIPAL - CRA 30 # 7-45",
        @Header("IdAplicativoOrigen") idAplicativoOrigen : String = "9",
        @Header("Accept") accept : String = "text/json",
        @Header("Content-Type") contentType: String = "application/json"
    ) : Response<ResponseAuthenticaUsuarioAppDTO>

    @GET("apicontrollerpruebas/api/SincronizadorDatos/ObtenerEsquema/true")
    suspend fun getObtenerEsquema(
        @Header("Usuario") usuario : String = "pam.meredy21",
        @Header("Identificacion") identificacion : String = "987204545",
        @Header("IdUsuario") idUsuario : String = "pam.meredy21",
        @Header("IdCentroServicio") idCentroServicio : String = "1295",
        @Header("NombreCentroServicio") nombreCentroServicio : String = "PTO/BOGOTA/CUND/COL/OF PRINCIPAL - CRA 30 # 7-45",
        @Header("IdAplicativoOrigen") idAplicativoOrigen : String = "9",
        @Header("Accept") accept : String = "text/json",
        @Header("Content-Type") contentType: String = "application/json"
    ): Response<List<ResponseObtenerEsquemaDTO>>

    @GET("apicontrollerpruebas/api/ParametrosFramework/ObtenerLocalidadesRecogidas")
    suspend fun getLocalidades() : Response<List<RespuestaApiLocalidadesDTO>>

}