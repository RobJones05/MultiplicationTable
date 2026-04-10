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
        val multiplyTbl = findViewById<TextView>(R.id.multiplyTableText)
        var tableDisplay = "$tableNumber times table\n\n"
        var count = 1
        val answer = tableNumber * count
        multiplyTbl.text = tableDisplay

        while (count <= 10) {

            val answer = tableNumber * count

            tableDisplay += "$tableNumber x $count = $answer\n"

            count++

        }

        tableDisplay += "*$tableDisplay x $count = $answer\n"
        count++





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}