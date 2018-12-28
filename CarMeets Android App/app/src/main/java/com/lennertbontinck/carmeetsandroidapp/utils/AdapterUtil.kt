package com.lennertbontinck.carmeetsandroidapp.utils

import com.lennertbontinck.carmeetsandroidapp.models.Meeting
import com.lennertbontinck.carmeetsandroidapp.models.MeetingWithUserInfo

/**
 * Een util om je te helpen met het omzetten van een object naar een ander object (adapter principe).
 */
object AdapterUtil {

    /**
     * Returnt een [MeetingWithUserInfo] voor de gegeven [Meeting] en gebruikerId.
     *
     * @param meeting : [Meeting] dat je wenst om te zetten naar [MeetingWithUserInfo]. Required of type [Meeting].
     *
     * @param userId : Id van de aangemelde gebruiker. Optional of type [String].
     */
    fun meetingToMeetingWithUserInfo(meeting: Meeting, userId: String = "-1"): MeetingWithUserInfo {
        return MeetingWithUserInfo(
            meeting = meeting,
            isUserGoing = (meeting.listUsersGoing.contains(userId)),
            isUserLiked = (meeting.listUsersLiked.contains(userId))
        )
    }
}