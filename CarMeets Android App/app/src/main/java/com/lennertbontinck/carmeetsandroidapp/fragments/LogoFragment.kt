package com.lennertbontinck.carmeetsandroidapp.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lennertbontinck.carmeetsandroidapp.R

/**
 * Een [Fragment] die als *placeholder* gebruikt kan worden.
 *
 * Toont het carmeets logo met de tekst over het ontstaan van de app
 */
class LogoFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_placeholder_logo, container, false)
    }

}