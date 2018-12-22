package com.lennertbontinck.carmeetsandroidapp.fragments

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lennertbontinck.carmeetsandroidapp.R
import com.lennertbontinck.carmeetsandroidapp.databinding.FragmentAccountBinding
import com.lennertbontinck.carmeetsandroidapp.databinding.FragmentMeetingdetailBinding
import com.lennertbontinck.carmeetsandroidapp.enums.MenuItemEnum
import com.lennertbontinck.carmeetsandroidapp.viewmodels.AccountViewModel
import com.lennertbontinck.carmeetsandroidapp.viewmodels.GuiViewModel
import kotlinx.android.synthetic.main.fragment_account.*
import kotlinx.android.synthetic.main.fragment_account.view.*

/**
 * Een [Fragment] die de accountpagina van een aangemelde gebruiker laat zien.
 */
class AccountFragment : Fragment() {

    /**
     * [AccountViewModel] met de data over account
     */
    private lateinit var accountViewModel: AccountViewModel

    /**
     * [GuiViewModel] met de data over de GUI instellingen
     */
    private lateinit var guiViewModel: GuiViewModel

    /**
     * De [FragmentAccountBinding] dat we gebruiken voor de effeciteve databinding
     */
    private lateinit var binding: FragmentAccountBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_account, container, false)

        //viewmodel vullen
        guiViewModel = ViewModelProviders.of(requireActivity()).get(GuiViewModel::class.java)
        accountViewModel = ViewModelProviders.of(requireActivity()).get(AccountViewModel::class.java)

        val fragment = binding.root
        binding.accountViewModel = accountViewModel
        binding.setLifecycleOwner(activity)

        return fragment
    }

    /**
     * Functie voor het instantiëren van de listeners.
     */
    private fun initListeners() {
        btn_profile_logout.setOnClickListener {
            accountViewModel.logout()
        }

        //indien niet aangemeld login page tonen
        accountViewModel.isLoggedIn.observe(this, Observer {
            if (!accountViewModel.isLoggedIn.value!!){
                requireActivity().supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_main_fragmentcontainer, LoginFragment())
                    .addToBackStack(getString(R.string.fragtag_login))
                    .commit()
            }
        })
    }

    /**
     * Functie voor het stoppen van de listeners
     */
    @Suppress("UNUSED_EXPRESSION")
    private fun stopListeners() {
        btn_profile_logout.setOnClickListener { null }
        accountViewModel.isLoggedIn.removeObservers(this)

    }

    override fun onStart() {
        super.onStart()
        initListeners()
        guiViewModel.actionBarTitle.value = getString(R.string.ab_account_title)
        guiViewModel.actionBarSubTitle.value = getString(R.string.ab_account_subtitle)
        guiViewModel.activeMenuItem.value = MenuItemEnum.ACCOUNT
    }

    override fun onStop() {
        super.onStop()
        stopListeners()
        guiViewModel.resetLayout()
    }

}