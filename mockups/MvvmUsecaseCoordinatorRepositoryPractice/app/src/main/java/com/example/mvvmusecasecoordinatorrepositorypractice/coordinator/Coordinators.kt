package com.example.mvvmusecasecoordinatorrepositorypractice.coordinator

import com.example.mvvmusecasecoordinatorrepositorypractice.addTodo.AddTodoCoordinator
import com.example.mvvmusecasecoordinatorrepositorypractice.home.HomeCoordinator

@Suppress("PropertyName")
interface Coordinators {
    val HOME: HomeCoordinator
    val ADD_TODO: AddTodoCoordinator
}