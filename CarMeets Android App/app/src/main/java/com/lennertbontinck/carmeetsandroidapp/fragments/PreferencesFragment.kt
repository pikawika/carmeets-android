package com.lennertbontinck.carmeetsandroidapp.fragments

import android.app.AlertDialog
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lennertbontinck.carmeetsandroidapp.R
import com.lennertbontinck.carmeetsandroidapp.enums.MenuItemEnum
import com.lennertbontinck.carmeetsandroidapp.utils.MessageUtil
import com.lennertbontinck.carmeetsandroidapp.utils.PreferenceUtil
import com.lennertbontinck.carmeetsandroidapp.viewmodels.AccountViewModel
import com.lennertbontinck.carmeetsandroidapp.viewmodels.GuiViewModel
import kotlinx.android.synthetic.main.fragment_preferences.*

/**
 * Een [Fragment] die de accountpagina van een aangemelde gebruiker laat zien.
 */
class PreferencesFragment : Fragment() {

    /**
     * [AccountViewModel] met de data over account
     */
    private lateinit var accountViewModel: AccountViewModel

    /**
     * [GuiViewModel] met de data over de GUI instellingen
     */
    private lateinit var guiViewModel: GuiViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_preferences, container, false)

        //viewmodel vullen
        accountViewModel = ViewModelProviders.of(requireActivity()).get(AccountViewModel::class.java)
        guiViewModel = ViewModelProviders.of(requireActivity()).get(GuiViewModel::class.java)

        return rootView
    }

    /**
     * Functie voor het instantiëren van de listeners.
     */
    private fun initListeners() {
        //wijzig startpagina
        btn_preferences_change_boot_page.setOnClickListener {
            showBootPageSelector()
        }

        //voorkeurscategoriën
        btn_preferences_change_default_categories.setOnClickListener {
            MessageUtil.showToast("clicked change default cats")
        }
    }

    /**
     * Functie voor het stoppen van de listeners
     */
    @Suppress("UNUSED_EXPRESSION")
    private fun stopListeners() {
        btn_preferences_change_boot_page.setOnClickListener { null }
        btn_preferences_change_default_categories.setOnClickListener { null }
    }

    /**
     * Toont het keuze menu voor de boot page en stelt de gekozen boot page in.
     */
    private fun showBootPageSelector() {
        //lijst van bootpages
        val pages = arrayOf(
            getString(R.string.ab_meetings_title),
            getString(R.string.ab_favourites_title),
            getString(R.string.ab_account_title)
        )
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle(getString(R.string.txt_preferences_choose_boot_page))
        builder.setItems(pages) { _, which ->
            when (pages[which]) {
                //bijhorende Pagina ophalen
                getString(R.string.ab_meetings_title) -> PreferenceUtil.setDefaultBootPage(MenuItemEnum.MEETINGS)
                getString(R.string.ab_favourites_title) -> PreferenceUtil.setDefaultBootPage(MenuItemEnum.FAVOURITES)
                getString(R.string.ab_account_title) -> PreferenceUtil.setDefaultBootPage(MenuItemEnum.ACCOUNT)
            }
        }
        builder.show()
    }

    override fun onStart() {
        super.onStart()
        initListeners()
        guiViewModel.actionBarTitle.value = getString(R.string.txt_preferences)
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