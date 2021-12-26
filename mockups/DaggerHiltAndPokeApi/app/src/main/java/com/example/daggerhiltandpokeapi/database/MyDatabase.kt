package com.example.daggerhiltandpokeapi.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.daggerhiltandpokeapi.repository.Pokemon
import com.example.daggerhiltandpokeapi.repository.PokemonDao

@Database(entities = [Pokemon::class], version = 1, exportSchema = false)
abstract class MyDatabase : RoomDatabase() {

    abstract val pokemonDatabase: PokemonDao

    companion object {

        @Volatile
        private var INSTANCE: MyDatabase? = null

        fun getInstance(context: Context): MyDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MyDatabase::class.java,
                        "my_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}