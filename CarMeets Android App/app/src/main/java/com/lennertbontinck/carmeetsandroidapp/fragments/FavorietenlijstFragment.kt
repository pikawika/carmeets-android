package com.lennertbontinck.carmeetsandroidapp.fragments

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lennertbontinck.carmeetsandroidapp.R
import com.lennertbontinck.carmeetsandroidapp.activities.MainActivity
import com.lennertbontinck.carmeetsandroidapp.adapters.MeetingAdapter
import com.lennertbontinck.carmeetsandroidapp.enums.LijstDesignEnum
import com.lennertbontinck.carmeetsandroidapp.models.Meeting
import com.lennertbontinck.carmeetsandroidapp.utils.LayoutUtil
import com.lennertbontinck.carmeetsandroidapp.viewmodels.MeetingViewModel
import kotlinx.android.synthetic.main.fragment_meetinglijst.view.*
import java.sql.Date

/**
 * Een [Fragment] die alle gelikete en going meetings van een gebruiker laat zien.
 * Hiervoor moet de gebruiker uiteraard een account hebben en ingelogd zijn.
 *
 * Gebruik [FavorietenlijstFragment.newInstance] om een [LijstDesignEnum] type mee te geven.
 */
class FavorietenlijstFragment : Fragment() {

    private var isTablet: Boolean = false

    /**
     * The [MeetingViewModel] we will use to display the data
     */
    private lateinit var viewModel: MeetingViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_meetinglijst, container, false)

        //set action bar and bottom nav bar
        var parentActivity = (activity as AppCompatActivity)
        LayoutUtil.setMainLayout(parentActivity, getString(R.string.ab_favorieten_titel), getString(R.string.ab_favorieten_subtitel), true, R.id.nav_favorieten)

        //viewmodel vullen
        viewModel = ViewModelProviders.of(requireActivity()).get(MeetingViewModel::class.java)

        //lijst vullen met meetings
        val meetings = viewModel.getMeetings()

        //haal weergave uit companion
        var lijstDesgin = arguments!!.getSerializable("lijstDesgin") as LijstDesignEnum

        //indien een een detailcontainer is, is het een tablet en wordt er in die container een placeholder gezet
        if (rootView.frame_meetinglijst_meetingdetailcontainer != null) {
            isTablet = true
            parentActivity.supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame_meetinglijst_meetingdetailcontainer, LogoFragment())
                .commit()
        }

        val adapter = MeetingAdapter(this.requireActivity() as MainActivity, meetings, lijstDesgin, isTablet)

        meetings.observe(this, Observer {
            adapter.notifyDataSetChanged()
        })

        //recyclerview vullen
        rootView.recyclerview_meetinglijst.adapter = adapter

        return rootView
    }

    companion object {
        fun newInstance(designEnum: LijstDesignEnum): FavorietenlijstFragment {
            //bij he aanmaken van de fragment wordt een param meegegeven voor de layout van de lijst
            val args = Bundle()
            args.putSerializable("lijstDesgin", designEnum)
            val fragment = FavorietenlijstFragment()
            fragment.arguments = args
            return fragment
        }
    }

}