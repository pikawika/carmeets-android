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
import com.lennertbontinck.carmeetsandroidapp.activities.MainActivity
import com.lennertbontinck.carmeetsandroidapp.databinding.FragmentMeetingDetailsBinding
import com.lennertbontinck.carmeetsandroidapp.utils.LocationUtil
import com.lennertbontinck.carmeetsandroidapp.utils.MessageUtil
import com.lennertbontinck.carmeetsandroidapp.viewmodels.AccountViewModel
import com.lennertbontinck.carmeetsandroidapp.viewmodels.GuiViewModel
import com.lennertbontinck.carmeetsandroidapp.viewmodels.MeetingViewModel
import kotlinx.android.synthetic.main.fragment_meeting_details.*
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
     * [AccountViewModel] met de data over de aangemelde gebruiker
     */
    private lateinit var accountViewModel: AccountViewModel

    /**
     * De [FragmentMeetingDetailsBinding] dat we gebruiken voor de effeciteve databinding
     */
    private lateinit var binding: FragmentMeetingDetailsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_meeting_details, container, false)

        //viewmodels vullen
        meetingViewModel = ViewModelProviders.of(requireActivity()).get(MeetingViewModel::class.java)
        guiViewModel = ViewModelProviders.of(requireActivity()).get(GuiViewModel::class.java)
        accountViewModel = ViewModelProviders.of(requireActivity()).get(AccountViewModel::class.java)

        val fragment = binding.root
        binding.meetingViewModel = meetingViewModel
        binding.setLifecycleOwner(activity)

        return fragment
    }

    /**
     * Start een intent om het huidige geselecteerde meeting item toe te voegen aan de kalender.
     */
    private fun addToCalander() {
        val calenderIntent = Intent(Intent.ACTION_INSERT).apply {
            data = CalendarContract.Events.CONTENT_URI
            putExtra(CalendarContract.Events.TITLE, meetingViewModel.selectedMeeting.value!!.title)
            putExtra(CalendarContract.Events.DESCRIPTION, meetingViewModel.selectedMeeting.value!!.description)
            putExtra(
                CalendarContract.Events.EVENT_LOCATION,
                LocationUtil.getAddressNotation(meetingViewModel.selectedMeeting.value!!.location)
            )
            putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, meetingViewModel.selectedMeeting.value!!.date.time)
            putExtra(CalendarContract.EXTRA_EVENT_END_TIME, meetingViewModel.selectedMeeting.value!!.date.time)
            putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true)
        }
        //kijk of er agenda app is op de gsm
        if (calenderIntent.resolveActivity(requireActivity().packageManager) != null) {
            startActivity(calenderIntent)
        } else {
            MessageUtil.showToast(getString(R.string.error_no_calander_app))
        }
    }

    /**
     * Start een intent om directies te verkijgen naar de huidige geselecteerde meeting.
     */
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

    /**
     * Start een intent om de website van de huidige geselecteerde meeting te openen.
     */
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
        button_meeting_details_agenda.setOnClickListener {
            addToCalander()
        }

        image_meeting_details_like.setOnClickListener {
            if (!accountViewModel.isLoggedIn.value!!) {
                MessageUtil.showDialogLoginRequired(requireActivity() as MainActivity)
            } else {
                meetingViewModel.toggleLiked()
            }
        }

        image_meeting_details_going.setOnClickListener {
            if (!accountViewModel.isLoggedIn.value!!) {
                MessageUtil.showDialogLoginRequired(requireActivity() as MainActivity)
            } else {
                meetingViewModel.toggleGoing()
            }
        }

        button_meeting_details_route.setOnClickListener {
            getDirections()
        }

        button_meeting_details_website.setOnClickListener {
            goToWebsite()
        }
    }

    /**
     * Functie voor het stoppen van de listeners
     */
    @Suppress("UNUSED_EXPRESSION")
    private fun stopListeners() {
        button_meeting_details_agenda.setOnClickListener { null }

        image_meeting_details_like.setOnClickListener { null }

        image_meeting_details_going.setOnClickListener { null }

        button_meeting_details_route.setOnClickListener { null }

        button_meeting_details_website.setOnClickListener { null }
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