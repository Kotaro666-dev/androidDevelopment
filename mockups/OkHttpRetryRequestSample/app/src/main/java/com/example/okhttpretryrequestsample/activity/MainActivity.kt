package com.example.okhttpretryrequestsample.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.okhttpretryrequestsample.R
import com.example.okhttpretryrequestsample.databinding.ActivityMainBinding
import com.example.okhttpretryrequestsample.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main
        )
        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.catFact.observe(this) { catFact ->
            binding.textCatFact.text = catFact
        }

        binding.buttonRequestApi.setOnClickListener {
            viewModel.requestApi()
        }
    }
}