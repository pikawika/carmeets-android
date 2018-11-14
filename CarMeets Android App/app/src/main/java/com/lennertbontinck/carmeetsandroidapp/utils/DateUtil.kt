package com.lennertbontinck.carmeetsandroidapp.utils

import android.text.format.DateFormat
import java.util.*

object DateUtil {

    @JvmStatic
    fun getShortMonthName(datum : Date) : String {
        return (DateFormat.format("MMMM", datum) as String).substring(0, 3)
    }

    fun getDay(datum : Date) : String {
        return DateFormat.format("dd", datum) as String
    }
}