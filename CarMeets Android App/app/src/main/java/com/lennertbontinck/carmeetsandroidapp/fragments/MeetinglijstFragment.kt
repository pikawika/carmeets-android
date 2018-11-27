package com.lennertbontinck.carmeetsandroidapp.fragments

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
import com.lennertbontinck.carmeetsandroidapp.enums.LijstDesignEnum
import com.lennertbontinck.carmeetsandroidapp.models.Meeting
import com.lennertbontinck.carmeetsandroidapp.utils.LayoutUtil
import com.lennertbontinck.carmeetsandroidapp.viewmodels.MeetingViewModel
import kotlinx.android.synthetic.main.fragment_meetinglijst.view.*
import java.sql.Date

/**
 * Een [Fragment] die alle meetings laat zien.
 *
 * Gebruik [MeetinglijstFragment.newInstance] om een [LijstDesignEnum] type mee te geven.
 */
class MeetinglijstFragment : Fragment() {

    private var isTablet: Boolean = false

    private lateinit var viewModel: MeetingViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_meetinglijst, container, false)

        //set action bar and bottom nav bar
        var parentActivity = (activity as AppCompatActivity)
        LayoutUtil.setMainLayout(parentActivity, getString(R.string.ab_meetings_titel), getString(R.string.ab_meetings_subtitel), true, R.id.nav_meetings)

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

        //recyclerview vullen
        rootView.recyclerview_meetinglijst.adapter = MeetingAdapter(this.requireActivity() as MainActivity, meetings, lijstDesgin, isTablet)

        return rootView
    }

    companion object {
        fun newInstance(designEnum: LijstDesignEnum): MeetinglijstFragment {
            //bij he aanmaken van de fragment wordt een param meegegeven voor de layout van de lijst
            val args = Bundle()
            args.putSerializable("lijstDesgin", designEnum)
            val fragment = MeetinglijstFragment()
            fragment.arguments = args
            return fragment
        }
    }

}