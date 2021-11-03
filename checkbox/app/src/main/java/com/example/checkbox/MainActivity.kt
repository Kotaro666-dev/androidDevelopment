package com.example.checkbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.checkbox.databinding.ActivityMainBinding
import android.widget.CheckBox
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val checkBox = arrayOfNulls<CheckBox>(3)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        setListenerToCheckbox()

        setContentView(view)
    }

    private fun setListenerToCheckbox() {
        binding.checkBox1.isChecked = false
        binding.checkBox2.isChecked = false
        binding.checkBox3.isChecked = false

        binding.checkBox1.setOnClickListener {
            val isChecked = binding.checkBox1.isChecked
            if (isChecked) {
                binding.checkBox1.text = "Checked"
            } else {
                binding.checkBox1.text = "Unchecked"
            }
        }

        binding.checkBox2.setOnClickListener {
            val isChecked = binding.checkBox2.isChecked
            if (isChecked) {
                binding.checkBox2.text = "Checked"
            } else {
                binding.checkBox2.text = "Unchecked"
            }
        }

        binding.checkBox3.setOnClickListener {
            val isChecked = binding.checkBox3.isChecked
            if (isChecked) {
                binding.checkBox3.text = "Checked"
            } else {
                binding.checkBox3.text = "Unchecked"
            }
        }
    }
}