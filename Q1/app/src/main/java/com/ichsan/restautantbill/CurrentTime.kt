package com.ichsan.restautantbill

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class DateNow(pattern : String) {
    @RequiresApi(Build.VERSION_CODES.O)
    val current : LocalDateTime = LocalDateTime.now()

    @RequiresApi(Build.VERSION_CODES.O)
    val formatter : DateTimeFormatter = DateTimeFormatter.ofPattern(pattern)
    @RequiresApi(Build.VERSION_CODES.O)
    val now : String = current.format(formatter)

}