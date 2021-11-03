package com.example.dialogs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dialogs.databinding.ActivityMainBinding
import com.example.dialogs.dialogs.BasicAlertDialogClass

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        binding.basicDialogButton.setOnClickListener { displayBasicAlertDialog() }

        setContentView(view)
    }

    private fun displayBasicAlertDialog() {
        val basicAlertDialog = BasicAlertDialogClass()
        basicAlertDialog.show(supportFragmentManager, "Basic Alert Dialog")
    }
}