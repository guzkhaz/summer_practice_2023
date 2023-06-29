package com.itis.task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var heightEditText: EditText
    private lateinit var weightEditText: EditText
    private lateinit var ageEditText: EditText
    private lateinit var calculateButton: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameEditText = findViewById(R.id.nameEditText)
        heightEditText = findViewById(R.id.heightEditText)
        weightEditText = findViewById(R.id.weightEditText)
        ageEditText = findViewById(R.id.ageEditText)
        calculateButton = findViewById(R.id.calculateButton)
        resultTextView = findViewById(R.id.resultTextView)

        calculateButton.setOnClickListener {
            val name = nameEditText.text.toString().trim()
            val height = heightEditText.text.toString().toIntOrNull()
            val weight = weightEditText.text.toString().toDoubleOrNull()
            val age = ageEditText.text.toString().toIntOrNull()

            if (validateInput(name, height, weight, age)) {
                val result = calculateResult(height!!, weight!!, age!!, name.length)
                resultTextView.text = "Ответ: $result"
            } else {
                resultTextView.text = "Данные введены некорректно."
            }
        }
    }

    private fun validateInput(name: String, height: Int?, weight: Double?, age: Int?): Boolean {
        if (name.isBlank() || name.length > 50) {
            return false
        }

        if (height == null || height <= 0 || height >= 250) {
            return false
        }

        if (weight == null || weight <= 0 || weight >= 250) {
            return false
        }

        if (age == null || age <= 0 || age >= 150) {
            return false
        }

        return true
    }

    private fun calculateResult(height: Int, weight: Double, age: Int, nameLength: Int ): Int {
        return ((((nameLength * 15) + weight) / 7 *height / 235) + age).toInt()
        //произвольная формула
    }

}