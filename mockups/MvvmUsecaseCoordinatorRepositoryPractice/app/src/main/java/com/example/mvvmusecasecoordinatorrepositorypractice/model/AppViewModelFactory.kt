package com.example.mvvmusecasecoordinatorrepositorypractice.model

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmusecasecoordinatorrepositorypractice.CustomApplication
import com.example.mvvmusecasecoordinatorrepositorypractice.Dependency
import com.example.mvvmusecasecoordinatorrepositorypractice.addTodo.AddTodoUseCase
import com.example.mvvmusecasecoordinatorrepositorypractice.addTodo.AddTodoViewModel
import com.example.mvvmusecasecoordinatorrepositorypractice.home.HomeUseCase
import com.example.mvvmusecasecoordinatorrepositorypractice.home.HomeViewModel

class AppViewModelFactory(dependency: Dependency) : ViewModelProvider.Factory {

    companion object {

        private var INSTANCE: AppViewModelFactory? = null

        fun getInstance(app: Application) =
            INSTANCE ?: synchronized(AppViewModelFactory::class.java) {
                INSTANCE ?: AppViewModelFactory((app as CustomApplication).dependency).also {
                    INSTANCE = it
                }
            }
    }

    private val coordinators = dependency.coordinators
    private val repository = dependency.repository

    override fun <T : ViewModel> create(modelClass: Class<T>): T = when (modelClass) {
        HomeViewModel::class.java -> HomeViewModel(
            coordinator = coordinators.HOME,
            useCase = HomeUseCase(repository),
        )
        AddTodoViewModel::class.java -> AddTodoViewModel(
            coordinator = coordinators.ADD_TODO,
            useCase = AddTodoUseCase(repository),
        )
        else -> throw IllegalArgumentException("No ViewModel registered for $modelClass")
    } as T
}