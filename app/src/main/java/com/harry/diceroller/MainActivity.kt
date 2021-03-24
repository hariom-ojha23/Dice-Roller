package com.harry.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

/**
 * This activity allow the user to roll a dice and view result on screen
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firstImage()
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
    }

    /**
     * showing firat random image of dice
     */

    private fun firstImage() {
        val dice = Dice(6)
        val diceRoll = dice.roll()

        val firstImg : ImageView = findViewById(R.id.imageView)
        val drawableImg = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        firstImg.setImageResource(drawableImg)
    }

    /**
     * roll the dice and update the result on screen
     */
    private fun rollDice() {
        // create new dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // find image view in layout and updating image with every roll
        val diceImg: ImageView = findViewById(R.id.imageView)

        // determining which drawable resource id to use
        val drawableImg = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // update the ImageView with correct drawable id
        diceImg.setImageResource(drawableImg)

        // update the content description
        diceImg.contentDescription = diceRoll.toString()
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random() // returning randomly generated number after rolling
    }
}