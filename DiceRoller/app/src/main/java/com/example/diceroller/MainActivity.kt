package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(/* layoutResID = */ R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button3)
        val rollButton2: Button = findViewById(R.id.button6)
        rollButton.setOnClickListener { rollDice(1) }
        rollButton2.setOnClickListener { rollDice(2) }
    }

    private fun rollDice(i : Int) {
        // create 2 new dice object and roll
        val dice1 = Dice(6)
        val dice2 = Dice(6)
        val dice1Roll = dice1.roll()
        val dice2Roll = dice2.roll()

        // update screen with result
        val resultTextView1: TextView = findViewById(R.id.textView)
        val resultTextView2: TextView = findViewById(R.id.textView2)
        if (i==1) {
            resultTextView1.text = dice1Roll.toString()
        }
        else resultTextView2.text = dice2Roll.toString()
    }

    private class Dice(val numSides: Int) {

        fun roll(): Int {
            return (1..numSides).random()
        }
    }
}

