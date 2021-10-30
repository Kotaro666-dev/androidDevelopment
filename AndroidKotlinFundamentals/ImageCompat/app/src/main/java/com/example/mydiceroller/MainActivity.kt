package com.example.mydiceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var diceImage: ImageView
    var currentNumber: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceImage = findViewById(R.id.dice_image)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice(diceImage) }

        val countUpButton: Button = findViewById(R.id.count_up_button)
        countUpButton.setOnClickListener { countUp(diceImage) }

        val resetButton: Button = findViewById(R.id.reset_button)
        resetButton.setOnClickListener { reset(diceImage) }
    }

    private fun updateCurrentNumber(number: Int) {
        currentNumber = number
    }

    private fun getDrawableResource(number: Int): Int {
        return when (number) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }

    private fun rollDice(diceImage: ImageView) {
        val randomNumber = (1..6).random()
        updateCurrentNumber(randomNumber)
        val drawableResource = getDrawableResource(randomNumber)
        diceImage.setImageResource(drawableResource)

    }

    private fun countUp(diceImage: ImageView) {
        if (this.currentNumber == 0 || 6 <= this.currentNumber) {
            return
        }
        this.currentNumber++
        val drawableResource = getDrawableResource(this.currentNumber)
        diceImage.setImageResource(drawableResource)
    }

    private fun reset(diceImage: ImageView) {
        diceImage.setImageResource(R.drawable.empty_dice)
    }
}