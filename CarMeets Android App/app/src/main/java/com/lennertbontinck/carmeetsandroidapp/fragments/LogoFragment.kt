package com.lennertbontinck.carmeetsandroidapp.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lennertbontinck.carmeetsandroidapp.R

/**
 * Een [Fragment] die een placeholder toont met het carmeets logo en een tekst rond het project.
 */
class LogoFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val fragment =  inflater.inflate(R.layout.fragment_placeholder_logo, container, false)

        return fragment
    }

}