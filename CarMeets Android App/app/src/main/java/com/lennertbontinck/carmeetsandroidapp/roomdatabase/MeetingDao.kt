package com.lennertbontinck.carmeetsandroidapp.roomdatabase

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.lennertbontinck.carmeetsandroidapp.models.Meeting

@Dao
/**
 * Een doa interface voor het uitvoeren van acties om de room database zijn meeting_table
 */
interface MeetingDao {

    /**
     * Zet een meeting in de room database
     */
    @Insert
    fun insert(meeting: Meeting)

    /**
     * Haal alle meetings uit de room database
     */
    @Query("SELECT * FROM meeting_table")
    fun getAllMeetings(): LiveData<List<Meeting>>

    /**
     * Clear de room database zijn *meeting_table*
     */
    @Query("DELETE FROM meeting_table")
    fun deleteAllMeetings()
}