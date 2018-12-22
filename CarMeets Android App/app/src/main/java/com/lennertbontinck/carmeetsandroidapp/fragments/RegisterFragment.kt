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
import com.lennertbontinck.carmeetsandroidapp.utils.MessageUtil
import com.lennertbontinck.carmeetsandroidapp.viewmodels.AccountViewModel
import com.lennertbontinck.carmeetsandroidapp.viewmodels.GuiViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_register.*

/**
 * Een [Fragment] waarmee een gebruiker hem kan registreren.
 *
 * Gebruiker kan doorklikken naar login.
 */
class RegisterFragment : Fragment() {

    /**
     * [AccountViewModel] met de data over account
     */
    private lateinit var accountViewModel: AccountViewModel

    /**
     * [GuiViewModel] met de data over de GUI instellingen
     */
    private lateinit var guiViewModel: GuiViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_register, container, false)

        //viewmodel vullen
        accountViewModel = ViewModelProviders.of(requireActivity()).get(AccountViewModel::class.java)
        guiViewModel = ViewModelProviders.of(requireActivity()).get(GuiViewModel::class.java)

        return rootView
    }

    /**
     * Instantieer de listeners
     */
    private fun initListeners() {
        //indien aangemeld account opnieuw laden
        accountViewModel.isLoggedIn.observe(this, Observer {
            if (accountViewModel.isLoggedIn.value!!) {
                //simuleert een button click op account om er voor te zorgen dat juiste
                //item actief is + zet fragment etc automatisch juist
                (requireActivity() as AppCompatActivity).menu_main_bottomnavigation.selectedItemId =
                        R.id.nav_account
            }
        })

        btn_register_login.setOnClickListener {
            login()
        }

        btn_register_confirm.setOnClickListener {
            register()
        }
    }

    /**
     * Stop de listeners
     */
    @Suppress("UNUSED_EXPRESSION")
    private fun stopListeners() {
        btn_register_login.setOnClickListener { null }

        btn_register_confirm.setOnClickListener { null }

        accountViewModel.isLoggedIn.removeObservers(this)
    }

    /**
     * Kijkt of velden ingevuld zijn en wachtwoorden overeenkomen en probeert vervolgens te registreren
     */
    private fun register() {
        //er is een veld leeg
        if (text_register_email.text.toString() == "" ||
            text_register_username.text.toString() == "" ||
            text_register_password.text.toString() == "" ||
            text_register_confirm_password.text.toString() == ""
        ) {
            MessageUtil.showToast(getString(R.string.warning_empty_fields))
        }

        //wws niet gelijk
        else if (text_register_password.text.toString() != text_register_confirm_password.text.toString()) {
            MessageUtil.showToast(getString(R.string.warning_passwords_not_equal))
        }

        //registreer
        else {
            accountViewModel.register(
                text_register_email.text.toString(),
                text_register_username.text.toString(),
                text_register_password.text.toString()
            )
        }
    }

    /**
     * Kijkt of velden ingevuld zijn en probeert aan te melden
     */
    private fun login() {
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_main_fragmentcontainer, LoginFragment())
            .addToBackStack(getString(R.string.fragtag_login))
            .commit()
    }

    override fun onStart() {
        super.onStart()
        guiViewModel.actionBarTitle.value = getString(R.string.txt_register)
        guiViewModel.isBackButtonVisible.value = true
        initListeners()
    }

    override fun onStop() {
        stopListeners()
        guiViewModel.resetLayout()
        super.onStop()
    }

}