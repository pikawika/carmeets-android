package com.lennertbontinck.carmeetsandroidapp.utils

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.databinding.BindingAdapter
import android.support.v4.content.ContextCompat
import android.support.v4.widget.ImageViewCompat
import android.support.v7.widget.AppCompatImageView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.lennertbontinck.carmeetsandroidapp.R
import com.lennertbontinck.carmeetsandroidapp.constants.BASE_URL_BACKEND_IMAGES
import com.lennertbontinck.carmeetsandroidapp.context.CarMeetsApplication
import java.util.*

/**
 * Een util om je te helpen met het correct weergeven van gebinde data.
 */
object DataBindingUtil {
    /**
     * Zorgt er voor dat een android;src bij een imageview gevult wordt adhv glide indien string meegegeven.
     *
     * Indien string loading_animation_carmeets_3e157a5f-56dc-4017-85ce-ee679d3e0967 is zal de gif voor loading ingesteld worden
     * Dit is een random GUID dus de kans dat dit overeenkomt met een afbeeldingsurl is zo goed als onbestaande.
     *
     * @param view : [ImageView] die van src voorzien moet worden. Required of type [ImageView].
     *
     * @param imageName : de naam van de afbeelding de op de backend staat. Required of type [String].
     */
    @JvmStatic
    @BindingAdapter("android:src")
    fun setImageUrlString(view: ImageView, imageName: String) {
        when {
            imageName != "loading_animation_carmeets_3e157a5f-56dc-4017-85ce-ee679d3e0967" -> Glide.with(view.context).load(
                BASE_URL_BACKEND_IMAGES + imageName
            ).apply(RequestOptions().placeholder(R.drawable.img_logo_16by9)).into(view)
            imageName == "loading_animation_carmeets_3e157a5f-56dc-4017-85ce-ee679d3e0967" -> Glide.with(view.context).load(
                R.drawable.gif_loading
            ).apply(RequestOptions().placeholder(R.drawable.img_logo_16by9)).into(view)
        }
    }

    /**
     * Zorgt er voor dat enkel de dag in de maand als text wordt ingesteld indien datum meegeven als android:dayInMonth.
     *
     * @param view : [TextView] die van text voorzien moet worden. Required of type [TextView].
     *
     * @param date : datum waarvan je de dag in de maand wilt. Required of type [Date].
     */
    @JvmStatic
    @BindingAdapter("android:dayInMonth")
    fun setDayInMonth(view: TextView, date: Date) {
        view.text = DateUtil.getDayInMonth(date)
    }

    /**
     * Zorgt er voor dat enkel de eerste drie letters vd maand als text wordt ingesteld indien datum meegeven als android:shortMonthName.
     *
     * @param view : [TextView] die van text voorzien moet worden. Required of type [TextView].
     *
     * @param date : datum waarvan je de eerste drie letters van de maand wilt. Required of type [Date].
     */
    @JvmStatic
    @BindingAdapter("android:shortMonthName")
    fun setShortMonthName(view: TextView, date: Date) {
        view.text = DateUtil.getShortMonthName(date)
    }


    /**
     * Zorgt er voor dat je gewoon boolean bind kan meegeven aan is visible.
     *
     * @param view : [View] die al dan niet visible moet zijn. Required of type [View].
     *
     * @param isVisible : Boolean, indien true -> [View.VISIBLE] false -> [View.GONE] . Required of type [Boolean].
     */
    @JvmStatic
    @BindingAdapter("android:visibility")
    fun setVisibility(view: View, isVisible: Boolean) {
        view.visibility = if (isVisible) View.VISIBLE else View.GONE
    }

    /**
     * Zorgt er voor dat je gewoon boolean bind kan meegeven en aan de hand daarvan wordt toggled juiste kleur.
     *
     * @param view : [AppCompatImageView] die al dan niet zwarte of roze tint moet hebben. Required of type [AppCompatImageView].
     *
     * @param isToggledOn : of tint van de [AppCompatImageView] al dan niet actief moet zijn. True -> colorPrimary, false -> black. Required of type [Boolean].
     */
    @JvmStatic
    @BindingAdapter("android:isToggledOn")
    fun setIsToggledOn(view: AppCompatImageView, isToggledOn: Boolean) {
        if (isToggledOn) {
            ImageViewCompat.setImageTintList(
                view, ColorStateList.valueOf(
                    ContextCompat.getColor(CarMeetsApplication.getContext(), R.color.colorPrimary)
                )
            )

        } else {
            ImageViewCompat.setImageTintList(
                view, ColorStateList.valueOf(
                    ContextCompat.getColor(CarMeetsApplication.getContext(), R.color.black)
                )
            )
        }

    }

    /**
     * Zorgt ervoor dat de lijst van categorieën mooi wordt meegegeven.
     *
     * @param view : [TextView] die text moet hebben met de verschillende categorieën. Required of type [TextView].
     *
     * @param categories : lijst van categorieën ([String] objecten). Required of type [List<String>].
     */
    @JvmStatic
    @BindingAdapter("android:categories")
    fun setCategories(view: TextView, categories: List<String>) {
        var categoriesSting = ""
        if (categories.isNotEmpty()) {
            categoriesSting = CarMeetsApplication.getContext().getString(R.string.txt_meeting_categories) + ": "

            categories.forEach { categoriesSting += "$it | " }

            categoriesSting = categoriesSting.removeRange(categoriesSting.length - 3, categoriesSting.length - 1)
        }
        view.text = categoriesSting
    }

    /**
     * Zorgt ervoor dat het aantal mensen dat gaat mooi wordt meegegeven.
     *
     * @param view : [TextView] die text moet hebben met hoeveel mensen gaan. Required of type [TextView].
     *
     * @param amountGoing : lijst van userId die gaan ([String] objecten). Required of type [List<String>].
     */
    //string value niet nodig aangezien er geen te vertalen data in zit
    @SuppressLint("SetTextI18n")
    @JvmStatic
    @BindingAdapter("android:amountGoing")
    fun setAmountGoing(view: TextView, amountGoing: List<String>) {
        view.text = CarMeetsApplication.getContext().getString(R.string.txt_meeting_amount_going) + ": " +
                amountGoing.count().toString()
    }

    /**
     * Zorgt ervoor dat het aantal mensen dat de meeting liked mooi wordt meegegeven.
     *
     * @param view : [TextView] die text moet hebben met hoeveel mensen geliked hebben. Required of type [TextView].
     *
     * @param amountLiked : lijst van userId die geliked hebben ([String] objecten). Required of type [List<String>].
     */
    //string value niet nodig aangezien er geen te vertalen data in zit
    @SuppressLint("SetTextI18n")
    @JvmStatic
    @BindingAdapter("android:amountLiked")
    fun setAmountliked(view: TextView, amountLiked: List<String>) {
        view.text = CarMeetsApplication.getContext().getString(R.string.txt_meeting_amount_liked) + ": " +
                amountLiked.count().toString()
    }


}