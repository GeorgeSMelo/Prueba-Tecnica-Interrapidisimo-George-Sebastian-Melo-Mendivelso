package com.example.pruebatecnicainterrapidisimo.home.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pruebatecnicainterrapidisimo.R
import com.example.pruebatecnicainterrapidisimo.home.ui.viewmodel.HomeViewModel


@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel,
    navegarTablasScreen: () -> Unit,
    navegarLocalidadesScreen: () -> Unit,
) {

    val estadoInformacionLocalUsuario by homeViewModel.estadoInformacionLocalUsuario.observeAsState()

    homeViewModel.obtenerInformacionUsuario()
    homeViewModel.obtenerEsquemasBaseDatosRemote()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            "Usuario: ${estadoInformacionLocalUsuario?.usuario ?: ""}",
            modifier = Modifier.padding(16.dp)
        )
        Text(
            "Identificacion: ${estadoInformacionLocalUsuario?.identificacion ?: ""}",
            modifier = Modifier.padding(16.dp)
        )
        Text(
            "Nombre: ${estadoInformacionLocalUsuario?.nombre ?: ""}",
            modifier = Modifier.padding(16.dp)
        )

        Spacer(modifier = Modifier.height(30.dp))
        Button(
            onClick = { navegarTablasScreen() },
            modifier = Modifier
                .height(50.dp),
            shape = RoundedCornerShape(20),
        ) {
            Text(
                text = stringResource(R.string.tablas),
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )

        }
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            onClick = { navegarLocalidadesScreen() },
            modifier = Modifier
                .height(50.dp),
            shape = RoundedCornerShape(20),
        ) {
            Text(
                text = stringResource(R.string.localidades),
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}