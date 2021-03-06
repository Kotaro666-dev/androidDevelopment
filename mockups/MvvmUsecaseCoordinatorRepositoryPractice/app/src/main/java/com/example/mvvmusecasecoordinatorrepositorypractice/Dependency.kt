package com.example.mvvmusecasecoordinatorrepositorypractice

import com.example.mvvmusecasecoordinatorrepositorypractice.addTodo.AddTodoCoordinator
import com.example.mvvmusecasecoordinatorrepositorypractice.coordinator.Coordinators
import com.example.mvvmusecasecoordinatorrepositorypractice.database.AppDatabase
import com.example.mvvmusecasecoordinatorrepositorypractice.home.HomeCoordinator
import com.example.mvvmusecasecoordinatorrepositorypractice.room.Repository

class Dependency(application: CustomApplication) {

    companion object {
        fun resolve(app: CustomApplication): Dependency {
            return Dependency(app)
        }
    }

    val coordinators = object : Coordinators {
        override val HOME = HomeCoordinator()
        override val ADD_TODO = AddTodoCoordinator()
    }

    private val todoDatabase = AppDatabase.getInstance(application)
    val repository = Repository(todoDatabase)
}