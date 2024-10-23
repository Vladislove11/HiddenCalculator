package com.example.hiddencalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var resultTV: TextView
    private lateinit var callCalcBTN: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        resultTV = findViewById(R.id.resultTV)
        callCalcBTN = findViewById(R.id.callCalcBTN)

        callCalcBTN.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            launcherSomeActivity.launch(intent)
        }

    }

    private val launcherSomeActivity = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val data = result.data
            val resultCalc = data!!.getStringExtra("resultCalc")

            resultTV.text = resultCalc.toString()

        } else {
            Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show()
        }
    }
}