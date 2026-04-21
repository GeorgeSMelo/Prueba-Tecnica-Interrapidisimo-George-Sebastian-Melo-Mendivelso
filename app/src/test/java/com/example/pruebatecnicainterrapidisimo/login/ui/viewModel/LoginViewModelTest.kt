package com.example.pruebatecnicainterrapidisimo.login.ui.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.pruebatecnicainterrapidisimo.MainCoroutineRule
import com.example.pruebatecnicainterrapidisimo.core.internet.ApiResponseStatus
import com.example.pruebatecnicainterrapidisimo.login.domain.model.AutheticaUsuarioAppDomain
import com.example.pruebatecnicainterrapidisimo.login.domain.model.EnumChequeoVersion
import com.example.pruebatecnicainterrapidisimo.login.domain.useCases.GuardarUsuarioUseCase
import com.example.pruebatecnicainterrapidisimo.login.domain.useCases.IniciarSesionUseCase
import com.example.pruebatecnicainterrapidisimo.login.domain.useCases.LimpiarUsuarioUseCase
import com.example.pruebatecnicainterrapidisimo.login.domain.useCases.ValidateControlVersionUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class LoginViewModelTest {
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var loginViewModel: LoginViewModel

    private val validateControlVersionUseCase: ValidateControlVersionUseCase = mockk()
    private val iniciarSesionUseCase: IniciarSesionUseCase = mockk()
    private val guardarUsuarioUseCase: GuardarUsuarioUseCase = mockk()
    private val limpiarUsuarioUseCase: LimpiarUsuarioUseCase = mockk()
    
    @Before
    fun setup() {
        loginViewModel = LoginViewModel(
            validateControlVersionUseCase = validateControlVersionUseCase,
            iniciarSesionUseCase = iniciarSesionUseCase,
            guardarUsuarioUseCase = guardarUsuarioUseCase,
            limpiarUsuarioUseCase = limpiarUsuarioUseCase
        )
    }

    @Test
    fun `validateControlVersion trae del caso de uso validateControlVersionUseCase una version remota superior a la version local`() = runTest {
        // Given
        val versionRemoteFake = "100"
        coEvery { validateControlVersionUseCase() } returns ApiResponseStatus.Success(data = versionRemoteFake)

        // When
        loginViewModel.validateControlVersion("90")

        // Then
        assert(loginViewModel.estadoVersion == EnumChequeoVersion.VERSION_MENOR)
    }

    @Test
    fun `validateControlVersion trae del caso de uso validateControlVersionUseCase una version remota menor a la version local`() = runTest {
        // Given
        val versionRemoteFake = "100"
        coEvery { validateControlVersionUseCase() } returns ApiResponseStatus.Success(data = versionRemoteFake)

        // When
        loginViewModel.validateControlVersion("101")

        // Then
        assert(loginViewModel.estadoVersion == EnumChequeoVersion.VERSION_MAYOR)
    }

    @Test
    fun `validateControlVersion trae del caso de uso validateControlVersionUseCase una version remota igual a la version local`() = runTest {
        // Given
        val versionRemoteFake = "100"
        coEvery { validateControlVersionUseCase() } returns ApiResponseStatus.Success(data = versionRemoteFake)

        // When
        loginViewModel.validateControlVersion("100")

        // Then
        assert(loginViewModel.estadoVersion == EnumChequeoVersion.VERSION_IGUAL)
    }

    @Test
    fun `validateControlVersion trae del caso de uso validateControlVersionUseCase una version remota vacia y se valida con una version local vacia`() = runTest {
        // Given
        val versionRemoteFake = ""
        coEvery { validateControlVersionUseCase() } returns ApiResponseStatus.Success(data = versionRemoteFake)

        // When
        loginViewModel.validateControlVersion("")

        // Then
        assert(loginViewModel.estadoVersion == EnumChequeoVersion.VERSION_IGUAL)
    }

    @Test
    fun `validateControlVersion me trae del caso de uso validateControlVersionUseCase una respuesta API fallida`() = runTest {
        // Given
            coEvery { validateControlVersionUseCase() } returns ApiResponseStatus.Error(message = "Error")
        // When
        loginViewModel.validateControlVersion("100")
        // Then
        assert(loginViewModel.stateCurrentVersionRemote.value is ApiResponseStatus.Error)
    }

    @Test
    fun `iniciarSesion me trae del caso de uso iniciarSesionUseCase una respuesta API fallida`() = runTest {
        // Given
        coEvery { iniciarSesionUseCase(any()) } returns ApiResponseStatus.Error(message = "Error")

        // When
        loginViewModel.iniciarSesion()

        // Then
        assert(loginViewModel.stateIniciarSesion.value is ApiResponseStatus.Error)
    }

    @Test
    fun `iniciarSesion me trae del caso de uso iniciarSesionUseCase una respuesta API exitosa`() = runTest {
        // Given
        val autheticaUsuarioAppDomain = AutheticaUsuarioAppDomain(
            usuario = "usuarioFake",
            identificacion = "identificacionFake",
            nombre = "nombreFake",
            apellido1 = "",
            apellido2 = "",
            cargo = "",
            aplicaciones = "",
            ubicaciones = "",
            mensajeResultado = "",
            idLocalidad = "",
            nombreLocalidad = "",
            nomRol = "",
            idRol = "",
            tokenJWT = "",
            modulosApp = ""
        )
        coEvery { iniciarSesionUseCase(any()) } returns ApiResponseStatus.Success(data = autheticaUsuarioAppDomain)
        coEvery { guardarUsuarioUseCase(any()) } returns Unit
        coEvery { limpiarUsuarioUseCase() } returns Unit

        // When
        loginViewModel.iniciarSesion()

        // Then
        assert(loginViewModel.stateIniciarSesion.value is ApiResponseStatus.Success)
    }

}