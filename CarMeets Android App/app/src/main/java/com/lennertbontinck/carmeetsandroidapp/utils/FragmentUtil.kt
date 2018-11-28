package com.lennertbontinck.carmeetsandroidapp.utils

import android.content.Context
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
     * @param[context] De context. Required of type Context.
     *
     * @param[item] De aangeklikte menu item. Required of type MenuItem.
     *
     * @param[supportFragmentManager] De gebruikte supportFragmentManager. Required of type FragmentManager.
     *
     */
    @JvmStatic
    fun checkFragmentEqualsNavItem(context: Context, item: MenuItem?, supportFragmentManager : FragmentManager) : Boolean {
        //huidige item in de backstack zijn fragtag
        val huidigeFragTag = supportFragmentManager.getBackStackEntryAt(supportFragmentManager.backStackEntryCount - 1).name
        if (huidigeFragTag != null && huidigeFragTag != "") {
            //kijken of huidige fragtag de selected item al niet reeds heeft ingesteld
            when (huidigeFragTag) {
                context.getString(R.string.fragtag_meetinglijst) -> if (item?.itemId == R.id.nav_meetings) return true
                context.getString(R.string.fragtag_favorietenlijst) -> if (item?.itemId == R.id.nav_favorieten) return true
                context.getString(R.string.fragtag_account) -> if (item?.itemId == R.id.nav_account) return true
            }
        }
        //default
        return false
    }
}