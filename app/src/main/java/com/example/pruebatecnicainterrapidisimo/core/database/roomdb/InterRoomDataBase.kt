package com.example.pruebatecnicainterrapidisimo.core.database.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pruebatecnicainterrapidisimo.core.database.roomdb.daos.EsquemasTablasDAO
import com.example.pruebatecnicainterrapidisimo.core.database.roomdb.daos.InformacionUsuarioDAO
import com.example.pruebatecnicainterrapidisimo.core.database.roomdb.entities.EsquemasTablasEntity
import com.example.pruebatecnicainterrapidisimo.core.database.roomdb.entities.InformacionUsuarioEntity

@Database(
    entities = [
        InformacionUsuarioEntity::class,
        EsquemasTablasEntity::class
               ],
    version = 3,
    exportSchema = false
)
abstract class InterRoomDataBase : RoomDatabase() {
    abstract fun myInformacionUsuarioDAO(): InformacionUsuarioDAO
    abstract fun myEsquemasTablasDAO(): EsquemasTablasDAO
}