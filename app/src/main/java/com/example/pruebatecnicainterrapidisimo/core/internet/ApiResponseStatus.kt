package com.example.pruebatecnicainterrapidisimo.core.internet

/**
 * ApiResponseStatus = Aqui se gestiona los diferentes procesos que puede tener la prueba tecnica al momento de llamar un endpoint
 * Success = Este estado sirve para el endpoint funciona de manera correcta y no ha habido ningun tipo de fallo.
 * Loading = Este estado se utiliza principalmente cuando se lanza los datos del endpoint y este esta esperando para evaluar una respuesta final
 * Error = Este estado se lanza en caso de que los datos del endpoint haya fallado.
 */

sealed class ApiResponseStatus<T> {
    class Success<T>(val data: T) : ApiResponseStatus<T>()
    class Loading<T> : ApiResponseStatus<T>()
    class Error<T>(val message: String) : ApiResponseStatus<T>()
}