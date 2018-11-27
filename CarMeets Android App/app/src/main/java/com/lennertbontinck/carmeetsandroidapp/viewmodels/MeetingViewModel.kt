package com.lennertbontinck.carmeetsandroidapp.viewmodels

import android.arch.lifecycle.MutableLiveData
import com.lennertbontinck.carmeetsandroidapp.bases.InjectedViewModel
import com.lennertbontinck.carmeetsandroidapp.enums.LijstDesignEnum
import com.lennertbontinck.carmeetsandroidapp.models.Meeting
import com.lennertbontinck.carmeetsandroidapp.networks.CarmeetsApi
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
    private val meetingsLijst = MutableLiveData<List<Meeting>>()

    /**
     * Het huidige door de gebruiker geselecteerde design van lijstitems
     */
    private val lijstDesign = MutableLiveData<LijstDesignEnum>()

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
        meetingsLijst.value = emptyList()
        //initieel is layout klein
        lijstDesign.value = LijstDesignEnum.KLEIN
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
        //voorlopig harde crash, niet goed want throwt dus bij gewoon geen internet etc
        throw Exception(error.message)
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
        meetingsLijst.value = result
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
        return meetingsLijst
    }

    /**
     * returnt de enum van de door de gebruiker gekozen layout stijl als MutableLiveData
     */
    fun getLijstDesgin(): MutableLiveData<LijstDesignEnum> {
        return lijstDesign
    }

    /**
     * stelt de door de gebruiker gekozen layout stijl in
     */
    fun setLijstDesign(lijstDesignEnum: LijstDesignEnum) {
        lijstDesign.value = lijstDesignEnum
    }

}