package com.example.onlineschoolclock

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val assignbutton = findViewById<Button>(R.id.assignbutton)
        assignbutton.setOnClickListener()
        {
            val changetoAssignment = Intent(this, AssignmentActivity::class.java)
            startActivity(changetoAssignment)
        }

        val testbutton = findViewById<Button>(R.id.testbutton)
        testbutton?.setOnClickListener()
        {
            val changetoTest = Intent(this, TestActivity::class.java)
            startActivity(changetoTest)
        }


    }
}
