package com.lennertbontinck.carmeetsandroidapp.viewmodels

import android.arch.lifecycle.MutableLiveData
import com.lennertbontinck.carmeetsandroidapp.bases.InjectedViewModel
import com.lennertbontinck.carmeetsandroidapp.enums.ListDesignEnum
import com.lennertbontinck.carmeetsandroidapp.models.Meeting
import com.lennertbontinck.carmeetsandroidapp.networks.CarmeetsApi
import com.lennertbontinck.carmeetsandroidapp.utils.MessageUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Een [InjectedViewModel] klasse die alle meetings bevat.
 */
class MeetingViewModel : InjectedViewModel() {
    /**
     * De lijst van alle meetings zoals die van de server gehaald is
     */
    private val meetingsList = MutableLiveData<List<Meeting>>()

    /**
     * Het huidige door de gebruiker geselecteerde design van lijstitems
     */
    private val listDesign = MutableLiveData<ListDesignEnum>()

    /**
     * een instantie van de carmeetsApi om data van de server op te halen
     */
    @Inject
    lateinit var carmeetsApi: CarmeetsApi

    /**
     * De subscription op het getAllMeetings verzoek
     */
    private var getAllMeetingsSubscription: Disposable

    init {
        //initieel vullen met een lege lijst zodat dit niet nul os
        meetingsList.value = emptyList()
        //initieel is layout klein
        listDesign.value = ListDesignEnum.SMALL
        getAllMeetingsSubscription = carmeetsApi.getAllMeetings()
            //we tell it to fetch the data on background by
            .subscribeOn(Schedulers.io())
            //we like the fetched data to be displayed on the MainTread (UI)
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrieveStart() }
            .doOnTerminate { onRetrieveFinish() }
            .subscribe(
                { result -> onRetrieveMeetingsSuccess(result) },
                { error -> onRetrieveError(error) }
            )
    }



    /**
     * Functie voor het behandelen van het mislukken van het ophalen van data van de server
     */
    private fun onRetrieveError(error: Throwable) {
        //voorlopig toastje zou mooier zijn als er fragment toont
        MessageUtil.showToast("Er ging iets mis met het ophalen van de data!")
    }

    /**
     * Functie voor het behandelen van het starten van een rest api call
     *
     * Zal een loading fragment tonen of dergelijke
     */
    private fun onRetrieveStart() {
        //hier begint api call
        //nog een soort loading voozien
    }

    /**
     * Functie voor het behandelen van het eindigen van een rest api call
     *
     * Sluit het loading fragment of dergelijke
     */
    private fun onRetrieveFinish() {
        //hier eindigt api call
        //de loading hier nog stoppen
    }

    /**
     * Functie voor het behandelen van het succesvol ophalen van de meetings
     *
     * Zal de lijst van meetings gelijkstellen met het results
     */
    private fun onRetrieveMeetingsSuccess(result: List<Meeting>) {
        meetingsList.value = result
    }

    /**
     * Disposed alle subscriptions wanneer de [MeetingViewModel] niet meer gebruikt wordt.
     */
    override fun onCleared() {
        super.onCleared()
        getAllMeetingsSubscription.dispose()
    }

    /**
     * returnt de lijst van alle meetings als MutableLiveData
     */
    fun getMeetings(): MutableLiveData<List<Meeting>> {
        return meetingsList
    }

    /**
     * returnt de enum van de door de gebruiker gekozen layout stijl als MutableLiveData
     */
    fun getListDesgin(): MutableLiveData<ListDesignEnum> {
        return listDesign
    }

    /**
     * stelt de door de gebruiker gekozen layout stijl in
     */
    fun setListDesign(listDesignEnum: ListDesignEnum) {
        listDesign.value = listDesignEnum
    }

}