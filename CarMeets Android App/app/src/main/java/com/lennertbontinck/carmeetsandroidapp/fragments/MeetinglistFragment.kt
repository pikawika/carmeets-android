package com.lennertbontinck.carmeetsandroidapp.fragments

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lennertbontinck.carmeetsandroidapp.R
import com.lennertbontinck.carmeetsandroidapp.activities.MainActivity
import com.lennertbontinck.carmeetsandroidapp.adapters.MeetingAdapter
import com.lennertbontinck.carmeetsandroidapp.enums.MenuItemEnum
import com.lennertbontinck.carmeetsandroidapp.viewmodels.GuiViewModel
import com.lennertbontinck.carmeetsandroidapp.viewmodels.MeetingViewModel
import kotlinx.android.synthetic.main.fragment_meetinglist.*
import kotlinx.android.synthetic.main.fragment_meetinglist.view.*

/**
 * Een [Fragment] die alle gelikete en going meetings van een gebruiker laat zien.
 * Hiervoor moet de gebruiker uiteraard een account hebben en ingelogd zijn.
 */
class MeetinglistFragment : Fragment() {

    /**
     * [MeetingViewModel] met de data van alle meetings
     */
    private lateinit var meetingViewModel: MeetingViewModel

    /**
     * [GuiViewModel] met de data over de GUI instellingen
     */
    private lateinit var guiViewModel: GuiViewModel

    /**
     * [MeetingAdapter] voor het vullen van de meeting lijst
     */
    private lateinit var meetingAdapter: MeetingAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val fragment = inflater.inflate(R.layout.fragment_meetinglist, container, false)

        //viewmodel vullen
        meetingViewModel = ViewModelProviders.of(requireActivity()).get(MeetingViewModel::class.java)
        guiViewModel = ViewModelProviders.of(requireActivity()).get(GuiViewModel::class.java)

        //Bepalen of er al dan niet een detailcontainer is
        //->indien deze er is weet men dat het over een tablet (twoPane) gaat
        //->initieel vullen met ene placeholder logofragment om geen blake pagina te hebbenæ
        if (fragment.frame_meetinglist_meetingdetailcontainer != null) {
            guiViewModel.isTwoPaneEnvironment.value = true
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame_meetinglist_meetingdetailcontainer, LogoFragment())
                .commit()
        }

        //adapter aanmaken
        meetingAdapter = MeetingAdapter(requireActivity() as MainActivity)

        //recyclerview vullen door adapter toe te kennen
        fragment.recyclerview_meetinglist.adapter = meetingAdapter

        return fragment
    }

    /**
     * Functie voor het instantiëren van de listeners.
     */
    private fun initListeners() {
        //indien de meetinglijst veranderd moet de adapter opnieuw zijn cards genereren met nieuwe data
        meetingViewModel.meetingList.observe(this, Observer {
            meetingAdapter.notifyDataSetChanged()
        })

        //indien lijstDesign veranderd moet de adapter opnieuw zijn cards genereren met nieuwe stijl
        //hier kan je momenteel enkel adapter opnieuw toekennen mits notifyDataSetChanged etc niet
        //opnieuw inflate methode aanroept waar je itemstijl meegeeft
        guiViewModel.listDesign.observe(this, Observer {
            recyclerview_meetinglist.adapter = meetingAdapter
        })
    }

    /**
     * Functie voor het stoppen van de listeners
     */
    @Suppress("UNUSED_EXPRESSION")
    private fun stopListeners() {
        meetingViewModel.meetingList.removeObservers(requireActivity())
        guiViewModel.listDesign.removeObservers(requireActivity())
    }

    override fun onStart() {
        super.onStart()
        initListeners()
        guiViewModel.actionBarTitle.value = getString(R.string.ab_meetings_title)
        guiViewModel.actionBarSubTitle.value = getString(R.string.ab_meetings_subtitle)
        guiViewModel.activeMenuItem.value = MenuItemEnum.MEETINGS
        guiViewModel.isListDesignOptionsVisible.value = true
    }

    override fun onStop() {
        super.onStop()
        stopListeners()
        guiViewModel.resetLayout()
    }
}