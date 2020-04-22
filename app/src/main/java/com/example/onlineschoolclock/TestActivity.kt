package com.example.onlineschoolclock

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
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
        var phour = 0
        var pminute = 0

        var cyear = 0
        var cmonth = 0
        var cday = 0
        var chour = 0
        var cminute = 0

        val picktestdate = findViewById<Button>(R.id.testenterdate)
        val picktesttime = findViewById<Button>(R.id.testentertime)


        picktesttime.setOnClickListener {
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                TestTime.setText("" + hour + " " + minute)
                phour = hour
                pminute = minute

            }
            TimePickerDialog(this, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()
        }

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
        shower.setOnClickListener({
            println("Picked: " + pyear + " " + pmonth + " " + pday + " " + phour + " " + pminute)
            val converted = TimeConverter(pyear, pmonth, pday, phour, pminute)
            cyear = converted.cyear
            cmonth = converted.cmonth
            cday = converted.cday
            chour = converted.chour
            cminute = converted.cminute
            println("Converted: " + cyear + " " + cmonth + " " + cday + " " + chour + " " + cminute)
        })
    }
}


