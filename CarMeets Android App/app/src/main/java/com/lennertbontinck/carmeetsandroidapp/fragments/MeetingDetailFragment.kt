package com.lennertbontinck.carmeetsandroidapp.fragments

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.net.Uri
import android.os.Bundle
import android.provider.CalendarContract
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lennertbontinck.carmeetsandroidapp.R
import com.lennertbontinck.carmeetsandroidapp.databinding.FragmentMeetingdetailBinding
import com.lennertbontinck.carmeetsandroidapp.utils.LocationUtil
import com.lennertbontinck.carmeetsandroidapp.utils.MessageUtil
import com.lennertbontinck.carmeetsandroidapp.viewmodels.GuiViewModel
import com.lennertbontinck.carmeetsandroidapp.viewmodels.MeetingViewModel
import kotlinx.android.synthetic.main.fragment_meetingdetail.*
import java.net.URLEncoder


/**
 * Een [Fragment] die de details van een meeting laat zien.
 */
class MeetingDetailFragment : Fragment() {

    /**
     * [MeetingViewModel] met de data van alle meetings
     */
    private lateinit var meetingViewModel: MeetingViewModel

    /**
     * [GuiViewModel] met de data over de GUI instellingen
     */
    private lateinit var guiViewModel: GuiViewModel

    /**
     * De [FragmentMeetingdetailBinding] dat we gebruiken voor de effeciteve databinding
     */
    private lateinit var binding: FragmentMeetingdetailBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_meetingdetail, container, false)

        //viewmodels vullen
        meetingViewModel = ViewModelProviders.of(requireActivity()).get(MeetingViewModel::class.java)
        guiViewModel = ViewModelProviders.of(requireActivity()).get(GuiViewModel::class.java)

        val fragment = binding.root
        binding.meetingViewModel = meetingViewModel
        binding.setLifecycleOwner(activity)

        return fragment
    }

    private fun addToCalander() {
        val calenderIntent = Intent(Intent.ACTION_INSERT).apply {
            data = CalendarContract.Events.CONTENT_URI
            putExtra(CalendarContract.Events.TITLE, meetingViewModel.selectedMeeting.value!!.title)
            putExtra(CalendarContract.Events.DESCRIPTION, meetingViewModel.selectedMeeting.value!!.description)
            putExtra(
                CalendarContract.Events.EVENT_LOCATION,
                LocationUtil.getAddressNotation(meetingViewModel.selectedMeeting.value!!.location)
            )
            putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, meetingViewModel.selectedMeeting.value!!.date)
            putExtra(CalendarContract.EXTRA_EVENT_END_TIME, meetingViewModel.selectedMeeting.value!!.date)
            putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true)
        }
        //kijk of er agenda app is op de gsm
        if (calenderIntent.resolveActivity(requireActivity().packageManager) != null) {
            startActivity(calenderIntent)
        } else {
            MessageUtil.showToast(getString(R.string.error_no_calander_app))
        }
    }

    private fun getDirections() {
        val mapIntent = Intent(Intent.ACTION_VIEW).apply {
            //geen long en lat dus 0,0 maar wel adres
            //adres moet omgezet worden naar een url string dus encode (spatie en andere speciale tekens encoden)
            data = Uri.parse(
                "geo:0,0?q=" + URLEncoder.encode(
                    LocationUtil.getAddressNotation(meetingViewModel.selectedMeeting.value!!.location),
                    "UTF-8"
                )

            )
        }
        //kijk of er gps app is op de gsm
        if (mapIntent.resolveActivity(requireActivity().packageManager) != null) {
            startActivity(mapIntent)
        } else {
            MessageUtil.showToast(getString(R.string.error_no_navigation_app))
        }
    }

    private fun goToWebsite() {
        val browserIntent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse(meetingViewModel.selectedMeeting.value!!.website)
        }
        //kijk of er browser app is op de gsm
        if (browserIntent.resolveActivity(requireActivity().packageManager) != null) {
            startActivity(browserIntent)
        } else {
            MessageUtil.showToast(getString(R.string.error_no_browser_app))
        }
    }

    /**
     * Functie voor het instantiëren van de listeners.
     */
    private fun initListeners() {
        button_meetingdetail_agenda.setOnClickListener {
            addToCalander()
        }

        button_meetingdetail_route.setOnClickListener {
            getDirections()
        }

        button_meetingdetail_website.setOnClickListener {
            goToWebsite()
        }
    }

    /**
     * Functie voor het stoppen van de listeners
     */
    @Suppress("UNUSED_EXPRESSION")
    private fun stopListeners() {
        button_meetingdetail_agenda.setOnClickListener { null }

        button_meetingdetail_route.setOnClickListener { null }

        button_meetingdetail_website.setOnClickListener { null }
    }

    override fun onStart() {
        super.onStart()
        initListeners()
        guiViewModel.actionBarTitle.value = getString(R.string.txt_meeting)
        guiViewModel.actionBarSubTitle.value = meetingViewModel.selectedMeeting.value!!.title
        if (!guiViewModel.isTwoPaneEnvironment.value!!)
            guiViewModel.isBackButtonVisible.value = true
    }

    override fun onStop() {
        super.onStop()
        stopListeners()
        guiViewModel.resetLayout()
    }
}