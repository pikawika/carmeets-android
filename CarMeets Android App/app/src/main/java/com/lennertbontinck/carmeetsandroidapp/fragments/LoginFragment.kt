package com.lennertbontinck.carmeetsandroidapp.fragments

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lennertbontinck.carmeetsandroidapp.R
import com.lennertbontinck.carmeetsandroidapp.constants.FRAGTAG_ACCOUNT
import com.lennertbontinck.carmeetsandroidapp.constants.FRAGTAG_REGISTER
import com.lennertbontinck.carmeetsandroidapp.enums.MenuItemEnum
import com.lennertbontinck.carmeetsandroidapp.utils.MessageUtil
import com.lennertbontinck.carmeetsandroidapp.viewmodels.AccountViewModel
import com.lennertbontinck.carmeetsandroidapp.viewmodels.GuiViewModel
import kotlinx.android.synthetic.main.fragment_login.*

/**
 * Een [Fragment] waar een gebruiker zich kan aanmelden of kan doorklikken naar registreren.
 */
class LoginFragment : Fragment() {

    /**
     * [AccountViewModel] met de data over account
     */
    private lateinit var accountViewModel: AccountViewModel

    /**
     * [GuiViewModel] met de data over de GUI instellingen
     */
    private lateinit var guiViewModel: GuiViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_login, container, false)

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

        btn_login_confirm.setOnClickListener {
            login()
        }

        btn_login_register.setOnClickListener {
            goToRegister()
        }
    }

    /**
     * Stop de listeners
     */
    @Suppress("UNUSED_EXPRESSION")
    private fun stopListeners() {
        btn_login_confirm.setOnClickListener { null }

        btn_login_register.setOnClickListener { null }

        accountViewModel.isLoggedIn.removeObservers(this)
    }

    /**
     * Gaat naar register fragment
     */
    private fun goToRegister() {
        requireActivity().supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(R.anim.push_left_in,
                R.anim.push_left_out,
                R.anim.push_right_in,
                R.anim.push_right_out)
            .replace(R.id.frame_main_fragment_container, RegisterFragment())
            .addToBackStack(FRAGTAG_REGISTER)
            .commit()
    }

    /**
     * Controleert de waarden en logt in
     */
    private fun login() {
        //velden leeg
        if (TextUtils.isEmpty(text_login_username.text.toString()) && TextUtils.isEmpty(text_login_password.text.toString()))
            MessageUtil.showToast(
                getString(R.string.warning_empty_fields)
            )
        else accountViewModel.login(text_login_username.text.toString(), text_login_password.text.toString())
    }

    override fun onStart() {
        super.onStart()
        guiViewModel.actionBarTitle.value = getString(R.string.txt_login)
        guiViewModel.activeMenuItem.value = MenuItemEnum.ACCOUNT
        initListeners()
    }

    override fun onStop() {
        stopListeners()
        guiViewModel.resetLayout()
        super.onStop()
    }


}