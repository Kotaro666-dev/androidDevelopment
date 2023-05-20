package com.example.composestatemanagementplayground.data

import com.example.composestatemanagementplayground.model.User
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UserRepositoryImpl : UserRepository {
    override suspend fun fetchAll(): Flow<List<User>> =
        flow {
            delay(3000)
            val users = listOf(
                User("Adam", 28, "United States"),
                User(name = "John", age = 31, country = "United Kingdom"),
                User(name = "Ana", age = 28, country = "Spain"),
            )
            emit(users)
        }
}