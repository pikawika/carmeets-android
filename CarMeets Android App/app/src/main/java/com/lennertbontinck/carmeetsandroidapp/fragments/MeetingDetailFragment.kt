package com.lennertbontinck.carmeetsandroidapp.fragments

import android.os.Bundle
import android.support.constraint.ConstraintLayout
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
import kotlinx.android.synthetic.main.fragment_meetingdetail.*
import kotlinx.android.synthetic.main.fragment_meetingdetail.view.*

/**
 * Een [Fragment] die de details van een meeting laat zien.
 *
 * Gebruik [MeetingDetailFragment.newInstance] om een parcable [ARG_MEETING_TAG] mee te geven (welke meeting het is).
 */
class MeetingDetailFragment : Fragment() {

    /**
     * De [Meeting] die in deze detail pagina weergegeven wordt
     */
    //globaal mits in functions button onCreateView mogelijks willen te gebruiken
    private var meeting: Meeting? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val fragment = inflater.inflate(R.layout.fragment_meetingdetail, container, false)

        //meeting uit companion halen halen
        meeting = arguments?.getParcelable(ARG_MEETING_TAG)

        //Action bar en bottombar
        var parentActivity = (activity as AppCompatActivity)

        //shared layout instellen
        LayoutUtil.clearActionBarOptions(parentActivity)

        //fragment gegevens instellen indien niet null, anders error tonen
        if (meeting != null) {
            //shared layout instellen
            LayoutUtil.setActionBar(parentActivity, meeting!!.titel, meeting!!.subtitel)

            Glide.with(parentActivity).load(IMG_URL_BACKEND + meeting!!.afbeeldingNaam).into(fragment.image_meetingdetail_header)

            fragment.text_meetingdetail_titel.text = meeting!!.titel
            fragment.text_meetingdetail_subtitel.text = meeting!!.subtitel

            fragment.text_meetingdetail_beschrijving.text = meeting!!.beschrijving

            fragment.text_meetingdetail_dateday.text = DateUtil.getDayInMonth(meeting!!.datum)
            fragment.textView_meetingdetail_datemonth.text = DateUtil.getShortMonthName(meeting!!.datum)

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
    fun configureButtons(fragment: View) {
        fragment.button_meetingdetail_notificatie.setOnClickListener {
            MessageUtil.toonToast(requireContext(), "notificatie")
        }

        fragment.button_meetingdetail_agenda.setOnClickListener {
            MessageUtil.toonToast(requireContext(), "agenda")
        }

        fragment.button_meetingdetail_route.setOnClickListener {
            MessageUtil.toonToast(requireContext(), "route")
        }

        fragment.button_meetingdetail_website.setOnClickListener {
            MessageUtil.toonToast(requireContext(), "website")
        }
    }

    companion object {
        const val ARG_MEETING_TAG = "meetingItem"
    }
}