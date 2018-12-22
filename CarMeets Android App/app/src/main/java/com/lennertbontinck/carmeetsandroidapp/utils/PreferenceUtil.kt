package com.lennertbontinck.carmeetsandroidapp.utils

import android.content.Context
import com.lennertbontinck.carmeetsandroidapp.R
import com.lennertbontinck.carmeetsandroidapp.constants.*
import com.lennertbontinck.carmeetsandroidapp.context.CarMeetsApplication
import com.lennertbontinck.carmeetsandroidapp.enums.MenuItemEnum

/**
 * Een util om je te helpen met de shared preferences van de app
 *
 * Shared preferences staan ingesteld op private zijnde dat ze niet toegangelijk zijn vanuit andere applicaties
 */
object PreferenceUtil {
    /**
     * De shared preferences in [Context.MODE_PRIVATE] zodat andere applicaties hier niet aan kunnen
     */
    private val sharedPreferences = CarMeetsApplication.getContext().getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)

    /**
     * Haalt de token op van de shared preferences
     */
    @JvmStatic
    fun getToken() : String? {
        return sharedPreferences.getString(PREFERENCE_TOKEN, "")
    }

    /**
     * Slaat de token op in de shared prefences
     *
     * @param token : de token van de aangemelde gebruiker
     */
    @JvmStatic
    fun setToken(token : String) {
        sharedPreferences.edit().putString(PREFERENCE_TOKEN, token).apply()
    }

    /**
     * Haalt de gebruikersnaam op van de shared preferences
     */
    @JvmStatic
    fun getUsername() : String? {
        return sharedPreferences.getString(PREFERENCE_USERNAME, "")
    }

    /**
     * Slaat de gebruikersnaam op in de shared prefences
     *
     * @param username : de gebruikersnaam van de aangemelde user
     */
    @JvmStatic
    fun setUsername(username : String) {
        sharedPreferences.edit().putString(PREFERENCE_USERNAME, username).apply()
    }

    /**
     * Haalt de standaard startpagina op van de shared preferences
     */
    @JvmStatic
    fun getDefaultBootPage() : MenuItemEnum {
        //default enum 0 -> meetings
        return MenuItemEnum.values()[sharedPreferences.getInt(PREFERENCE_DEFAULTBOOTPAGE, 0)]
    }

    /**
     * Slaat de standaard startpagina op in de shared prefences
     *
     * @param menuItem : de standaard startpagina als [MenuItemEnum]
     */
    @JvmStatic
    fun setDefaultBootPage(menuItem: MenuItemEnum) {
        sharedPreferences.edit().putInt(PREFERENCE_DEFAULTBOOTPAGE, menuItem.menuId).apply()
    }

    /**
     * Verwijderd alle sharedPreferences
     */
    @JvmStatic
    fun deletePreferences() {
        sharedPreferences.edit().clear().apply()
    }

}