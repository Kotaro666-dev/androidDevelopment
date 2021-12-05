package com.example.mvvmusecasecoordinatorrepositorypractice.home

import android.content.Context
import android.content.Intent
import com.example.mvvmusecasecoordinatorrepositorypractice.addTodo.AddTodoActivity
import com.example.mvvmusecasecoordinatorrepositorypractice.coordinator.BasicCoordinator

class HomeCoordinator : BasicCoordinator {
    override fun start(context: Context) {
        context.startActivity(
            Intent(context, AddTodoActivity::class.java)
        )
    }
}