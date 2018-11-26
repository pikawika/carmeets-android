package com.lennertbontinck.carmeetsandroidapp.injection.components

import com.lennertbontinck.carmeetsandroidapp.injection.modules.NetworkModule
import com.lennertbontinck.carmeetsandroidapp.viewmodels.MeetingViewModel
import dagger.Component
import javax.inject.Singleton

/**
 * Deze [MeetingViewModelComponent] dient als tussenlaag tussen de [NetworkModule] en de effectieve [MeetingViewModel]
 */
@Singleton
/**
 * We hebben de netwerkmodule nodig voor het ophalen van de data
 */
@Component(modules = [NetworkModule::class])
interface MeetingViewModelComponent {

    /**
     * Doet dependency injection op de meegegeven MeetingViewModel
     *
     * @param meetingViewModel De [MeetingViewModel] dat je wilt voorzien van dependency injection. Verplicht van type [MeetingViewModel].
     */
    fun inject(meetingViewModel: MeetingViewModel)
}