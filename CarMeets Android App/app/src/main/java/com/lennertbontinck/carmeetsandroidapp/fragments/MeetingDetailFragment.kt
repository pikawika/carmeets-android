package com.lennertbontinck.carmeetsandroidapp.fragments

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.lennertbontinck.carmeetsandroidapp.R
import com.lennertbontinck.carmeetsandroidapp.constants.IMG_URL_BACKEND
import com.lennertbontinck.carmeetsandroidapp.databinding.FragmentMeetingdetailBinding
import com.lennertbontinck.carmeetsandroidapp.models.Meeting
import com.lennertbontinck.carmeetsandroidapp.utils.DateUtil
import com.lennertbontinck.carmeetsandroidapp.utils.LayoutUtil
import com.lennertbontinck.carmeetsandroidapp.utils.MessageUtil
import com.lennertbontinck.carmeetsandroidapp.viewmodels.MeetingViewModel
import kotlinx.android.synthetic.main.fragment_meetingdetail.view.*

/**
 * Een [Fragment] die de details van een meeting laat zien.
 */
class MeetingDetailFragment : Fragment() {

    /**
     * [LunchViewModel] met de data over account
     */
    //Globaal ter beschikking gesteld aangezien het mogeiljks later nog in andere functie dan onCreateView wenst te worden
    private lateinit var meetingViewModel: MeetingViewModel

    /**
     * De [FragmentProfileBinding] dat we gebruiken voor de effeciteve databinding
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
            MessageUtil.showToast("agenda")
        }

        fragment.button_meetingdetail_route.setOnClickListener {
            MessageUtil.showToast( "route")
        }

        fragment.button_meetingdetail_website.setOnClickListener {
            MessageUtil.showToast("website")
        }
    }
}