package com.example.pruebatecnicainterrapidisimo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pruebatecnicainterrapidisimo.core.HOME_SCREEN
import com.example.pruebatecnicainterrapidisimo.core.LOCALIDADES_SCREEN
import com.example.pruebatecnicainterrapidisimo.core.LOGIN_SCREEN
import com.example.pruebatecnicainterrapidisimo.core.TABLAS_SCREEN
import com.example.pruebatecnicainterrapidisimo.core.theme.PruebaTecnicaInterrapidisimoTheme
import com.example.pruebatecnicainterrapidisimo.home.ui.view.HomeScreen
import com.example.pruebatecnicainterrapidisimo.home.ui.viewmodel.HomeViewModel
import com.example.pruebatecnicainterrapidisimo.localidades.ui.view.LocalidadesScreen
import com.example.pruebatecnicainterrapidisimo.localidades.ui.viewmodel.LocalidadesViewModel
import com.example.pruebatecnicainterrapidisimo.login.ui.view.LoginScreen
import com.example.pruebatecnicainterrapidisimo.login.ui.viewModel.LoginViewModel
import com.example.pruebatecnicainterrapidisimo.tablas.ui.view.TablasScreen
import com.example.pruebatecnicainterrapidisimo.tablas.ui.viewmodel.TablasViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val loginViewModel: LoginViewModel by viewModels()
    val homeViewModel: HomeViewModel by viewModels()
    val tablasViewModel: TablasViewModel by viewModels()
    val localidadesViewModel: LocalidadesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PruebaTecnicaInterrapidisimoTheme {
                val navController = rememberNavController()
                NavHost(navController, startDestination = LOGIN_SCREEN) {
                    composable(LOGIN_SCREEN) {
                        LoginScreen(
                            loginViewModel = loginViewModel,
                            loginExitoso = {
                                navController.navigate(HOME_SCREEN)
                            }
                        )
                    }
                    composable(HOME_SCREEN) {
                        HomeScreen(
                            homeViewModel = homeViewModel,
                            navegarTablasScreen = {
                                navController.navigate(TABLAS_SCREEN)
                            },
                            navegarLocalidadesScreen = {
                                navController.navigate(LOCALIDADES_SCREEN)
                            }
                        )
                    }
                    composable(TABLAS_SCREEN) {
                        TablasScreen(
                            tablasViewModel = tablasViewModel,
                            onBack = {navController.popBackStack()}
                        )
                    }
                    composable(LOCALIDADES_SCREEN) {
                        LocalidadesScreen(
                            localidadesViewModel = localidadesViewModel,
                            onBack = {
                                navController.popBackStack()
                            }
                        )
                    }

                }


            }
        }
    }
}