package com.lennertbontinck.carmeetsandroidapp.utils

import android.app.Activity
import android.app.AlertDialog
import android.widget.Toast
import com.lennertbontinck.carmeetsandroidapp.R
import com.lennertbontinck.carmeetsandroidapp.activities.MainActivity
import com.lennertbontinck.carmeetsandroidapp.context.CarMeetsApplication
import com.lennertbontinck.carmeetsandroidapp.fragments.AccountFragment

/**
 * Een util om je te helpen met het weergeven van *berichten* aan de gebruiker.
 */
object MessageUtil {
    /**
     * Toont een toast op het scherm. Context is voorzien door de [MainActivity]
     *
     * @param[message] Het message dat weergegeven moet worden. Required of type [String].
     *
     * @param[time] Hoe lang de toast op het scherm moet blijven. Optional of type Int (Toast Length), default Toast.LENGTH_LONG.
     *
     */
    @JvmStatic
    fun showToast(message: String, time: Int = Toast.LENGTH_LONG) {
        Toast.makeText(CarMeetsApplication.getContext(), message, time).show()
    }

    /**
     * Toont een dialoog popup met ja nee knoppen en voert de meegegeven parameterloze functie uit.
     *
     * @param parentActivity : activity van de huidige omgeving. Required of type [Activity].
     *
     * @param title : de gewenste titel van de popup. Required of type [String].
     *
     * @param message : de gewenste omschrijving in de popup. Required of type [String].
     *
     * @param func : een funtie dat moet uitgevoerd worden, parameterloos. Required of type [Unit].
     */
    @JvmStatic
    fun showDialogYesNo(parentActivity: Activity, title: String, message: String, func: () -> Unit) {
        val builder = AlertDialog.Builder(parentActivity)
        builder.setCancelable(true)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setPositiveButton(
            parentActivity.getString(R.string.txt_yes)
        ) { _, _ ->
            func()
        }
        builder.setNegativeButton(
            parentActivity.getString(R.string.txt_no)
        ) { dialog, _ -> dialog.cancel() }

        val dialog = builder.create()
        dialog.show()
    }

    /**
     * Toont een dialoog die zegt dat een account nodig is voor deze functie met optie om naar account te gaan.
     *
     * @param parentActivity : activity van de huidige omgeving. Required of type [MainActivity].
     */
    @JvmStatic
    fun showDialogLoginRequired(parentActivity: MainActivity) {
        val builder = AlertDialog.Builder(parentActivity)
        builder.setCancelable(true)
        builder.setTitle(parentActivity.getString(R.string.txt_login_required))
        builder.setMessage(parentActivity.getString(R.string.txt_login_required_for_this_function))
        builder.setPositiveButton(
            CarMeetsApplication.getContext().getString(R.string.txt_login)
        ) { _, _ ->
            parentActivity.supportFragmentManager.beginTransaction()
                .replace(R.id.frame_main_fragmentcontainer, AccountFragment())
                .addToBackStack(parentActivity.getString(R.string.fragtag_account))
                .commit()
        }
        builder.setNegativeButton(
            parentActivity.getString(R.string.txt_cancel)
        ) { dialog, _ -> dialog.cancel() }

        val dialog = builder.create()
        dialog.show()
    }
}