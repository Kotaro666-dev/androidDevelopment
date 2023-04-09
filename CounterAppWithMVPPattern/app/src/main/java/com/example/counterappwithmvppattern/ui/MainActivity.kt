package com.example.counterappwithmvppattern

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.counterappwithmvppattern.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.incrementButton.setOnClickListener {
            println("Increment button clicked")
        }

        binding.decrementButton.setOnClickListener {
            println("Decrement button clicked")
        }
    }
}