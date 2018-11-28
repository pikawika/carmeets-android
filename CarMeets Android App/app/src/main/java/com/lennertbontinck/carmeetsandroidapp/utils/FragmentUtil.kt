package com.lennertbontinck.carmeetsandroidapp.utils


import com.lennertbontinck.carmeetsandroidapp.activities.MainActivity
import android.support.v4.app.FragmentManager
import android.view.MenuItem
import com.lennertbontinck.carmeetsandroidapp.R

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
    fun checkFragmentEqualsNavItem(item: MenuItem?, supportFragmentManager : FragmentManager) : Boolean {
        //Context ophalen
        val context = MainActivity.getContext()
        //huidige item in de backstack zijn fragtag
        val currentFragTag = supportFragmentManager.getBackStackEntryAt(supportFragmentManager.backStackEntryCount - 1).name
        if (currentFragTag != null && currentFragTag != "") {
            //kijken of huidige fragtag de selected item al niet reeds heeft ingesteld
            when (currentFragTag) {
                context.getString(R.string.fragtag_meetinglist) -> if (item?.itemId == R.id.nav_meetings) return true
                context.getString(R.string.fragtag_favouriteslist) -> if (item?.itemId == R.id.nav_favourites) return true
                context.getString(R.string.fragtag_account) -> if (item?.itemId == R.id.nav_account) return true
            }
        }
        //default
        return false
    }
}