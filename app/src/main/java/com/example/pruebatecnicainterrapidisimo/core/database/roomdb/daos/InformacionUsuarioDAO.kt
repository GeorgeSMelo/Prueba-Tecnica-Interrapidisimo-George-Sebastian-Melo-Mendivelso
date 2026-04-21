package com.example.pruebatecnicainterrapidisimo.core.database.roomdb.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pruebatecnicainterrapidisimo.core.database.roomdb.entities.InformacionUsuarioEntity

@Dao
interface InformacionUsuarioDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun guardarUsuario(informacionUsuarioEntity: InformacionUsuarioEntity)

    @Query("SELECT * FROM informacionusuario ORDER BY id DESC LIMIT 1")
    suspend fun obtenerUltimoUsuario(): InformacionUsuarioEntity?

}