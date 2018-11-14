package com.lennertbontinck.carmeetsandroidapp.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Meeting(
    val meetingId: String,
    val titel: String,
    val subtitel: String,
    val beschrijving: String,
    val categorien: List<String>,
    val gebruikerIdsGoing: List<String>,
    val gebruikerIdsLiked: List<String>,
    val datum: Date,
    val gemeente: String,
    val postcode: String,
    val straatnaam: String,
    val straatnr: String,
    //tijelijk int voor dummy data
    val afbeeldingNaam: Int,
    val site: String
): Parcelable