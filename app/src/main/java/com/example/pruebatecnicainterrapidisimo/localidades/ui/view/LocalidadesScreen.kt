package com.example.pruebatecnicainterrapidisimo.localidades.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.pruebatecnicainterrapidisimo.R
import com.example.pruebatecnicainterrapidisimo.core.internet.ApiResponseStatus
import com.example.pruebatecnicainterrapidisimo.core.ui.LoaderBar
import com.example.pruebatecnicainterrapidisimo.localidades.domain.model.LocalidadesDomain
import com.example.pruebatecnicainterrapidisimo.localidades.ui.viewmodel.LocalidadesViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LocalidadesScreen(localidadesViewModel: LocalidadesViewModel, onBack: () -> Unit) {
    val estadoConsultarListadoLocalidadesRemote by localidadesViewModel.estadoConsultarListadoLocalidadesRemote.observeAsState()
    LaunchedEffect(Unit) {
        localidadesViewModel.obtenerLocalidadesRemote()
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(stringResource(R.string.localidades))
                },
                navigationIcon = {
                    IconButton(onClick = {onBack()}) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                )
            )
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier.fillMaxSize().padding(innerPadding)
        ) {
            when (estadoConsultarListadoLocalidadesRemote) {
                is ApiResponseStatus.Error -> {}
                is ApiResponseStatus.Success -> {
                    ListaLocalidades(
                        modifier = Modifier.fillMaxSize().padding(),
                        listaLocalidades = (estadoConsultarListadoLocalidadesRemote as ApiResponseStatus.Success<List<LocalidadesDomain>>).data
                    )
                }

                is ApiResponseStatus.Loading -> {
                    LoaderBar(
                        modifier = Modifier.fillMaxSize()
                    )
                }
                else -> Unit
            }
        }
    }
}


@Composable
fun ListaLocalidades(modifier: Modifier = Modifier, listaLocalidades: List<LocalidadesDomain>) {
    LazyColumn(
        modifier = modifier
    ) {
        items(listaLocalidades.size) { posicion ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = "${listaLocalidades[posicion].abreviacionCiudad} : ${listaLocalidades[posicion].nombreCompleto}",
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}