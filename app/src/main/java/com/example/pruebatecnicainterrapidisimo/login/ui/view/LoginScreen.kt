package com.example.pruebatecnicainterrapidisimo.login.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pruebatecnicainterrapidisimo.BuildConfig
import com.example.pruebatecnicainterrapidisimo.R
import com.example.pruebatecnicainterrapidisimo.core.internet.ApiResponseStatus
import com.example.pruebatecnicainterrapidisimo.core.ui.LoaderBar
import com.example.pruebatecnicainterrapidisimo.login.domain.model.EnumChequeoVersion
import com.example.pruebatecnicainterrapidisimo.login.ui.viewModel.LoginViewModel
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel,
    loginExitoso: () -> Unit
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val stateCurrentVersionRemote by loginViewModel.stateCurrentVersionRemote.observeAsState()
    val stateIniciarSesion by loginViewModel.stateIniciarSesion.observeAsState()
    val scopeSnackbar = rememberCoroutineScope()

    fun showSnackbar(mensaje : String){
        scopeSnackbar.launch {
            snackbarHostState.currentSnackbarData?.dismiss()

            snackbarHostState.showSnackbar(
                message = mensaje,
                duration = SnackbarDuration.Short
            )
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { paddingValues ->

        when(stateCurrentVersionRemote){
            is ApiResponseStatus.Error -> {
                showSnackbar(
                    mensaje = (stateCurrentVersionRemote as ApiResponseStatus.Error<String>).message
                )
            }
            is ApiResponseStatus.Loading -> {
                LoaderBar(
                    modifier = Modifier.fillMaxSize()
                )
            }
            is ApiResponseStatus.Success -> {
                if (loginViewModel.estadoVersion != null ) {
                    showSnackbar(
                        mensaje = obtenerMensajeEstadoVersion(estadoVersion = loginViewModel.estadoVersion!!)
                    )
                }
            }
            else -> Unit
        }
        when(stateIniciarSesion){
            is ApiResponseStatus.Error -> {
                showSnackbar(
                    mensaje = (stateIniciarSesion as ApiResponseStatus.Error<String>).message
                )
            }
            is ApiResponseStatus.Loading -> {
                LoaderBar(
                    modifier = Modifier.fillMaxSize()
                )
            }
            is ApiResponseStatus.Success -> {loginExitoso()}
            else -> Unit
        }


        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    loginViewModel.validateControlVersion(
                        versionLocal = BuildConfig.VERSION_NAME
                    )
                },
                modifier = Modifier
                    .height(50.dp),
                shape = RoundedCornerShape(20),
            ) {
                Text(
                    text = stringResource(R.string.validar_version),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(80.dp))
            Button(
                onClick = {loginViewModel.iniciarSesion()},
                modifier = Modifier
                    .height(50.dp)
                    .width(100.dp),
                shape = RoundedCornerShape(20),
            ) {
                Text(
                    text = stringResource(R.string.login),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

private fun obtenerMensajeEstadoVersion(estadoVersion : EnumChequeoVersion) : String{
    return when (estadoVersion){
        EnumChequeoVersion.VERSION_MAYOR -> "La version local es mayor a la version del servidor"
        EnumChequeoVersion.VERSION_MENOR -> "La version local es menor a la version del servidor"
        EnumChequeoVersion.VERSION_IGUAL -> "la version local es igual a la version del servidor"
    }
}
