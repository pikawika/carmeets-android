package com.lennertbontinck.carmeetsandroidapp.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import java.util.*

/**
 * Een Data [Class] die de informatie van een meeting bevat.
 */
@Parcelize
data class Meeting(
    @field:Json(name = "_id") val meetingId: String,
    @field:Json(name = "name") val title: String,
    @field:Json(name = "shortDescription") val subtitle: String,
    @field:Json(name = "fullDescription") val description: String,
    val categories: List<String>,
    val listUsersGoing: List<String>,
    val listUsersLiked: List<String>,
    val date: Date,
    val gemeente: String,
    val postcode: String,
    val straatnaam: String,
    val straatnr: String,
    val afbeeldingNaam: String,
    val site: String
): Parcelable