package com.example.onlineschoolclock

class TimeConverter(val year: Int, val month: Int, val day: Int, val hour: Int, val minute: Int) {
    var cyear = 0
    var cmonth = 0
    var cday = 0
    var chour = 0
    var cminute = 0
    init {
        cminute = minute
        if (month == 12 && day == 31 && (hour + 14 >= 24)) {
            cyear = year + 1
        } else {
            cyear = year
        }
        if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && (day == 31) && (hour + 14 >= 24)) {
            cmonth = month + 1
        } else {
            cmonth = month
        }
        if (hour + 14 >= 24) {
            chour = hour + 14 - 24
            cday= day + 1
        } else {
            chour = hour + 14
            cday = day

        }
    }
}