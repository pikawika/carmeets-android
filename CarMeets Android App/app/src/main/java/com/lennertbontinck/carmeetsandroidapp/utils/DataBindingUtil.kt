package com.lennertbontinck.carmeetsandroidapp.utils

import android.content.res.ColorStateList
import android.databinding.BindingAdapter
import android.support.v4.content.ContextCompat
import android.support.v4.widget.ImageViewCompat
import android.support.v7.widget.AppCompatImageView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.lennertbontinck.carmeetsandroidapp.R
import com.lennertbontinck.carmeetsandroidapp.constants.BASE_URL_BACKEND_IMAGES
import com.lennertbontinck.carmeetsandroidapp.context.CarMeetsApplication
import java.util.*

/**
 * Een util om je te helpen met het correct weergeven van gebinde data
 */
object DataBindingUtil {
    /**
     * Zorgt er voor dat een android;src bij een imageview gevult wordt adhv glide indien string meegegeven
     *
     * Indien string loading_animation_carmeets_3e157a5f-56dc-4017-85ce-ee679d3e0967 is zal de gif voor loading ingesteld worden
     * Dit is een random GUID dus de kans dat dit overeenkomt met een afbeeldingsurl is zo goed als onbestaande.
     */
    @JvmStatic
    @BindingAdapter("android:src")
    fun setImageUrlString(view: ImageView, url: String?) {
        when {
            url != null && url != "loading_animation_carmeets_3e157a5f-56dc-4017-85ce-ee679d3e0967" -> Glide.with(view.context).load(BASE_URL_BACKEND_IMAGES + url).into(view)
            url == "loading_animation_carmeets_3e157a5f-56dc-4017-85ce-ee679d3e0967" -> Glide.with(view.context).load(R.drawable.loading).into(view)
        }
    }

    /**
     * Zorgt er voor dat enkel de dag in de maand als text wordt ingesteld indien datum meegeven als android:dayInMonth
     */
    @JvmStatic
    @BindingAdapter("android:dayInMonth")
    fun setDayInMonth(view: TextView, date: Date?) {
        if (date != null) {
            view.text = DateUtil.getDayInMonth(date)
        }
    }

    /**
     * Zorgt er voor dat enkel de eerste drie letters vd maand als text wordt ingesteld indien datum meegeven als android:shortMonthName
     */
    @JvmStatic
    @BindingAdapter("android:shortMonthName")
    fun setShortMonthName(view: TextView, date: Date?) {
        if (date != null) {
            view.text = DateUtil.getShortMonthName(date)
        }
    }


    /**
     * Zorgt er voor dat je gewoon boolean bind kan meegeven aan is visible
     */
    @JvmStatic
    @BindingAdapter("android:visibility")
    fun setVisibility(view: View, isVisible: Boolean) {
        view.visibility = if (isVisible) View.VISIBLE else View.GONE
    }

    /**
     * Zorgt er voor dat je gewoon boolean bind kan meegeven en aan de hand daarvan wordt toggled juiste kleur
     */
    @JvmStatic
    @BindingAdapter("android:isToggledOn")
    fun setIsToggledOn(view: AppCompatImageView, isToggledOn: Boolean) {
        if (isToggledOn){
            ImageViewCompat.setImageTintList(view, ColorStateList.valueOf(
                ContextCompat.getColor(CarMeetsApplication.getContext(), R.color.colorPrimary)))

        } else {
            ImageViewCompat.setImageTintList(view, ColorStateList.valueOf(
                ContextCompat.getColor(CarMeetsApplication.getContext(), R.color.black)))
        }

    }
}