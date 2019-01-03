package com.lennertbontinck.utils

import com.lennertbontinck.carmeetsandroidapp.models.Meeting
import com.lennertbontinck.carmeetsandroidapp.utils.AdapterUtil
import org.junit.Test

import org.junit.Assert.*
import java.util.*

/**
 * tests voor de adapter util.
 */
class AdapterUtilTest {
    private var categories = listOf("cat1", "cat2")
    private var userId = "1"
    private var listUsersGoingWithoutUser = listOf("2", "3")
    private var listUsersGoingWithUser = listOf("1", "2")
    private var listUsersLikedWithoutUser = listOf("2", "3")
    private var listUsersLikedWithUser = listOf("1", "2")

    private val meetingWithoutUserLink = Meeting("1", "title", "subtitle", "descrtpition", categories, listUsersGoingWithoutUser, listUsersLikedWithoutUser, Date(), "Schellebelle", "9260", "Dendermondsesteenweg","92", "img", "https://www.lennertbontinck.com")
    private val meetingWithUserLiked = Meeting("2", "title", "subtitle", "descrtpition", categories, listUsersGoingWithoutUser, listUsersLikedWithUser, Date(), "Schellebelle", "9260", "Dendermondsesteenweg","92", "img", "https://www.lennertbontinck.com")
    private val meetingWithUserGoing = Meeting("3", "title", "subtitle", "descrtpition", categories, listUsersGoingWithUser, listUsersLikedWithoutUser, Date(), "Schellebelle", "9260", "Dendermondsesteenweg","92", "img", "https://www.lennertbontinck.com")
    private val meetingWithUserLikedAndGoing = Meeting("4", "title", "subtitle", "descrtpition", categories, listUsersGoingWithUser, listUsersLikedWithUser, Date(), "Schellebelle", "9260", "Dendermondsesteenweg","92", "img", "https://www.lennertbontinck.com")

    @Test
    fun adapterUtil_meetingToMeetingWithUserInfo_noUserLink() {
        val meetingWithUserInfo = AdapterUtil.meetingToMeetingWithUserInfo(meetingWithoutUserLink, userId)
        assertEquals(meetingWithUserInfo.isUserGoing, false)
        assertEquals(meetingWithUserInfo.isUserLiked, false)
    }

    @Test
    fun adapterUtil_meetingToMeetingWithUserInfo_userLiked() {
        val meetingWithUserInfo = AdapterUtil.meetingToMeetingWithUserInfo(meetingWithUserLiked, userId)
        assertEquals(meetingWithUserInfo.isUserGoing, false)
        assertEquals(meetingWithUserInfo.isUserLiked, true)
    }

    @Test
    fun adapterUtil_meetingToMeetingWithUserInfo_userGoing() {
        val meetingWithUserInfo = AdapterUtil.meetingToMeetingWithUserInfo(meetingWithUserGoing, userId)
        assertEquals(meetingWithUserInfo.isUserGoing, true)
        assertEquals(meetingWithUserInfo.isUserLiked, false)
    }

    @Test
    fun adapterUtil_meetingToMeetingWithUserInfo_userLikedAndGoing() {
        val meetingWithUserInfo = AdapterUtil.meetingToMeetingWithUserInfo(meetingWithUserLikedAndGoing, userId)
        assertEquals(meetingWithUserInfo.isUserGoing, true)
        assertEquals(meetingWithUserInfo.isUserLiked, true)
    }
}