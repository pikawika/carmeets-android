package com.lennertbontinck.carmeetsandroidapp.roomdatabase

import com.lennertbontinck.carmeetsandroidapp.models.Meeting
import com.lennertbontinck.carmeetsandroidapp.utils.MessageUtil

class MeetingRepository(private val meetingDao: MeetingDao) {
    /**
     * Alle meetings uit de room meeting databank
     */
    val meetings = meetingDao.getAllMeetings()

    /**
     * Verwijderd alle meetings momenteel aanwezig in de lokale room meeting databank en voegt de lijst van meetings toe.
     *
     * @param meetings : De lijst van meetings toe te voegen aan de nu lege lokale room databank zijn *meeting_table*.
     */
    fun insert(meetings: List<Meeting>) {
        //deze functie mag alle voorgaande verwijderen mits ze enkel mag uitgevoerd worden bij het verkrijgen van een
        //correct lijst
        delete()
        meetings.forEach { meetingDao.insert(it) }
    }

    /**
     * Verwijder alle meetings uit de lokale room database zijn *meeting_table*.
     */
    //kan publiek gemaakt worden maar in theorie is dit niet nodig mits hier geen gebruiker gevoelige informatie in staat
    //en dus niet dient verwijderd te worden op logout of dergelijke.
    private fun delete() {
        meetingDao.deleteAllMeetings()
    }

}