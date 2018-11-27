package com.lennertbontinck.carmeetsandroidapp.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import java.util.*

/**
 * Een Data [Class] die de informatie van 1 meeting bevat.
 */
@Parcelize
data class Meeting(
    val meetingId: String,
    @field:Json(name = "name") val titel: String,
    @field:Json(name = "shortDescription") val subtitel: String,
    @field:Json(name = "fullDescription") val beschrijving: String,
    @field:Json(name = "categories") val categorien: List<String>,
    @field:Json(name = "listUsersGoing") val gebruikerIdsGoing: List<String>,
    @field:Json(name = "listUsersLiked") val gebruikerIdsLiked: List<String>,
    @field:Json(name = "date") val datum: Date,
    val gemeente: String,
    val postcode: String,
    val straatnaam: String,
    val straatnr: String,
    val afbeeldingNaam: String,
    val site: String
): Parcelable