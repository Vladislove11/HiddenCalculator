package com.example.hiddencalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.MultiAutoCompleteTextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {

    private lateinit var firstArgumentET: EditText
    private lateinit var secondArgument: EditText

    private lateinit var addBTN: Button
    private lateinit var subBTN: Button
    private lateinit var multiBTN: Button
    private lateinit var divBTN: Button

    private lateinit var returnData: Button
    private var resultCalc: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        firstArgumentET = findViewById(R.id.firstArgument)
        secondArgument = findViewById(R.id.secondArgument)

        addBTN = findViewById(R.id.addingBTN)
        subBTN = findViewById(R.id.subtractBTN)
        multiBTN = findViewById(R.id.multiplyBTN)
        divBTN = findViewById(R.id.divBTN)

        returnData = findViewById(R.id.returnData)

        addBTN.setOnClickListener {
            resultCalc = Operation(firstArgumentET.text.toString().toDouble(), secondArgument.text.toString().toDouble()).sum()
        }
        subBTN.setOnClickListener {
            resultCalc = Operation(firstArgumentET.text.toString().toDouble(), secondArgument.text.toString().toDouble()).dif()
        }
        multiBTN.setOnClickListener {
            resultCalc = Operation(firstArgumentET.text.toString().toDouble(), secondArgument.text.toString().toDouble()).mult()
        }
        divBTN.setOnClickListener {
            resultCalc = Operation(firstArgumentET.text.toString().toDouble(), secondArgument.text.toString().toDouble()).div()
        }

        returnData.setOnClickListener {
            val intent = Intent()
            intent.putExtra("resultCalc", resultCalc.toString())
            setResult(RESULT_OK, intent)
            finish()
        }

    }
}