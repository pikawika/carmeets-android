package com.lennertbontinck.carmeetsandroidapp.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.lennertbontinck.carmeetsandroidapp.R
import com.lennertbontinck.carmeetsandroidapp.constants.IMG_URL_BACKEND
import com.lennertbontinck.carmeetsandroidapp.models.Meeting
import com.lennertbontinck.carmeetsandroidapp.utils.DateUtil
import com.lennertbontinck.carmeetsandroidapp.utils.LayoutUtil
import com.lennertbontinck.carmeetsandroidapp.utils.MessageUtil
import kotlinx.android.synthetic.main.fragment_meetingdetail.view.*

/**
 * Een [Fragment] die de details van een meeting laat zien.
 *
 * Gebruik *MeetingDetailFragment.newInstance* om een parcable *ARG_MEETING_TAG* mee te geven (welke meeting het is) en isTablet boolean.
 */
class MeetingDetailFragment : Fragment() {

    /**
     * De [Meeting] die in deze detail pagina weergegeven wordt
     */
    //globaal mits in functions button onCreateView mogelijks willen te gebruiken
    private var meeting: Meeting? = null

    /**
     * [Boolean] of het huidige device al dan niet een tablet is/ of al dan niet twopane design gebruikt moet worden.
     * Default is dit false
     */
    //Globaal ter beschikking gesteld aangezien het mogeiljks later nog in andere functie dan onCreateView wenst te worden
    private var isTablet: Boolean? = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val fragment = inflater.inflate(R.layout.fragment_meetingdetail, container, false)

        //meeting en istablet uit companion halen halen
        meeting = arguments?.getParcelable(ARG_MEETING_TAG)
        isTablet = arguments?.getBoolean(IS_TABLET)

        //Action bar en bottombar
        val parentActivity = (activity as AppCompatActivity)


        //shared layout instellen -> indien tablet moet er niets veranderd
        //default false dus kan niet null zijn
        if (!isTablet!!)
            LayoutUtil.clearActionBarOptions(parentActivity)

        //fragment gegevens instellen indien niet null, anders error tonen
        if (meeting != null) {
            //shared layout instellen
            LayoutUtil.setActionBar(parentActivity, meeting!!.title, meeting!!.subtitle)

            Glide.with(parentActivity).load(IMG_URL_BACKEND + meeting!!.afbeeldingNaam)
                .into(fragment.image_meetingdetail_header)

            fragment.text_meetingdetail_title.text = meeting!!.title
            fragment.text_meetingdetail_subtitle.text = meeting!!.subtitle

            fragment.text_meetingdetail_description.text = meeting!!.description

            fragment.text_meetingdetail_dateday.text = DateUtil.getDayInMonth(meeting!!.date)
            fragment.textView_meetingdetail_datemonth.text = DateUtil.getShortMonthName(meeting!!.date)

        } else {
            //shared layout instellen
            LayoutUtil.setActionBar(parentActivity, "ERROR", "Meeting niet gevonden")
        }

        //listeners instellen voor de knoppen etc
        configureButtons(fragment)

        return fragment
    }

    /**
     * Stelt de knoppen onderaan de meeting detail pagina in.
     *
     * Toont enkel de knoppen die van toepassing zijn (velden die meegegeven zijn met meeting)
     *
     * Voorziet listeners voor onlick van de knoppen te verwerken.
     */
    private fun configureButtons(fragment: View) {
        fragment.button_meetingdetail_notification.setOnClickListener {
            MessageUtil.showToast(requireContext(), "notificatie")
        }

        fragment.button_meetingdetail_agenda.setOnClickListener {
            MessageUtil.showToast(requireContext(), "agenda")
        }

        fragment.button_meetingdetail_route.setOnClickListener {
            MessageUtil.showToast(requireContext(), "route")
        }

        fragment.button_meetingdetail_website.setOnClickListener {
            MessageUtil.showToast(requireContext(), "website")
        }
    }

    companion object {
        const val ARG_MEETING_TAG = "meetingItem"
        const val IS_TABLET = "isTablet"
    }
}