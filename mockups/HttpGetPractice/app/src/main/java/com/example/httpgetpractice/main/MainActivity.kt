package com.example.httpgetpractice.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.httpgetpractice.R
import com.example.httpgetpractice.databinding.ActivityMainBinding
import com.example.httpgetpractice.repository.Repository
import com.example.httpgetpractice.room.CustomerDatabase

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModelFactory = MainViewModelFactory(
            MainCoordinator(),
            MainUseCase(Repository(CustomerDatabase.getInstance(this)))
        )
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.buttonGetCustomerInfo.setOnClickListener {
            viewModel.getCustomerInfo()
        }
    }
}