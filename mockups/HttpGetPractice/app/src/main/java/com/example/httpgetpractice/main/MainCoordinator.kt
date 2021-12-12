package com.example.httpgetpractice.main

import android.content.Context
import android.content.Intent
import com.example.httpgetpractice.menu.MenuActivity

class MainCoordinator {

    fun start(context: Context) {
        context.startActivity(
            Intent(
                context,
                MenuActivity::class.java
            )
        )
    }
}