package com.lennertbontinck.carmeetsandroidapp.models

/**
 * Een Data [Class] die de informatie van een meeting bevat met als extentie info over de user m.b.t deze meeting (al dan niet liked en going).
 */
data class MeetingWithUserInfo(
    val meeting: Meeting,
    val isUserGoing: Boolean,
    val isUserLiked: Boolean
) : Meeting(
    meeting.meetingId,
    meeting.title,
    meeting.subtitle,
    meeting.description,
    meeting.categories,
    meeting.listUsersGoing,
    meeting.listUsersLiked,
    meeting.date,
    meeting.city,
    meeting.postalCode,
    meeting.streetName,
    meeting.houseNumber,
    meeting.imageName,
    meeting.website
)