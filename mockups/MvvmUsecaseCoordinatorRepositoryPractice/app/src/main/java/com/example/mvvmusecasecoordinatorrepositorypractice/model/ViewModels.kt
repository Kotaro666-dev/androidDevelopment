package com.example.mvvmusecasecoordinatorrepositorypractice.model

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

class ViewModels {

    companion object {
        fun <T : ViewModel> of(activity: FragmentActivity, modelClass: Class<T>): T {
            val factory = AppViewModelFactory.getInstance(activity.application)
            return ViewModelProviders.of(activity, factory).get(modelClass)
        }

        fun <T : ViewModel> of(fragment: Fragment, modelClass: Class<T>): T {
            val factory = AppViewModelFactory.getInstance(fragment.requireActivity().application)
            return ViewModelProviders.of(fragment, factory).get(modelClass)
        }
    }
}