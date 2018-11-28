package com.lennertbontinck.carmeetsandroidapp.bases

import android.arch.lifecycle.ViewModel
import com.lennertbontinck.carmeetsandroidapp.injection.components.DaggerMeetingViewModelComponent
import com.lennertbontinck.carmeetsandroidapp.injection.components.MeetingViewModelComponent
import com.lennertbontinck.carmeetsandroidapp.injection.modules.NetworkModule
import com.lennertbontinck.carmeetsandroidapp.viewmodels.MeetingViewModel

/**
 * Een implementeerbare basis [ViewModel] klasse voor viewmodels die injectie nodig hebben via dagger.
 *
 * Er zal adhv het viewmodel type de juiste injectie voorzien worden
 *
 * momenteel compatibel met: [MeetingViewModel]
 *
 * Special thanks to Harm De Weirdt for base code and clear explanation of innerworkings
 * https://github.com/hdeweirdt/metar
 */
abstract class InjectedViewModel : ViewModel() {
    /**
     * Er is een instance nodig van de dagger [MeetingViewModelComponent] om de injectie mee uit te voeren
     */
    private val meetingInjector: MeetingViewModelComponent = DaggerMeetingViewModelComponent
        .builder()
        .networkModule(NetworkModule)
        .build()

    /**
     * Injecteren zodra de viewmodel aangemaakt wordt
     */
    init {
        inject()
    }

    /**
     * Injecteren adhvd de reeds aangemaakte dagger instantie van de klasse die de [InjectedViewModel] overerft.
     */
    private fun inject() {
        when (this) {
            is MeetingViewModel -> meetingInjector.inject(this)
        }
    }


}