package com.lennertbontinck.carmeetsandroidapp.bases

import android.arch.lifecycle.ViewModel
import com.lennertbontinck.carmeetsandroidapp.injection.components.DaggerMeetingViewModelComponent
import com.lennertbontinck.carmeetsandroidapp.injection.components.MeetingViewModelComponent
import com.lennertbontinck.carmeetsandroidapp.injection.modules.NetworkModule
import com.lennertbontinck.carmeetsandroidapp.viewmodels.MeetingViewModel

/**
 * Een implementeerbare basis [ViewModel] klasse voor viewmodels die injectie nodig hebben via dagger.
 */
abstract class InjectedViewModel : ViewModel() {
    /**
     * An MeetingViewModelComponent is required to do the actual injecting.
     * Every Component has a default builder to which you can add all
     * modules that will be needed for the injection.
     */
    private val meetingInjector: MeetingViewModelComponent = DaggerMeetingViewModelComponent
        .builder()
        .networkModule(NetworkModule)
        .build()

    /**
     * Perform the injection when the ViewModel is created
     */
    init {
        inject()
    }

    /**
     * Injects the required dependencies.
     * We need the 'when(this)' construct for each new ViewModel as the 'this' reference should
     * refer to an instance of that specific ViewModel.
     * Just injecting into a generic InjectedViewModel is not specific enough for Dagger.
     */
    private fun inject() {
        when (this) {
            is MeetingViewModel -> meetingInjector.inject(this)
        }
    }


}