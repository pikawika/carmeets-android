package com.lennertbontinck.carmeetsandroidapp.fragments

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lennertbontinck.carmeetsandroidapp.R
import com.lennertbontinck.carmeetsandroidapp.enums.MenuItemEnum
import com.lennertbontinck.carmeetsandroidapp.utils.MessageUtil
import com.lennertbontinck.carmeetsandroidapp.viewmodels.AccountViewModel
import com.lennertbontinck.carmeetsandroidapp.viewmodels.GuiViewModel
import kotlinx.android.synthetic.main.fragment_manage_account.*

/**
 * Een [Fragment] die de accountpagina van een aangemelde gebruiker laat zien.
 */
class ManageAccountFragment : Fragment() {

    /**
     * [AccountViewModel] met de data over account
     */
    private lateinit var accountViewModel: AccountViewModel

    /**
     * [GuiViewModel] met de data over de GUI instellingen
     */
    private lateinit var guiViewModel: GuiViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_manage_account, container, false)

        //viewmodel vullen
        accountViewModel = ViewModelProviders.of(requireActivity()).get(AccountViewModel::class.java)
        guiViewModel = ViewModelProviders.of(requireActivity()).get(GuiViewModel::class.java)

        return rootView
    }

    /**
     * Functie voor het instantiëren van de listeners.
     */
    private fun initListeners() {
        //wijzig wachtwoord
        btn_manage_account_change_password.setOnClickListener {
            MessageUtil.showToast("clicked change pw")
        }

        //wijzig gebruikersnaam
        btn_manage_account_change_username.setOnClickListener {
            MessageUtil.showToast("clicked change username")
        }

        //wijzig e-mailadres
        btn_manage_account_change_email.setOnClickListener {
            MessageUtil.showToast("clicked change email")
        }
    }

    /**
     * Functie voor het stoppen van de listeners
     */
    @Suppress("UNUSED_EXPRESSION")
    private fun stopListeners() {
        btn_manage_account_change_password.setOnClickListener { null }
        btn_manage_account_change_username.setOnClickListener { null }
        btn_manage_account_change_email.setOnClickListener { null }
    }

    override fun onStart() {
        super.onStart()
        initListeners()
        guiViewModel.actionBarTitle.value = getString(R.string.txt_manage_account)
        guiViewModel.actionBarSubTitle.value = getString(R.string.ab_account_subtitle)
        guiViewModel.isBackButtonVisible.value = true
        guiViewModel.activeMenuItem.value = MenuItemEnum.ACCOUNT
    }

    override fun onStop() {
        super.onStop()
        stopListeners()
        guiViewModel.resetLayout()
    }

}