package com.example.httpgetpractice.room

import androidx.room.*

@Dao
interface CustomerDatabaseDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(customer: Customer)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    fun update(customer: Customer)

    @Query("SELECT * from customer_table")
    fun get(): Customer?
}