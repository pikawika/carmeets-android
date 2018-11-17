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
     * @param[datum] Datum waarvan je shortMonthName wilt. Required of type Date
     *
     */
    @JvmStatic
    fun getShortMonthName(datum : Date) : String {
        return (DateFormat.format("MMMM", datum) as String).substring(0, 3)
    }

    /**
     * Returnt een String met de de *dag nummer in de maand* bv: 23
     *
     * @param[datum] Datum waarvan je dayInMonth wilt. Required of type Date
     *
     */
    fun getDayInMonth(datum : Date) : String {
        return DateFormat.format("dd", datum) as String
    }
}