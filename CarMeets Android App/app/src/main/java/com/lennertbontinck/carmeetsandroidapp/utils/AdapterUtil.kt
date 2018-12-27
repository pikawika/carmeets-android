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
    @JvmStatic
    fun meetingToMeetingWithUserInfo(meeting: Meeting, userId: String = "-1"): MeetingWithUserInfo {
        return MeetingWithUserInfo(
            meetingId = meeting.meetingId,
            categories = meeting.categories,
            date = meeting.date,
            description = meeting.description,
            imageName = meeting.imageName,
            listUsersGoing = meeting.listUsersGoing,
            listUsersLiked = meeting.listUsersLiked,
            location = meeting.location,
            subtitle = meeting.subtitle,
            title = meeting.title,
            website = meeting.website,
            isUserGoing = (meeting.listUsersGoing.contains(userId)),
            isUserLiked = (meeting.listUsersLiked.contains(userId))
        )
    }
}