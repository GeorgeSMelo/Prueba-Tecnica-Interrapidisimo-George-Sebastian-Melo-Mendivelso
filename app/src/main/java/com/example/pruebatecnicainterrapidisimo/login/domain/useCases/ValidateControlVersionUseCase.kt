package com.example.pruebatecnicainterrapidisimo.login.domain.useCases

import com.example.pruebatecnicainterrapidisimo.core.internet.ApiResponseStatus
import com.example.pruebatecnicainterrapidisimo.login.domain.repository.LoginRemoteRepositoryInterface
import javax.inject.Inject


class ValidateControlVersionUseCase @Inject constructor(
    private val loginRemoteRepositoryInterface: LoginRemoteRepositoryInterface
) {
    suspend operator fun invoke() : ApiResponseStatus<String> {
       return loginRemoteRepositoryInterface.validateCurrentVersion()
    }
}
