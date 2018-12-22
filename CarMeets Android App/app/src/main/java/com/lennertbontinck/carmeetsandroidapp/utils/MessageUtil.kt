package com.lennertbontinck.carmeetsandroidapp.utils

import android.widget.Toast
import com.lennertbontinck.carmeetsandroidapp.activities.MainActivity
import com.lennertbontinck.carmeetsandroidapp.context.CarMeetsApplication

/**
 * Een util om je te helpen met het weergeven van *berichten* aan de gebruiker.
 */
object MessageUtil {
    /**
     * Toont een toast op het scherm. Context is voorzien door de [MainActivity]
     *
     * @param[bericht] Het bericht dat weergegeven moet worden. Required of type String
     *
     * @param[tijd] Hoe lang de toast op het scherm moet blijven. Optional of type Int (Toast Length), default Toast.LENGTH_LONG.
     *
     */
    @JvmStatic
    fun showToast(bericht: String, tijd: Int = Toast.LENGTH_LONG) {
        Toast.makeText(CarMeetsApplication.getContext(), bericht, tijd).show()
    }
}