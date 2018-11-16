package com.lennertbontinck.carmeetsandroidapp.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.lennertbontinck.carmeetsandroidapp.R
import com.lennertbontinck.carmeetsandroidapp.models.Meeting
import com.lennertbontinck.carmeetsandroidapp.utils.DateUtil
import com.lennertbontinck.carmeetsandroidapp.utils.LayoutUtil
import kotlinx.android.synthetic.main.fragment_meetingdetail.view.*

class MeetingDetailFragment : Fragment() {

    private var meeting: Meeting? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        meeting = arguments?.getParcelable(ARG_MEETING_TAG)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val fragment = inflater.inflate(R.layout.fragment_meetingdetail, container, false)

        //set action bar and bottom nav bar
        var parentActivity = (activity as AppCompatActivity)

        //fragment gegevens instellen
        if (meeting != null) {
            LayoutUtil.setActionBar(parentActivity, meeting!!.titel, meeting!!.subtitel)

            Glide.with(parentActivity).load(meeting!!.afbeeldingNaam).into(fragment.image_meetingdetail_header)

            fragment.text_meetingdetail_titel.text = meeting!!.titel
            fragment.text_meetingdetail_subtitel.text = meeting!!.subtitel

            fragment.text_meetingdetail_beschrijving.text = meeting!!.beschrijving

            fragment.text_meetingdetail_dateday.text = DateUtil.getDayInMonth(meeting!!.datum)
            fragment.textView_meetingdetail_datemonth.text = DateUtil.getShortMonthName(meeting!!.datum)

        } else {
            LayoutUtil.setActionBar(parentActivity, "ERROR", "Meeting niet gevonden")
        }

        return fragment
    }

    companion object {
        const val ARG_MEETING_TAG = "meetingItem"
    }
}