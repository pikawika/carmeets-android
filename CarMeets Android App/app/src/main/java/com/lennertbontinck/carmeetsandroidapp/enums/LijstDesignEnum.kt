package com.lennertbontinck.carmeetsandroidapp.enums

import com.lennertbontinck.carmeetsandroidapp.R

/**
 * Een helpende enum klasse om een lijstdesign toe te kennen.
 * Elk enumitem heeft een *layoutId* (Int) waarde die overeenstemt met de id van de bijhorende xml die een recyclerviewitem voorstelt.
 * */
enum class LijstDesignEnum(val layoutId: Int) {
    KLEIN(R.layout.item_meeting_klein),
    GROOT(R.layout.item_meeting_groot)
}