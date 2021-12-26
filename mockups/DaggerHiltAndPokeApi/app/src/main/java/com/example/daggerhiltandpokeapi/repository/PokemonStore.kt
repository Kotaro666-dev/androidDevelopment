package com.example.daggerhiltandpokeapi.repository

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

@InstallIn(SingletonComponent::class)
@Module
class PokemonStore @Inject constructor() {

    private val _test = "test"
    val test: String
        get() = _test

}