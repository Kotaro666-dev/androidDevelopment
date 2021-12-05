package com.example.mvvmusecasecoordinatorrepositorypractice.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo_table")
data class TodoDataClass(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,

    @ColumnInfo(name = "title")
    var title: String = "",

    @ColumnInfo(name = "is_done")
    var isDone: Boolean = false
)