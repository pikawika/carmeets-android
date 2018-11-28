package com.lennertbontinck.carmeetsandroidapp.enums

import com.lennertbontinck.carmeetsandroidapp.R

/**
 * Een helpende enum klasse om een lijstdesign toe te kennen.
 * Elk enumitem heeft een *layoutId* (Int) waarde die overeenstemt met de id van de bijhorende xml die een recyclerviewitem voorstelt.
 * */
enum class ListDesignEnum(val layoutId: Int) {
    SMALL(R.layout.item_meeting_small),
    BIG(R.layout.item_meeting_big)
}