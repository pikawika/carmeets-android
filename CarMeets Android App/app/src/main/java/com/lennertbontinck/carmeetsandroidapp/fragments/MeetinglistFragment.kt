package com.lennertbontinck.carmeetsandroidapp.fragments

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lennertbontinck.carmeetsandroidapp.R
import com.lennertbontinck.carmeetsandroidapp.activities.MainActivity
import com.lennertbontinck.carmeetsandroidapp.adapters.MeetingAdapter
import com.lennertbontinck.carmeetsandroidapp.utils.LayoutUtil
import com.lennertbontinck.carmeetsandroidapp.viewmodels.MeetingViewModel
import kotlinx.android.synthetic.main.fragment_meetinglist.view.*

/**
 * Een [Fragment] die alle meetings laat zien.
 *
 * Maakt gebruik van de MVVM voor meetings op te halen en de geselecteerde lijstLayout te gebruiken.
 */
class MeetinglistFragment : Fragment() {

    /**
     * [Boolean] of het huidige device al dan niet een tablet is/ of al dan niet twopane design gebruikt moet worden.
     * Default is dit false
     */
    //Globaal ter beschikking gesteld aangezien het mogeiljks later nog in andere functie dan onCreateView wenst te worden
    private var isTablet: Boolean = false

    /**
     * [MeetingViewModel] met de data van alle meetings
     */
    //Globaal ter beschikking gesteld aangezien het mogeiljks later nog in andere functie dan onCreateView wenst te worden
    private lateinit var meetingViewModel: MeetingViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val fragment = inflater.inflate(R.layout.fragment_meetinglist, container, false)

        //shared layout instellen
        val parentActivity = (activity as AppCompatActivity)
        LayoutUtil.setActionBar(parentActivity, getString(R.string.ab_meetings_title), getString(R.string.ab_meetings_subtitle))
        LayoutUtil.clearActionBarOptions(parentActivity)
        LayoutUtil.showListLayoutOpties(parentActivity)
        LayoutUtil.setBottomNavigation(parentActivity, R.id.nav_meetings)

        //viewmodel vullen
        meetingViewModel = ViewModelProviders.of(requireActivity()).get(MeetingViewModel::class.java)

        //lijst vullen met meetings uit viewmodel.
        //We doen niet direct .value maar behouden het als mutueablelivedata mits we hier op willen op observen
        val meetings = meetingViewModel.getMeetings()

        //haal weergave uit de viewmodel
        //We doen niet direct .value maar behouden het als mutueablelivedata mits we hier op willen op observen
        val listDesgin = meetingViewModel.getListDesgin()

        //Bepalen of er al dan niet een detailcontainer is
        //->indien deze er is weet men dat het over een tablet (twoPane) gaat
        //->initieel vullen met ene placeholder logofragment om geen blake pagina te hebbenæ
        if (fragment.frame_meetinglijst_meetingdetailcontainer != null) {
            isTablet = true
            parentActivity.supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame_meetinglijst_meetingdetailcontainer, LogoFragment())
                .commit()
        }

        //adapter aanmaken
        val adapter = MeetingAdapter(this.requireActivity() as MainActivity, meetings, listDesgin, isTablet)

        //indien de meetinglijst veranderd moet de adapter opnieuw zijn cards genereren met nieuwe data
        meetings.observe(this, Observer {
            adapter.notifyDataSetChanged()
        })

        //indien lijstDesign veranderd moet de adapter opnieuw zijn cards genereren met nieuwe stijl
        //hier kan je momenteel enkel adapter opnieuw toekennen mits notifyDataSetChanged etc niet
        //      opnieuw inflate methode aanroept waar je itemstijl meegeeft
        listDesgin.observe(this, Observer {
            fragment.recyclerview_meetinglijst.adapter = adapter
        })

        //recyclerview vullen door adapter toe te kennen
        fragment.recyclerview_meetinglijst.adapter = adapter

        return fragment
    }
}