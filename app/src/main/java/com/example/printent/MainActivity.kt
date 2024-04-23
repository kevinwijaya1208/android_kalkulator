package com.example.printent

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private val operands = mutableListOf<Int>()
    private val operators = mutableListOf<String>()
    companion object{
        val isiHasil : ArrayList<String> = arrayListOf()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var _btnExplisit3 = findViewById<Button>(R.id.btnExplisit3)
        _btnExplisit3.setOnClickListener {
            val intentWithData = Intent(this@MainActivity, actIntent3::class.java).apply {
                putExtra(actIntent3.dataHasil, isiHasil)
            }
            Log.i("calc", isiHasil.toString())
            startActivity(intentWithData)
        }

        // Set click listener for the "=" button
        val btnEqual = findViewById<Button>(R.id.btnExplisit1)
        btnEqual.setOnClickListener {
            // Calculate the result and start the second activity
            val result = calculateResult()
            isiHasil.add(result.toString())
            val intent = Intent(this@MainActivity, actIntent2::class.java).apply{
                putExtra(actIntent2.dataTerima, result.toString())
            }
            Log.i("calc", isiHasil.toString())
            startActivity(intent)
        }

        // Set click listeners for operator buttons
        val operatorButtons = listOf<Button>(
            findViewById(R.id.button4), // Addition
            findViewById(R.id.button8), // Subtraction
            findViewById(R.id.button12), // Multiplication
            findViewById(R.id.button15) // Division
        )

        for (button in operatorButtons) {
            button.setOnClickListener {
                val operator = when (button.id) {
                    R.id.button4 -> "+" // Addition
                    R.id.button8 -> "-" // Subtraction
                    R.id.button12 -> "x" // Multiplication
                    R.id.button15 -> "/" // Division
                    else -> "" // Default operator
                }
                operators.add(operator)
            }
        }

        // Set click listeners for number buttons to capture operands
        val numberButtons = listOf<Button>(
            findViewById(R.id.button),
            findViewById(R.id.button2),
            findViewById(R.id.button3),
            findViewById(R.id.button5),
            findViewById(R.id.button6),
            findViewById(R.id.button7),
            findViewById(R.id.button9),
            findViewById(R.id.button10),
            findViewById(R.id.button11),
            findViewById(R.id.button13)
        )

        for (button in numberButtons) {
            button.setOnClickListener {
                val operand = button.text.toString().toInt()
                operands.add(operand)
            }
        }
    }

    private fun calculateResult(): Int {
        var result = operands[0]

        for (i in 1 until operands.size) {
            when (operators[i - 1]) {
                "+" -> result += operands[i]
                "-" -> result -= operands[i]
                "x" -> result *= operands[i]
                "/" -> result /= operands[i]
            }
        }

        return result
    }
}

