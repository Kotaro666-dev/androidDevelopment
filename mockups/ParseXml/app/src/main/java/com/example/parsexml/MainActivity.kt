package com.example.parsexml

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.parsexml.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.button.setOnClickListener {
            try {
                val data = XmlParser().parse()
                setText(data)
            } catch (e: Exception) {
                e.printStackTrace()
                displayAlertDialog(e.message)
            }
        }
        setContentView(binding.root)
    }

    private fun setText(data: XmlData) {
        binding.id.append(data.id.toString())
        binding.firstName.append(data.firstName)
        binding.lastName.append(data.lastName)
        binding.phoneNumber.append(data.phoneNumber)
    }

    private fun displayAlertDialog(errorMessage: String?) {
        AlertDialog.Builder(this)
            .setTitle(DEFAULT_ERROR_DIALOG_TITLE)
            .setMessage(errorMessage ?: DEFAULT_ERROR_DIALOG_MESSAGE)
            .setPositiveButton(DEFAULT_POSITIVE_BUTTON_TITLE, null)
            .show()
    }

    companion object {
        private const val DEFAULT_ERROR_DIALOG_TITLE = "ERROR"
        private const val DEFAULT_ERROR_DIALOG_MESSAGE = "Error occurred."
        private const val DEFAULT_POSITIVE_BUTTON_TITLE = "OK"
    }
}