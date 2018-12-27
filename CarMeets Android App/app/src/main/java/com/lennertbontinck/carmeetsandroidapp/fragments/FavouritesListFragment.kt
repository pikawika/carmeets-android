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
import com.lennertbontinck.carmeetsandroidapp.adapters.FavouritesAdapter
import com.lennertbontinck.carmeetsandroidapp.constants.FRAGTAG_LOGO
import com.lennertbontinck.carmeetsandroidapp.enums.MenuItemEnum
import com.lennertbontinck.carmeetsandroidapp.utils.MessageUtil
import com.lennertbontinck.carmeetsandroidapp.viewmodels.AccountViewModel
import com.lennertbontinck.carmeetsandroidapp.viewmodels.GuiViewModel
import com.lennertbontinck.carmeetsandroidapp.viewmodels.MeetingViewModel
import kotlinx.android.synthetic.main.fragment_meeting_list.*
import kotlinx.android.synthetic.main.fragment_meeting_list.view.*

/**
 * Een [Fragment] die alle gelikete en going meetings van een gebruiker laat zien.
 * Hiervoor moet de gebruiker uiteraard een account hebben en ingelogd zijn.
 */
class FavouritesListFragment : Fragment() {

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
     * [FavouritesAdapter] voor het vullen van de favorieten lijst
     */
    private lateinit var favouritesAdapter: FavouritesAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val fragment = inflater.inflate(R.layout.fragment_meeting_list, container, false)

        //viewmodel vullen
        meetingViewModel = ViewModelProviders.of(requireActivity()).get(MeetingViewModel::class.java)
        guiViewModel = ViewModelProviders.of(requireActivity()).get(GuiViewModel::class.java)
        accountViewModel = ViewModelProviders.of(requireActivity()).get(AccountViewModel::class.java)

        //Bepalen of er al dan niet een detailcontainer is
        //->indien deze er is weet men dat het over een tablet (twoPane) gaat
        //->initieel vullen met ene placeholder logofragment om geen blake pagina te hebbenæ
        if (fragment.frame_meeting_list_meeting_detail_container != null) {
            guiViewModel.isTwoPaneEnvironment.value = true
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame_meeting_list_meeting_detail_container, LogoFragment())
                .addToBackStack(FRAGTAG_LOGO)
                .commit()
        } else {
            guiViewModel.isTwoPaneEnvironment.value = false
        }

        //adapter aanmaken
        favouritesAdapter = FavouritesAdapter(requireActivity() as MainActivity)

        //recyclerview vullen door adapter toe te kennen
        fragment.recycler_meeting_list.adapter = favouritesAdapter

        return fragment
    }

    /**
     * Functie voor het instantiëren van de listeners.
     */
    private fun initListeners() {
        //indien de meetinglijst veranderd moet de adapter opnieuw zijn cards genereren met nieuwe data
        //swipe to refresh mag ook gestopt worden aangezien er een nieuwe lijst is geladen
        meetingViewModel.meetingList.observe(this, Observer {
            favouritesAdapter.notifyDataSetChanged()
            guiViewModel.isEmptyListVisible.value = meetingViewModel.getFavouritesList().isEmpty()
            swipe_refresh_meeting_list.isRefreshing = false
        })

        //indien lijstDesign veranderd moet de adapter opnieuw zijn cards genereren met nieuwe stijl
        //hier kan je momenteel enkel adapter opnieuw toekennen mits notifyDataSetChanged etc niet
        //opnieuw inflate methode aanroept waar je itemstijl meegeeft
        guiViewModel.listDesign.observe(this, Observer {
            recycler_meeting_list.adapter = favouritesAdapter
        })

        //swipe to refresh van de lijst
        swipe_refresh_meeting_list.setOnRefreshListener {
            meetingViewModel.refreshMeetingList(false)
        }
    }

    /**
     * Functie voor het stoppen van de listeners
     */
    @Suppress("UNUSED_EXPRESSION")
    private fun stopListeners() {
        meetingViewModel.meetingList.removeObservers(this)
        guiViewModel.listDesign.removeObservers(this)
        //refreshing nog op false zetten voor we listener stoppen
        swipe_refresh_meeting_list.isRefreshing = false
        swipe_refresh_meeting_list.setOnRefreshListener { null }
    }

    override fun onStart() {
        super.onStart()
        if (!accountViewModel.isLoggedIn.value!!) {
            MessageUtil.showDialogLoginRequired(requireActivity() as MainActivity)
            requireActivity().supportFragmentManager.popBackStack()

        } else {
            initListeners()
            guiViewModel.actionBarTitle.value = getString(R.string.ab_favourites_title)
            guiViewModel.actionBarSubTitle.value = getString(R.string.ab_favourite_subtitle)
            guiViewModel.activeMenuItem.value = MenuItemEnum.FAVOURITES
            guiViewModel.isListDesignOptionsVisible.value = true
        }
    }

    override fun onStop() {
        super.onStop()
        stopListeners()
        guiViewModel.resetLayout()
    }
}