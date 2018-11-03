package com.lennertbontinck.carmeetsandroidapp.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lennertbontinck.carmeetsandroidapp.R
import kotlinx.android.synthetic.main.fragment_meetinglijst.view.*

class MeetinglijstFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val fragment =  inflater.inflate(R.layout.fragment_meetinglijst, container, false)

        fragment.textview_meetinglijstitem_temptekst.text = "hallo van home!"

        return fragment
    }

}