package com.example.android.trackmysleepquality.database;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\'J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\'J\u0014\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\n0\tH\'J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\'J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0005H\'J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0005H\'\u00a8\u0006\u000f"}, d2 = {"Lcom/example/android/trackmysleepquality/database/SleepDatabaseDao;", "", "clear", "", "get", "Lcom/example/android/trackmysleepquality/database/SleepNight;", "key", "", "getAllNights", "Landroidx/lifecycle/LiveData;", "", "getTonight", "insert", "night", "update", "app_debug"})
public abstract interface SleepDatabaseDao {
    
    @androidx.room.Insert()
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    com.example.android.trackmysleepquality.database.SleepNight night);
    
    @androidx.room.Update()
    public abstract void update(@org.jetbrains.annotations.NotNull()
    com.example.android.trackmysleepquality.database.SleepNight night);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * from daily_sleep_quality_table WHERE nightId = :key")
    public abstract com.example.android.trackmysleepquality.database.SleepNight get(long key);
    
    @androidx.room.Query(value = "DELETE FROM daily_sleep_quality_table")
    public abstract void clear();
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM daily_sleep_quality_table ORDER BY nightId DESC LIMIT 1")
    public abstract com.example.android.trackmysleepquality.database.SleepNight getTonight();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM daily_sleep_quality_table ORDER BY nightId DESC")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.example.android.trackmysleepquality.database.SleepNight>> getAllNights();
}