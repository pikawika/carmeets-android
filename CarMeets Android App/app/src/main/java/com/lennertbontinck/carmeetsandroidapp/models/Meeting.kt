package com.lennertbontinck.carmeetsandroidapp.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import java.util.*

/**
 * Een Data [Class] die de informatie van een meeting bevat.
 */
//tabel naam voor in de room database
@Entity(tableName = "meeting_table")
@Parcelize
open class Meeting(
    //primaire sleutel anotatie nodig voor room lokale databank
    @PrimaryKey
    @field:Json(name = "_id") val meetingId: String,
    @field:Json(name = "name") val title: String,
    @field:Json(name = "shortDescription") val subtitle: String,
    @field:Json(name = "fullDescription") val description: String,
    val categories: List<String>,
    val listUsersGoing: List<String>,
    val listUsersLiked: List<String>,
    val date: Date,
    @field:Json(name = "gemeente") val city: String,
    @field:Json(name = "postcode") val postalCode: String,
    @field:Json(name = "straatnaam") val streetName: String,
    @field:Json(name = "straatnr") val houseNumber: String,
    @field:Json(name = "afbeeldingNaam") val imageName: String,
    @field:Json(name = "site") val website: String
) : Parcelable {
    val location: Location
        get() {
            return Location(city, postalCode, streetName, houseNumber)
        }
}