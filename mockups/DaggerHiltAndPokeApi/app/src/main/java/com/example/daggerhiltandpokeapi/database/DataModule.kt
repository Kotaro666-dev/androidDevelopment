package com.example.daggerhiltandpokeapi.database

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

// 参考資料：https://qiita.com/k__yamamoto/items/5354d1f71b9d51c12f20

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    fun provideMyDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, MyDatabase::class.java, "my_database")
            .build()
}