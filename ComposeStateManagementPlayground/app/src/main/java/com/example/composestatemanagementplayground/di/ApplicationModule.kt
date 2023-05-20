package com.example.composestatemanagementplayground.di

import com.example.composestatemanagementplayground.data.UserRepository
import com.example.composestatemanagementplayground.data.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Provides
    fun provideUserRepository(
    ): UserRepository = UserRepositoryImpl()
}