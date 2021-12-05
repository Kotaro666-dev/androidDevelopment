package com.example.mvvmusecasecoordinatorrepositorypractice

import android.app.Application

open class CustomApplication : Application() {

    val dependency: Dependency by lazy {
        Dependency.resolve(this)
    }

    override fun onCreate() {
        super.onCreate()
    }
}