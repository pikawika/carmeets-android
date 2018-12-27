package com.lennertbontinck.carmeetsandroidapp.fragments

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lennertbontinck.carmeetsandroidapp.R
import com.lennertbontinck.carmeetsandroidapp.constants.FRAGTAG_ACCOUNT
import com.lennertbontinck.carmeetsandroidapp.constants.FRAGTAG_LOGIN
import com.lennertbontinck.carmeetsandroidapp.enums.MenuItemEnum
import com.lennertbontinck.carmeetsandroidapp.utils.MessageUtil
import com.lennertbontinck.carmeetsandroidapp.viewmodels.AccountViewModel
import com.lennertbontinck.carmeetsandroidapp.viewmodels.GuiViewModel
import kotlinx.android.synthetic.main.fragment_register.*

/**
 * Een [Fragment] waarmee een gebruiker hem kan registreren.
 *
 * Gebruiker kan doorklikken naar goToLogin.
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
                requireActivity().supportFragmentManager.beginTransaction()
                    .setCustomAnimations(R.anim.push_down_in,
                        R.anim.push_down_out,
                        R.anim.push_up_in,
                        R.anim.push_up_out)
                    .replace(R.id.frame_main_fragment_container, AccountFragment())
                    .addToBackStack(FRAGTAG_ACCOUNT)
                    .commit()
            }
        })

        btn_register_login.setOnClickListener {
            goToLogin()
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
     * Gaat naar login fragment
     */
    private fun goToLogin() {
        requireActivity().supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(R.anim.push_right_in,
                R.anim.push_right_out,
                R.anim.push_left_in,
                R.anim.push_left_out)
            .replace(R.id.frame_main_fragment_container, LoginFragment())
            .addToBackStack(FRAGTAG_LOGIN)
            .commit()
    }

    override fun onStart() {
        super.onStart()
        guiViewModel.actionBarTitle.value = getString(R.string.txt_register)
        guiViewModel.isBackButtonVisible.value = true
        guiViewModel.activeMenuItem.value = MenuItemEnum.ACCOUNT
        initListeners()
    }

    override fun onStop() {
        stopListeners()
        guiViewModel.resetLayout()
        super.onStop()
    }

}