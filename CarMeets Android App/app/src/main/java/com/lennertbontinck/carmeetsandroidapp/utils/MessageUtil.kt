package com.lennertbontinck.carmeetsandroidapp.utils

import android.content.Context
import android.widget.Toast

/**
 * Een util om je te helpen met het weergeven van *berichten* aan de gebruiker.
 */
object MessageUtil {
    /**
     * Toont een toast op het scherm.
     *
     * @param[context] De context waarin de toast moet weergegeven worden. Required of type Context
     *
     * @param[bericht] Het bericht dat weergegeven moet worden. Required of type String
     *
     * @param[tijd] Hoe lang de toast op het scherm moet blijven. Optional of type Int (Toast Length), default Toast.LENGTH_LONG.
     *
     */
    @JvmStatic
    fun showToast(context: Context, bericht: String, tijd: Int = Toast.LENGTH_LONG) {
        Toast.makeText(context, bericht, tijd).show()
    }
}