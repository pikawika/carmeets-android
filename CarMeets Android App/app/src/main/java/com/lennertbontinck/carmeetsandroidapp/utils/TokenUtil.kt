package com.lennertbontinck.carmeetsandroidapp.utils

import android.util.Base64
import com.lennertbontinck.carmeetsandroidapp.models.TokenContent
import com.squareup.moshi.Moshi

/**
 * Een util om je te helpen met het werken met de token
 */
object TokenUtil {
    /**
     * Zorgt er voor dat enkel de dag in de maand als text wordt ingesteld indien datum meegeven als android:dayInMonth
     */
    fun getTokenContent() : TokenContent? {
        return try {
            val split = PreferenceUtil.getToken()!!.split(".")

            val jsonAdapter = Moshi.Builder().build().adapter<TokenContent>(TokenContent::class.java)
            jsonAdapter.fromJson(String(Base64.decode(split[1], Base64.DEFAULT)))
        } catch (e : Throwable) {
            null
        }
    }
}