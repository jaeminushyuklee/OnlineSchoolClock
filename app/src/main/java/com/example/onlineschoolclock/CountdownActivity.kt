package com.example.onlineschoolclock

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.countdown_activity.*
import java.util.*

class CountdownActivity : AppCompatActivity() {
    private val handler = Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.countdown_activity)

        handler.post(object : Runnable {
            override fun run() {
                handler.postDelayed(this, 1000)
                updateCountdown()
            }
        })
    }
    fun updateCountdown() {
        // Set Current Date
        val currentDate = Calendar.getInstance()

        // Set Event Date
        val eventDate = Calendar.getInstance()
        eventDate[Calendar.YEAR] = getIntent().getIntExtra("cyear",0)
        eventDate[Calendar.MONTH] = getIntent().getIntExtra("cmonth",0) - 1
        eventDate[Calendar.DAY_OF_MONTH] = getIntent().getIntExtra("cday",0)
        eventDate[Calendar.HOUR_OF_DAY] = getIntent().getIntExtra("chour",0)
        eventDate[Calendar.MINUTE] = getIntent().getIntExtra("cminute",0)
        eventDate[Calendar.SECOND] = 0
        eventDate.timeZone = TimeZone.getTimeZone("GMT+9")

        // Find how many milliseconds until the event
        val diff = eventDate.timeInMillis - currentDate.timeInMillis


        // Change the milliseconds to days, hours, minutes and seconds
        val days = (diff) / (24 * 60 * 60 * 1000)
        val hours = (diff) / (1000 * 60 * 60) % 24
        val minutes = diff / (1000 * 60) % 60
        val seconds = (diff / 1000) % 60


        // Display Countdown
        countdowntimer.text = "${days}d ${hours}h ${minutes}m ${seconds}s"

        // Show different text when the event has passed
        endEvent(currentDate, eventDate)
    }
    private fun endEvent(currentdate: Calendar, eventdate: Calendar) {
        if (currentdate.time >= eventdate.time) {
            countdowntimer.text = "Good Luck!"
            //Stop Handler
            handler.removeMessages(0)
        }
    }
}