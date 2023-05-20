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
                User("Alice Smith", 25, "USA"),
                User("Bob Tremblay", 32, "Canada"),
                User("Charlie Müller", 41, "Germany"),
                User("David Patel", 28, "India"),
                User("Eve Dubois", 35, "France"),
                User("Frank Suzuki", 45, "Japan"),
                User("Grace Silva", 38, "Brazil"),
                User("Henry López", 29, "Mexico"),
                User("Isabella Santos", 22, "Brazil"),
                User("Jack Chen", 37, "China"),
                User("Kate Johnson", 42, "USA"),
                User("Liam Wilson", 31, "Canada"),
                User("Mia Schmitt", 26, "Germany"),
                User("Noah Kumar", 33, "India"),
                User("Olivia Leblanc", 40, "France"),
                User("Oscar Sato", 27, "Japan"),
                User("Sophia Costa", 39, "Brazil"),
                User("Thomas Singh", 24, "India"),
                User("William Rodriguez", 36, "Mexico"),
                User("Zoe Li", 30, "China")
            )
            emit(users)
        }
}