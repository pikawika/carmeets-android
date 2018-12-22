package com.lennertbontinck.carmeetsandroidapp.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Een Data [Class] die de informatie van een locatie bevat.
 *
 * Wordt opgebouwd adhv properties uit een meeting
 */
@Parcelize
data class Location(
    val city: String,
    val postalCode: String,
    val streetName: String,
    val houseNumber: String
): Parcelable