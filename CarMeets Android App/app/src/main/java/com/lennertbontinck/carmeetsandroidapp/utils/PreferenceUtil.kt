package com.lennertbontinck.carmeetsandroidapp.utils

import android.content.Context
import com.lennertbontinck.carmeetsandroidapp.constants.*
import com.lennertbontinck.carmeetsandroidapp.context.CarMeetsApplication
import com.lennertbontinck.carmeetsandroidapp.enums.ListDesignEnum
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
     * Haalt de standaard startpagina op van de shared preferences
     */
    @JvmStatic
    fun getDefaultBootPage(): MenuItemEnum {
        //default enum 0 -> meetings
        return MenuItemEnum.values()[sharedPreferences.getInt(PREFERENCE_DEFAULT_BOOT_PAGE, 0)]
    }

    /**
     * Slaat de standaard startpagina op in de shared prefences
     *
     * @param menuItem : de gekozen standaard startpagina als [MenuItemEnum]
     */
    @JvmStatic
    fun setDefaultBootPage(menuItem: MenuItemEnum) {
        //ordinal aangezien we de plaats in de enum willen voor later terug om te zetten naar de enum
        sharedPreferences.edit().putInt(PREFERENCE_DEFAULT_BOOT_PAGE, menuItem.ordinal).apply()
    }

    /**
     * Haalt de standaard lijst design op van de shared preferences
     */
    @JvmStatic
    fun getDefaultListLayout() : ListDesignEnum {
        //default enum 0 -> meetings
        return ListDesignEnum.values()[sharedPreferences.getInt(PREFERENCE_DEFAULT_LIST_LAYOUT, 0)]
    }

    /**
     * Slaat de standaard lijst design op in de shared prefences
     *
     * @param listDesignEnum : de gekozen standaard lijst design als [ListDesignEnum]
     */
    @JvmStatic
    fun setDefaultListLayout(listDesignEnum: ListDesignEnum) {
        //ordinal aangezien we de plaats in de enum willen voor later terug om te zetten naar de enum
        sharedPreferences.edit().putInt(PREFERENCE_DEFAULT_LIST_LAYOUT, listDesignEnum.ordinal).apply()
    }

    /**
     * Verwijderd alle sharedPreferences
     */
    @JvmStatic
    fun deletePreferences() {
        sharedPreferences.edit().clear().apply()
    }

}