package com.lennertbontinck.carmeetsandroidapp.roomDatabase

import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import com.lennertbontinck.carmeetsandroidapp.constants.ROOM_DATABASE_NAME
import com.lennertbontinck.carmeetsandroidapp.models.Meeting
import com.lennertbontinck.carmeetsandroidapp.roomDatabase.RoomDatabaseTestUtils.getValue
import com.lennertbontinck.carmeetsandroidapp.roomdatabase.MeetingDao
import com.lennertbontinck.carmeetsandroidapp.roomdatabase.MeetingDatabase
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.util.*

class RoomDatabaseTest {
    private lateinit var meetingDao: MeetingDao
    private lateinit var db: MeetingDatabase

    private var categories = listOf("cat1", "cat2")
    private var listUsersGoingWithoutUser = listOf("2", "3")
    private var listUsersGoingWithUser = listOf("1", "2")
    private var listUsersLikedWithoutUser = listOf("2", "3")
    private var listUsersLikedWithUser = listOf("1", "2")

    private var meeting1 : Meeting = Meeting("1", "title", "subtitle", "descrtpition", categories, listUsersGoingWithoutUser, listUsersLikedWithoutUser, Date(), "Schellebelle", "9260", "Dendermondsesteenweg","92", "img", "https://www.lennertbontinck.com")
    private val meeting2 : Meeting = Meeting("2", "title", "subtitle", "descrtpition", categories, listUsersGoingWithoutUser, listUsersLikedWithUser, Date(), "Schellebelle", "9260", "Dendermondsesteenweg","92", "img", "https://www.lennertbontinck.com")
    private val meeting3 : Meeting = Meeting("3", "title", "subtitle", "descrtpition", categories, listUsersGoingWithUser, listUsersLikedWithoutUser, Date(), "Schellebelle", "9260", "Dendermondsesteenweg","92", "img", "https://www.lennertbontinck.com")
    private val meeting4 : Meeting = Meeting("4", "title", "subtitle", "descrtpition", categories, listUsersGoingWithUser, listUsersLikedWithUser, Date(), "Schellebelle", "9260", "Dendermondsesteenweg","92", "img", "https://www.lennertbontinck.com")


    @Before
    fun beforeTests() {
        val context = InstrumentationRegistry.getTargetContext()
        db = Room.inMemoryDatabaseBuilder(context, MeetingDatabase::class.java).build()
        meetingDao = db.meetingDao()

        //verwijder lokale db
        InstrumentationRegistry.getTargetContext()
            .deleteDatabase(ROOM_DATABASE_NAME)
    }

    @Test
    fun meetingDao_insertAndGetAllMeetings_insertsAndSaves4Meetings() {
        meetingDao.insert(meeting1)
        meetingDao.insert(meeting2)
        meetingDao.insert(meeting3)
        meetingDao.insert(meeting4)

        //juiste hoeveelheid meetings in lokale db
        assertEquals(4, getValue(meetingDao.getAllMeetings()).size)

        //meetings in db komen overeen met meetings
        assert(
            getValue(meetingDao.getAllMeetings())
                .map(Meeting::meetingId) == listOf(meeting1.meetingId, meeting2.meetingId, meeting3.meetingId ,meeting4.meetingId)
        )
    }

    @Test
    fun meetingDao_insertAndDeleteAllMeetings_inserts4MeetingsAndDeletesAllMeetings() {
        meetingDao.insert(meeting1)
        meetingDao.insert(meeting2)
        meetingDao.insert(meeting3)
        meetingDao.insert(meeting4)

        //juiste hoeveelheid meetings in lokale db
        assertEquals(4, getValue(meetingDao.getAllMeetings()).size)

        meetingDao.deleteAllMeetings()

        //na verwijderen zijn alle meetings leeg
        assertEquals(0, getValue(meetingDao.getAllMeetings()).size)
    }
}
