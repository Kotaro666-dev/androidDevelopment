package com.example.mvvmusecasecoordinatorrepositorypractice.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.mvvmusecasecoordinatorrepositorypractice.R
import com.example.mvvmusecasecoordinatorrepositorypractice.databinding.ActivityHomeBinding
import com.example.mvvmusecasecoordinatorrepositorypractice.model.ViewModels

class HomeActivity : AppCompatActivity() {
    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityHomeBinding>(this, R.layout.activity_home)
    }

    private val viewModel by lazy {
        ViewModels.of(this, HomeViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
    }
}