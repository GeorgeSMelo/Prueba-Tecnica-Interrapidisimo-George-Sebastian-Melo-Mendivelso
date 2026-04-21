package com.example.pruebatecnicainterrapidisimo.login.data.model

import com.google.gson.annotations.SerializedName

data class BodyAuthenticaUsuarioAppDTO(
    @SerializedName("Mac") val mac : String,
    @SerializedName("NomAplicacion") val nomAplicacion : String,
    @SerializedName("Password") val password : String,
    @SerializedName("Path") val path : String,
    @SerializedName("Usuario") val usuario : String,
)