package com.example.httpgetpractice.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "customer_table")
data class Customer(
    @PrimaryKey
    var id: Long = 0L,

    @ColumnInfo(name = "name")
    var name: String = "",

    @ColumnInfo(name = "account_number")
    var accountNumber: String = "",

    @ColumnInfo(name = "is_logged_in")
    var isLoggedIn: Boolean = false,

    @ColumnInfo(name = "deposit_number")
    var depositNumber: Int = 0
)