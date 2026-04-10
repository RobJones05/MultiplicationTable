package com.example.multiplication_table

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MultiplicationTable : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_multiplication_table)

        //recieving data from main activity
        val bundle: Bundle? = intent.extras
        val tableString: String? = bundle?.getString("tableNumber")
        val tableNumber = tableString!!.toInt()

        // Convert received string to integer
        val multiplyTbl = findViewById<TextView>(R.id.multiplyTableText)

        // Start output string
        var tableDisplay = "$tableNumber times table\n\n"

        // Counter for loop
        var count = 1

        // Calculate answer
        val answer = tableNumber * count
        multiplyTbl.text = tableDisplay

        while (count <= 20) {

            val answer = tableNumber * count

            tableDisplay += "$tableNumber x $count = $answer\n"

            count++

        }






        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}