package com.example.pruebatecnicainterrapidisimo.core.database.roomdb.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pruebatecnicainterrapidisimo.core.database.roomdb.entities.EsquemasTablasEntity

@Dao
interface EsquemasTablasDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun guardarEsquemas(listaDeEsquemas : List<EsquemasTablasEntity>)

    @Query("SELECT * FROM EsquemasTablas")
    suspend fun obtenerEsquemas() : List<EsquemasTablasEntity>

}