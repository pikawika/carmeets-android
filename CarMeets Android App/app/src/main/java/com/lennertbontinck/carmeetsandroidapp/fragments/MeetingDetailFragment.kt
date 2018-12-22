package com.lennertbontinck.carmeetsandroidapp.fragments

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.net.Uri
import android.os.Bundle
import android.provider.CalendarContract
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lennertbontinck.carmeetsandroidapp.R
import com.lennertbontinck.carmeetsandroidapp.databinding.FragmentMeetingdetailBinding
import com.lennertbontinck.carmeetsandroidapp.utils.LayoutUtil
import com.lennertbontinck.carmeetsandroidapp.utils.LocationUtil
import com.lennertbontinck.carmeetsandroidapp.utils.MessageUtil
import com.lennertbontinck.carmeetsandroidapp.viewmodels.MeetingViewModel
import kotlinx.android.synthetic.main.fragment_meetingdetail.view.*
import java.net.URLEncoder

/**
 * Een [Fragment] die de details van een meeting laat zien.
 */
class MeetingDetailFragment : Fragment() {

    /**
     * [MeetingViewModel] met de data over de meetings
     */
    //Globaal ter beschikking gesteld aangezien het mogeiljks later nog in andere functie dan onCreateView wenst te worden
    private lateinit var meetingViewModel: MeetingViewModel

    /**
     * De [FragmentMeetingdetailBinding] dat we gebruiken voor de effeciteve databinding
     */
    private lateinit var binding: FragmentMeetingdetailBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_meetingdetail, container, false)

        //viewmodel vullen
        meetingViewModel = ViewModelProviders.of(activity!!).get(MeetingViewModel::class.java)

        val fragment = binding.root
        binding.meetingViewModel = meetingViewModel
        binding.setLifecycleOwner(activity)

        //Action bar en bottombar
        val parentActivity = (activity as AppCompatActivity)


        //shared layout instellen -> indien tablet moet er niets veranderd
        //default false dus kan niet null zijn
        if (!meetingViewModel.getIsTwoPane().value!!)
            LayoutUtil.clearActionBarOptions(parentActivity)

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
            MessageUtil.showToast("notificatie")
        }

        fragment.button_meetingdetail_agenda.setOnClickListener {
            val calanderIntent = Intent(Intent.ACTION_INSERT).apply {
                data = CalendarContract.Events.CONTENT_URI
                putExtra(CalendarContract.Events.TITLE, meetingViewModel.getSelectedMeeting().value!!.title)
                putExtra(CalendarContract.Events.DESCRIPTION, meetingViewModel.getSelectedMeeting().value!!.description)
                putExtra(
                    CalendarContract.Events.EVENT_LOCATION,
                    LocationUtil.getAddressNotation(meetingViewModel.getSelectedMeeting().value!!.location)
                )
                putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, meetingViewModel.getSelectedMeeting().value!!.date)
                putExtra(CalendarContract.EXTRA_EVENT_END_TIME, meetingViewModel.getSelectedMeeting().value!!.date)
                putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true)
            }
            //kijk of er gps app is op de gsm
            if (calanderIntent.resolveActivity(requireActivity().packageManager) != null) {
                startActivity(calanderIntent)
            } else {
                MessageUtil.showToast(getString(R.string.error_no_calander_app))
            }
        }

        fragment.button_meetingdetail_route.setOnClickListener {
            val mapIntent = Intent(Intent.ACTION_VIEW).apply {
                //geen long en lat dus 0,0 maar wel adres
                //adres moet omgezet worden naar een url string dus encode (spatie en andere speciale tekens encoden)
                data = Uri.parse(
                    "geo:0,0?q=" + URLEncoder.encode(
                        LocationUtil.getAddressNotation(meetingViewModel.getSelectedMeeting().value!!.location),
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

        fragment.button_meetingdetail_website.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse(meetingViewModel.getSelectedMeeting().value!!.website)
            }
            //kijk of er browser app is op de gsm
            if (browserIntent.resolveActivity(requireActivity().packageManager) != null) {
                startActivity(browserIntent)
            } else {
                MessageUtil.showToast(getString(R.string.error_no_browser_app))
            }
        }
    }
}