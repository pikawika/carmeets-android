package com.lennertbontinck.carmeetsandroidapp.enums

import com.lennertbontinck.carmeetsandroidapp.R

/**
 * Een helpende enum klasse om een actieve pagina toe te kennen.
 * Elk enumitem heeft een *menuId* [Int] die overeenstemt met de id van de bijhorende menu item.
 * */
enum class MenuItemEnum(val menuId: Int) {
    MEETINGS(R.id.nav_meetings),
    FAVOURITES(R.id.nav_favourites),
    ACCOUNT(R.id.nav_account)
}