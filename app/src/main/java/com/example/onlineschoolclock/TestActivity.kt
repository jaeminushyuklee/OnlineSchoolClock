package com.example.onlineschoolclock

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.test.*
import java.util.Calendar

class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test)
        var pyear = 0
        var pmonth = 0
        var pday = 0
        val picktestdate = findViewById<Button>(R.id.testenterdate)
        picktestdate.setOnClickListener {
            val c = Calendar.getInstance()
            val day = c.get(Calendar.DAY_OF_MONTH)
            val month = c.get(Calendar.MONTH)
            val year = c.get(Calendar.YEAR)
            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { datePicker, year, monthOfYear, dayOfMonth ->
                TestDate.setText("" + year + " " + (monthOfYear + 1) + " " + dayOfMonth)
                pyear = year
                pday = dayOfMonth
                pmonth = monthOfYear + 1
            }, year, month, day)
            dpd.show()
        }
        testerbutton.setOnClickListener({
            println("THIS STATEMENT " + pyear + " " + pmonth + " " + pday)
        })
    }
}


