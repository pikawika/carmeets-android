package com.lennertbontinck.carmeetsandroidapp.utils

import android.text.format.DateFormat
import java.util.*

/**
 * Een util om je te helpen met het werken met *datums*
 */
object DateUtil {

    /**
     * Returnt een String met *de eerste 3 characters van een maand* bv: Dec
     *
     * @param[date] Datum waarvan je shortMonthName wilt. Required of type Date
     *
     */
    @JvmStatic
    fun getShortMonthName(date: Date): String {
        return (DateFormat.format("MMMM", date) as String).substring(0, 3)
    }

    /**
     * Returnt een String met de de *dag nummer in de maand* bv: 23
     *
     * @param[date] Datum waarvan je dayInMonth wilt. Required of type Date
     *
     */
    fun getDayInMonth(date: Date): String {
        return DateFormat.format("dd", date) as String
    }
}