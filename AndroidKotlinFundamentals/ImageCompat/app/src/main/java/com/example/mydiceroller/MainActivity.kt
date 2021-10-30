package com.example.mydiceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var diceImage1: ImageView
    private lateinit var diceImage2: ImageView
    private var currentNumberDice1: Int = 0
    private var currentNumberDice2: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceImage1 = findViewById(R.id.dice_image_1)
        diceImage2 = findViewById(R.id.dice_image_2)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice(diceImage1, diceImage2) }

        val countUpButton: Button = findViewById(R.id.count_up_button)
        countUpButton.setOnClickListener { countUp(diceImage1, diceImage2) }

        val resetButton: Button = findViewById(R.id.reset_button)
        resetButton.setOnClickListener { reset(diceImage1, diceImage2) }
    }

    private fun generateRandomNumber(): Int {
        return (1..6).random()
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

    private fun setDiceImage(diceImage: ImageView) {
        val randomNumber = generateRandomNumber()
        val drawableResource = getDrawableResource(randomNumber)
        diceImage.setImageResource(drawableResource)

        if (diceImage == diceImage1) {
            currentNumberDice1 = randomNumber
        } else {
            currentNumberDice2 = randomNumber
        }
    }

    private fun rollDice(diceImage1: ImageView, diceImage2: ImageView) {
        setDiceImage(diceImage1)
        setDiceImage(diceImage2)
    }

    private fun countUp(diceImage1: ImageView, diceImage2: ImageView) {
        if (this.currentNumberDice1 != 0 && this.currentNumberDice1 < 6) {
            this.currentNumberDice1++
            val drawableResource = getDrawableResource(this.currentNumberDice1)
            diceImage1.setImageResource(drawableResource)
        }
        if (this.currentNumberDice2 != 0 && this.currentNumberDice2 < 6) {
            this.currentNumberDice2++
            val drawableResource = getDrawableResource(this.currentNumberDice2)
            diceImage2.setImageResource(drawableResource)
        }
    }

    private fun reset(diceImage1: ImageView, diceImage2: ImageView) {
        diceImage1.setImageResource(R.drawable.empty_dice)
        diceImage2.setImageResource(R.drawable.empty_dice)
    }
}