package com.example.mydiceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.isDigitsOnly

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        val countUpButton: Button = findViewById(R.id.count_up_button)
        countUpButton.setOnClickListener { countUp() }

        val resetButton: Button = findViewById(R.id.reset_button)
        resetButton.setOnClickListener { reset() }
    }

    private fun rollDice() {
//        Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()
        val resultText: TextView = findViewById(R.id.result_text)
        val randomInt = (1..6).random()
        resultText.text = randomInt.toString()
    }

    private fun countUp() {
        val resultText: TextView = findViewById(R.id.result_text)
        if (!resultText.text.isDigitsOnly()) {
            resultText.text = "1"
            return
        }
        // The text value in resultText.text is an instance of the CharSequence class;
        // it needs to be converted to a String object before it can be converted to an int.
        var currentNumber: Int = resultText.text.toString().toInt()
        if (6 <= currentNumber) {
            return
        }
        currentNumber++;
        resultText.text = currentNumber.toString()
    }

    private fun reset() {
        val resultText: TextView = findViewById(R.id.result_text)
        if (!resultText.text.isDigitsOnly()) {
            return
        }

        resultText.text = "0"
    }
}