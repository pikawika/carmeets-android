package com.lennertbontinck.carmeetsandroidapp.utils

import android.databinding.BindingAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.lennertbontinck.carmeetsandroidapp.constants.BASE_URL_BACKEND_IMAGES
import java.util.*

/**
 * Een util om je te helpen met het correct weergeven van gebinde data
 */
object DataBindingUtil {
    /**
     * Zorgt er voor dat een android;src bij een imageview gevult wordt adhv glide
     */
    @JvmStatic
    @BindingAdapter("android:src")
    fun setImageUrl(view: ImageView, url: String?) {
        if (url != null)
        {
            Glide.with(view.context).load(BASE_URL_BACKEND_IMAGES + url).into(view)
        }
    }

    /**
     * Zorgt er voor dat enkel de dag in de maand als text wordt ingesteld indien datum meegeven als android:dayInMonth
     */
    @JvmStatic
    @BindingAdapter("android:dayInMonth")
    fun setDayInMonth(view: TextView, date: Date?) {
        if (date != null)
        {
            view.text = DateUtil.getDayInMonth(date)
        }
    }

    /**
     * Zorgt er voor dat enkel de eerste drie letters vd maand als text wordt ingesteld indien datum meegeven als android:shortMonthName
     */
    @JvmStatic
    @BindingAdapter("android:shortMonthName")
    fun setShortMonthName(view: TextView, date: Date?) {
        if (date != null)
        {
            view.text = DateUtil.getShortMonthName(date)
        }
    }
}