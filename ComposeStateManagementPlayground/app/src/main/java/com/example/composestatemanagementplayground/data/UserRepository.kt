package com.example.composestatemanagementplayground.data

import com.example.composestatemanagementplayground.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun fetchAll(): Flow<List<User>>
}