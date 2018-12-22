package com.lennertbontinck.carmeetsandroidapp.utils

import com.lennertbontinck.carmeetsandroidapp.models.Location

/**
 * Een util om je te helpen met het werken met [Location] objecten
 */
object LocationUtil {

    /**
     * Returnt een String met de notatie van een locatie als *postcode, gemeente*
     *
     * @param[location] : het location object waarvan je de city notation wilt
     *
     */
    @JvmStatic
    fun getCityNotation(location: Location): String {
        return (location.postalCode + ", " + location.city)
    }

    /**
     * Returnt een String met de notatie van een locatie als *straat huisnr, postcode gemeente*
     *
     * @param[location] : het location object waarvan je de address notation wilt
     *
     */
    @JvmStatic
    fun getAddressNotation(location: Location): String {
        return (location.streetName + " " + location.houseNumber + ", " +location.postalCode + " " + location.city)
    }
}