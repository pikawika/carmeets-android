package com.lennertbontinck.carmeetsandroidapp.utils


import android.support.v4.app.FragmentManager
import android.view.MenuItem
import com.lennertbontinck.carmeetsandroidapp.R
import com.lennertbontinck.carmeetsandroidapp.activities.MainActivity
import com.lennertbontinck.carmeetsandroidapp.constants.*

/**
 * Een util om je te helpen werken met *fragments*.
 */
object FragmentUtil {
    /**
     * Kijkt of de net aangemaakte fragment van hetzelfde type fragment die wordt aangemaakt bij het klikken op het meegeven menuitem.
     *
     * Context word uit [MainActivity] gehaald.
     *
     * @param[item] De aangeklikte menu item. Required of type MenuItem.
     *
     * @param[supportFragmentManager] De gebruikte supportFragmentManager. Required of type FragmentManager.
     *
     */
    @JvmStatic
    fun checkFragmentEqualsNavItem(item: MenuItem?, supportFragmentManager: FragmentManager): Boolean {
        //indien nog geen in de backstack kan het ook niet gelijk zijn
        if (supportFragmentManager.backStackEntryCount <= 1) return false
        //huidige item in de backstack zijn fragtag
        val currentFragTag =
            supportFragmentManager.getBackStackEntryAt(supportFragmentManager.backStackEntryCount - 1).name
        if (currentFragTag != null && currentFragTag != "") {
            //kijken of huidige fragtag de selected item al niet reeds heeft ingesteld
            when (currentFragTag) {
                FRAGTAG_MEETING_LIST -> if (item?.itemId == R.id.nav_meetings) return true
                FRAGTAG_FAVOURITES_LIST -> if (item?.itemId == R.id.nav_favourites) return true
                FRAGTAG_ACCOUNT -> if (item?.itemId == R.id.nav_account) return true
                FRAGTAG_LOGIN -> if (item?.itemId == R.id.nav_account) return true
                FRAGTAG_REGISTER -> if (item?.itemId == R.id.nav_account) return true
                FRAGTAG_CHANGE_PASSWORD -> if (item?.itemId == R.id.nav_account) return true
            }
        }
        //default
        return false
    }
}