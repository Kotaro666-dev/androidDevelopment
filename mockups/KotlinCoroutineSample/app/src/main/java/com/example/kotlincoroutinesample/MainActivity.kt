package com.example.kotlincoroutinesample

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.kotlincoroutinesample.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        setContentView(binding.root)

        binding.buttonRequestApi.setOnClickListener {
            resetUiAttributes()
            viewModel.requestApi()
        }

        viewModel.isLoading.observe(this) { isLoading ->
            if (isLoading) {
                binding.buttonRequestApi.isEnabled = false
                binding.text.text = "Wait for a moment....."
                binding.buttonRequestApi.text = "Requesting API...."
            } else {
                binding.buttonRequestApi.isEnabled = true
                binding.text.text = "API request is done!"
                binding.text.setTextColor(ContextCompat.getColor(this, R.color.purple_700))
                binding.buttonRequestApi.text = "Request API"
            }
        }

        viewModel.dataFromApi1.observe(this) { data ->
            binding.textDataFromApi1.append(data)
        }

        viewModel.dataFromApi2.observe(this) { data ->
            binding.textDataFromApi2.append(data)
        }

        viewModel.dataFromApi3.observe(this) { data ->
            binding.textDataFromApi3.append(data)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun resetUiAttributes() {
        binding.text.text = "Click button and start requesting API!"
        binding.text.setTextColor(ContextCompat.getColor(this, R.color.black))
        binding.textDataFromApi1.text = "Data from API 1: "
        binding.textDataFromApi2.text = "Data from API 2: "
        binding.textDataFromApi3.text = "Data from API 3: "
    }
}