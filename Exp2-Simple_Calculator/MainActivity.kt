package com.example.calculatorapp233

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    // Declare necessary variables for the TextView and Buttons
    private lateinit var display: TextView
    private lateinit var seven: Button
    private lateinit var eight: Button
    private lateinit var nine: Button
    private lateinit var divide: Button
    private lateinit var four: Button
    private lateinit var five: Button
    private lateinit var six: Button
    private lateinit var multiply: Button
    private lateinit var one: Button
    private lateinit var two: Button
    private lateinit var three: Button
    private lateinit var subtract: Button
    private lateinit var decimal: Button
    private lateinit var zero: Button
    private lateinit var equal: Button
    private lateinit var add: Button
    private lateinit var clear: Button

    // Define variables to store values
    private var currentInput = StringBuilder()
    private var operand1: Double? = null
    private var operator: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Bind views to their corresponding UI elements
        display = findViewById(R.id.display)
        seven = findViewById(R.id.seven)
        eight = findViewById(R.id.eight)
        nine = findViewById(R.id.nine)
        divide = findViewById(R.id.divide)
        four = findViewById(R.id.four)
        five = findViewById(R.id.five)
        six = findViewById(R.id.six)
        multiply = findViewById(R.id.multiply)
        one = findViewById(R.id.one)
        two = findViewById(R.id.two)
        three = findViewById(R.id.three)
        subtract = findViewById(R.id.subtract)
        decimal = findViewById(R.id.decimal)
        zero = findViewById(R.id.zero)
        equal = findViewById(R.id.equal)
        add = findViewById(R.id.add)
        clear = findViewById(R.id.clear)

        // Set button listeners for number buttons and operator buttons
        setNumberButtonListener(seven, "7")
        setNumberButtonListener(eight, "8")
        setNumberButtonListener(nine, "9")
        setNumberButtonListener(four, "4")
        setNumberButtonListener(five, "5")
        setNumberButtonListener(six, "6")
        setNumberButtonListener(one, "1")
        setNumberButtonListener(two, "2")
        setNumberButtonListener(three, "3")
        setNumberButtonListener(zero, "0")
        setNumberButtonListener(decimal, ".")

        setOperatorButtonListener(add, "+")
        setOperatorButtonListener(subtract, "-")
        setOperatorButtonListener(multiply, "X")
        setOperatorButtonListener(divide, "/")

        equal.setOnClickListener {
            calculateResult()
        }

        clear.setOnClickListener {
            clearDisplay()
        }
    }

    // Function to handle number button clicks
    private fun setNumberButtonListener(button: Button, value: String) {
        button.setOnClickListener {
            currentInput.append(value)
            display.text = currentInput.toString()
        }
    }

    // Function to handle operator button clicks
    private fun setOperatorButtonListener(button: Button, operatorSymbol: String) {
        button.setOnClickListener {
            if (currentInput.isNotEmpty()) {
                operand1 = currentInput.toString().toDouble()
                operator = operatorSymbol
                currentInput.clear()
                display.text = ""
            }
        }
    }

    // Function to calculate the result based on the operator
    private fun calculateResult() {
        try {
            if (currentInput.isNotEmpty() && operand1 != null && operator != null) {
                val operand2 = currentInput.toString().toDouble()
                var result: Double? = null

                when (operator) {
                    "+" -> result = operand1!! + operand2
                    "-" -> result = operand1!! - operand2
                    "X" -> result = operand1!! * operand2
                    "/" -> result = operand1!! / operand2
                }

                // Display the result
                display.text = result.toString()
                currentInput.clear()
                operand1 = null
                operator = null
            }
        } catch (e: Exception) {
            display.text = "Error"
            currentInput.clear()
            operand1 = null
            operator = null
        }
    }

    // Function to clear the display
    private fun clearDisplay() {
        currentInput.clear()
        display.text = ""
        operand1 = null
        operator = null
    }
}
