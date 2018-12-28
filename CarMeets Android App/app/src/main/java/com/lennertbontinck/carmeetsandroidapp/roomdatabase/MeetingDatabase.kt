package com.lennertbontinck.carmeetsandroidapp.roomdatabase

import android.arch.persistence.room.*
import android.content.Context
import com.lennertbontinck.carmeetsandroidapp.constants.ROOM_DATABASE_NAME
import com.lennertbontinck.carmeetsandroidapp.models.Meeting
import com.lennertbontinck.carmeetsandroidapp.utils.RoomUtil

//versie nummer dat je normaal bij elke aanpassing naar omhoog moet doen
//en hoe je conversie klasses kan voorzien, wegens development mag dit altijd op 1 blijven aangezien het tijdsverspilling
//zou zijn om altijd adapters te bouwen wanneer we app gwn kunnen clean installen.

//exportSchema op false aangezien dit niet gecontroleerd dient te worden ne we dus geen error willen zien dat ze niet
//is meegegeven.
@Database(entities = [Meeting::class], version = 1, exportSchema = false)
// Type Converters worden gebruikt om complexe objecten op te kunnen slaan.
// -> In dit geval wordt dit gebruikt voor de datum van de meeting
// en de conversie van een string lijst naar json (categories/listUsersGoing/listUsersLiked)
@TypeConverters(RoomUtil::class)
/**
 * Een [RoomDatabase] voor de app zijnde de [MeetingDatabase].
 * De naam van de database is: carmeets_database.
 */
abstract class MeetingDatabase : RoomDatabase() {

    /**
     * Functie voor het bekomen van de [MeetingDao]
     */
    abstract fun meetingDao() : MeetingDao

    companion object {
        /**
         * Een instantie van de [MeetingDatabase]
         */
        private var instance : MeetingDatabase? = null

        /**
         * Verkrijg de instantie van de [MeetingDatabase].
         * Er gebeurt een check zodat maar 1 instantie aangemaakt wordt (singleton principe).
         */
        fun getInstance(context: Context) : MeetingDatabase {
            if (instance != null) return instance!!

            val newInstance = Room.databaseBuilder(
                context,
                MeetingDatabase::class.java,
                ROOM_DATABASE_NAME
            ).build()

            instance = newInstance

            return newInstance
        }
    }
}