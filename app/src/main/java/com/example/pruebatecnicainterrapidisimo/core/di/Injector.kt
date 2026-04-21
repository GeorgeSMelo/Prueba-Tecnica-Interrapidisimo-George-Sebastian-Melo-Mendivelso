package com.example.pruebatecnicainterrapidisimo.core.di

import android.content.Context
import androidx.room.Room
import com.example.pruebatecnicainterrapidisimo.core.ROOM_DATABASE_NAME
import com.example.pruebatecnicainterrapidisimo.core.database.roomdb.InterRoomDataBase
import com.example.pruebatecnicainterrapidisimo.core.database.roomdb.daos.EsquemasTablasDAO
import com.example.pruebatecnicainterrapidisimo.core.database.roomdb.daos.InformacionUsuarioDAO
import com.example.pruebatecnicainterrapidisimo.core.internet.InterrapidisimoApi
import com.example.pruebatecnicainterrapidisimo.home.data.repository.HomeLocalRepository
import com.example.pruebatecnicainterrapidisimo.home.data.repository.HomeRemoteRepository
import com.example.pruebatecnicainterrapidisimo.home.domain.repository.HomeLocalRepositoryInterface
import com.example.pruebatecnicainterrapidisimo.home.domain.repository.HomeRemoteRepositoryInterface
import com.example.pruebatecnicainterrapidisimo.localidades.data.repository.LocalidadesRemoteRepository
import com.example.pruebatecnicainterrapidisimo.localidades.domain.repository.LocalidadesRemoteRepositoryInterface
import com.example.pruebatecnicainterrapidisimo.login.data.repository.LoginLocalRepository
import com.example.pruebatecnicainterrapidisimo.login.data.repository.LoginRemoteRepository
import com.example.pruebatecnicainterrapidisimo.login.domain.repository.LoginLocalRepositoryInterface
import com.example.pruebatecnicainterrapidisimo.login.domain.repository.LoginRemoteRepositoryInterface
import com.example.pruebatecnicainterrapidisimo.tablas.data.repository.TablasLocalRepository
import com.example.pruebatecnicainterrapidisimo.tablas.domain.repository.TablasLocalRepositoryInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

object Injector {
    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://apitesting.interrapidisimo.co/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient
            .Builder()
            .build()
    }

    @Singleton
    @Provides
    fun provideLoginLocalRepositoryInterface(
        loginLocalRepository: LoginLocalRepository
    ) : LoginLocalRepositoryInterface = loginLocalRepository

    @Singleton
    @Provides
    fun provideHomeLocalRepositoryInterface(
        homeLocalRepository: HomeLocalRepository
    ) : HomeLocalRepositoryInterface = homeLocalRepository

    @Singleton
    @Provides
    fun provideLoginRemoteRepositoryInterface(
        loginRemoteRepository: LoginRemoteRepository
    ): LoginRemoteRepositoryInterface = loginRemoteRepository

    @Singleton
    @Provides
    fun provideInterrapisimoApi(retrofit: Retrofit): InterrapidisimoApi {
        return retrofit.create(InterrapidisimoApi::class.java)
    }
    @Singleton
    @Provides
    fun provideHomeRemoteRepositoryInterface(
        homeRemoteRepository: HomeRemoteRepository
    ): HomeRemoteRepositoryInterface = homeRemoteRepository

    @Singleton
    @Provides
    fun provideTablasLocalRepositoryInterface(
        tablasLocalRepository: TablasLocalRepository
    ): TablasLocalRepositoryInterface = tablasLocalRepository

    @Singleton
    @Provides
    fun provideLocalidadesRemoteRespositoryInterface(
        localidadadesRemoteRepository: LocalidadesRemoteRepository
    ): LocalidadesRemoteRepositoryInterface = localidadadesRemoteRepository

    @Provides
    @Singleton
    fun provideInterRoomDataBase(@ApplicationContext context: Context): InterRoomDataBase {
        return Room.databaseBuilder(
            context = context,
            klass = InterRoomDataBase::class.java,
            name = ROOM_DATABASE_NAME
        ).build()
    }

    @Provides
    fun provideInformacionUsuarioDAO(dataBase: InterRoomDataBase): InformacionUsuarioDAO {
        return dataBase.myInformacionUsuarioDAO()
    }

    @Provides
    fun provideEsquemasTablasDAO(dataBase: InterRoomDataBase): EsquemasTablasDAO{
        return dataBase.myEsquemasTablasDAO()
    }

}