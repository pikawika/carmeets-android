package com.lennertbontinck.carmeetsandroidapp.utils

import android.arch.persistence.room.TypeConverter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import java.util.*

/**
 * Een util om je te helpen met de room database,
 * in het bijzonder voor het converten van waardes naar een in room opslaanbaar type.
 */
class RoomConverters {

    /**;
     * Zet een [Date] object om naar een [Long] zodat deze kan worden opgeslaan in de lokale databank
     */
    @TypeConverter
    fun dateToLong(date: Date?): Long? {
        return date?.time
    }

    /**
     * Zet een [Long] time object (uit db) om naar een [Date] object voor gebruik in de app.
     */
    @TypeConverter
    fun longToDate(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    /**
     * Zet een [List] object van [String] objecten om naar een json [String]
     * zodat deze kan worden opgeslaan in de lokale databank.
     */
    @TypeConverter
    fun stringListToJson(stringList: List<String>): String {
        val listMyData = Types.newParameterizedType(List::class.java, String::class.java)
        val jsonAdapter = Moshi.Builder().build().adapter<List<String>>(listMyData)
        return jsonAdapter.toJson(stringList)
    }

    /**
     * Zet een json [String] (uit db) om naar een [List] object van [String] objecten voor gebruik in de app.
     */
    @TypeConverter
    fun jsonToStringList(stringListJson: String): List<String> {
        val listMyData = Types.newParameterizedType(List::class.java, String::class.java)
        val jsonAdapter = Moshi.Builder().build().adapter<List<String>>(listMyData)
        return jsonAdapter.fromJson(stringListJson)!!
    }
}