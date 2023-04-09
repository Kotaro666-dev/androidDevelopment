package com.example.counterappwithmvppattern.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.counterappwithmvppattern.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), CounterView {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // TODO: Presenter should be called here to initialize the view

        binding.incrementButton.setOnClickListener {
            println("Increment button clicked")
            // TODO: Presenter should be called here
        }

        binding.decrementButton.setOnClickListener {
            println("Decrement button clicked")
            // TODO: Presenter should be called here
        }
    }

    override fun showValue(value: Int) {
        binding.counterValue.text = value.toString()
    }
}