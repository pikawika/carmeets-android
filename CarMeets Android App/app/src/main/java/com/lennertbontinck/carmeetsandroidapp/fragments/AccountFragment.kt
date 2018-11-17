package com.lennertbontinck.carmeetsandroidapp.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lennertbontinck.carmeetsandroidapp.R
import com.lennertbontinck.carmeetsandroidapp.utils.LayoutUtil
import kotlinx.android.synthetic.main.fragment_account.view.*

class AccountFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val fragment =  inflater.inflate(R.layout.fragment_account, container, false)

        //set action bar and bottom nav bar
        var parentActivity = (activity as AppCompatActivity)
        LayoutUtil.setMainLayout(parentActivity, getString(R.string.ab_account_titel), getString(R.string.ab_account_subtitel), false, R.id.nav_account)

        //temp tekst als poc
        fragment.text_account_temptekst.text = "hallo van account!"

        return fragment
    }

}