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

/**
 * Een [Fragment] die de accountpagina van een aangemelde gebruiker laat zien.
 */
class AccountFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val fragment =  inflater.inflate(R.layout.fragment_account, container, false)

        //shared layout instellen
        val parentActivity = (activity as AppCompatActivity)
        LayoutUtil.setActionBar(parentActivity, getString(R.string.ab_account_titel), getString(R.string.ab_account_subtitel))
        LayoutUtil.clearActionBarOptions(parentActivity)
        LayoutUtil.setBottomNavigation(parentActivity, R.id.nav_account)

        //temp tekst als POC
        fragment.text_account_temptekst.text = "hallo van account!"

        return fragment
    }

}