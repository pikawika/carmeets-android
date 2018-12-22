package com.lennertbontinck.carmeetsandroidapp.injection.components

import com.lennertbontinck.carmeetsandroidapp.injection.modules.NetworkModule
import com.lennertbontinck.carmeetsandroidapp.viewmodels.AccountViewModel
import com.lennertbontinck.carmeetsandroidapp.viewmodels.MeetingViewModel
import dagger.Component
import javax.inject.Singleton

/**
 * Deze [NetworkComponent] dient als tussenlaag tussen de [NetworkModule] en de effectieve [MeetingViewModel]
 *
 * Momenteel compatibel met: [MeetingViewModel]
 */
@Singleton
/**
 * We hebben de netwerkmodule nodig voor het ophalen van de data
 */
@Component(modules = [NetworkModule::class])
interface NetworkComponent {

    /**
     * Doet dependency injection op de meegegeven [MeetingViewModel]
     *
     * @param meetingViewModel De [MeetingViewModel] dat je wilt voorzien van dependency injection. Verplicht van type [MeetingViewModel].
     */
    fun inject(meetingViewModel: MeetingViewModel)

    /**
     * Doet dependency injection op de meegegeven [AccountViewModel]
     *
     * @param accountViewModel De [AccountViewModel] dat je wilt voorzien van dependency injection. Verplicht van type [AccountViewModel].
     */
    fun inject(accountViewModel: AccountViewModel)

    //soortgelijke functies aanmaken voor alle andere injecties van models
}