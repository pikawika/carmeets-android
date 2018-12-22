package com.lennertbontinck.carmeetsandroidapp.bases

import android.accounts.Account
import android.arch.lifecycle.ViewModel
import com.lennertbontinck.carmeetsandroidapp.context.CarMeetsApplication.Companion.injector
import com.lennertbontinck.carmeetsandroidapp.injection.components.NetworkComponent
import com.lennertbontinck.carmeetsandroidapp.viewmodels.AccountViewModel
import com.lennertbontinck.carmeetsandroidapp.viewmodels.MeetingViewModel

/**
 * Een implementeerbare basis [ViewModel] klasse voor viewmodels die injectie nodig hebben via dagger.
 *
 * Er zal adhv het viewmodel type de juiste injectie voorzien worden.
 *
 * Momenteel compatibel met:
 * - [MeetingViewModel]
 *
 * Special thanks to Harm De Weirdt for base code and clear explanation of innerworkings.
 * https://github.com/hdeweirdt/metar
 */
abstract class InjectedViewModel : ViewModel() {


    //Injecteren zodra de viewmodel aangemaakt wordt.
    init {
        inject()
    }

    /**
     * Injecteren adhvd de reeds aangemaakte dagger instantie van de klasse die de [InjectedViewModel] overerft.
     *
     * Hier zullen nieuwe viewModels toegevoegd moeten worden alsook in de [NetworkComponent].
     */
    private fun inject() {
        when (this) {
            is MeetingViewModel -> injector.inject(this)
            is AccountViewModel -> injector.inject(this)
        }
    }


}