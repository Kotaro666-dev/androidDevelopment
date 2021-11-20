package com.example.multiactivities.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.multiactivities.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private var _binding: ActivitySecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}