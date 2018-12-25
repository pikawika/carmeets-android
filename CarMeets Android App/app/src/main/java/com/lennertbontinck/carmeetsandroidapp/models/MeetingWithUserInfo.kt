package com.lennertbontinck.carmeetsandroidapp.models

import java.util.*

/**
 * Een Data [Class] die de informatie van een meeting bevat met als extentie info over de user m.b.t deze meeting (al dan niet liked en going).
 */
data class MeetingWithUserInfo(
    val meetingId: String,
    val title: String,
    val subtitle: String,
    val description: String,
    val categories: List<String>,
    val listUsersGoing: List<String>,
    val listUsersLiked: List<String>,
    val date: Date,
    val imageName: String,
    val website: String,
    val location: Location,
    val isUserGoing: Boolean,
    val isUserLiked: Boolean
)