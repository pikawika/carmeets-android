package com.lennertbontinck.carmeetsandroidapp.fragments

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lennertbontinck.carmeetsandroidapp.R
import com.lennertbontinck.carmeetsandroidapp.constants.FRAGTAG_CHANGE_PASSWORD
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
        button_manage_account_change_password.setOnClickListener {
            if (guiViewModel.isTwoPaneEnvironment.value!!) {
                requireActivity().supportFragmentManager.beginTransaction()
                    .setCustomAnimations(R.anim.push_left_in,
                        R.anim.push_left_out,
                        R.anim.push_right_in,
                        R.anim.push_right_out)
                    .replace(R.id.frame_account_two_pane_container, ChangePasswordFragment())
                    .addToBackStack(FRAGTAG_CHANGE_PASSWORD)
                    .commit()
            } else {
                requireActivity().supportFragmentManager.beginTransaction()
                    .setCustomAnimations(R.anim.push_up_in,
                        R.anim.push_up_out,
                        R.anim.push_down_in,
                        R.anim.push_down_out)
                    .replace(R.id.frame_main_fragment_container, ChangePasswordFragment())
                    .addToBackStack(FRAGTAG_CHANGE_PASSWORD)
                    .commit()
            }
        }

        //wijzig gebruikersnaam
        button_manage_account_change_username.setOnClickListener {
            MessageUtil.showDialogWithTextInput(
                requireContext(),
                getString(R.string.txt_change_username),
                getString(R.string.txt_choose_new_username),
                getString(R.string.hint_new_username),
                changeUsername()
            )
        }

        //wijzig e-mailadres
        button_manage_account_change_email.setOnClickListener {
            MessageUtil.showDialogWithTextInput(
                requireContext(),
                getString(R.string.txt_change_email),
                getString(R.string.txt_choose_new_email),
                getString(R.string.hint_new_email),
                changeEmail()
            )
        }
    }

    /**
     * Als parameter mee te geven functie die een wijzig wachtwoord verzoek uitvoert met een meegegeven string
     */
    private fun changeUsername() = { newUsername: String -> accountViewModel.changeUsername(newUsername) }

    /**
     * Als parameter mee te geven functie die een wijzig email verzoek uitvoert met een meegegeven string
     */
    private fun changeEmail() = { newEmail: String -> accountViewModel.changeEmail(newEmail) }

    /**
     * Functie voor het stoppen van de listeners
     */
    @Suppress("UNUSED_EXPRESSION")
    private fun stopListeners() {
        button_manage_account_change_password.setOnClickListener { null }
        button_manage_account_change_username.setOnClickListener { null }
        button_manage_account_change_email.setOnClickListener { null }
    }

    override fun onStart() {
        super.onStart()
        initListeners()
        guiViewModel.actionBarTitle.value = getString(R.string.txt_manage_account)
        guiViewModel.actionBarSubTitle.value = getString(R.string.ab_account_subtitle)
        guiViewModel.activeMenuItem.value = MenuItemEnum.ACCOUNT
        if (!guiViewModel.isTwoPaneEnvironment.value!!)
            guiViewModel.isBackButtonVisible.value = true
    }

    override fun onStop() {
        super.onStop()
        stopListeners()
        guiViewModel.resetLayout()
    }

}