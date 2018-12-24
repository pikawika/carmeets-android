package com.lennertbontinck.carmeetsandroidapp.viewmodels

import android.arch.lifecycle.MutableLiveData
import com.lennertbontinck.carmeetsandroidapp.R
import com.lennertbontinck.carmeetsandroidapp.bases.InjectedViewModel
import com.lennertbontinck.carmeetsandroidapp.context.CarMeetsApplication
import com.lennertbontinck.carmeetsandroidapp.models.Meeting
import com.lennertbontinck.carmeetsandroidapp.networks.CarmeetsApi
import com.lennertbontinck.carmeetsandroidapp.networks.responses.MessageResponse
import com.lennertbontinck.carmeetsandroidapp.utils.MessageUtil
import com.squareup.moshi.Moshi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException
import javax.inject.Inject

/**
 * Een [InjectedViewModel] klasse die alle meetings bevat.
 */
class MeetingViewModel : InjectedViewModel() {
    /**
     * De lijst van alle meetings zoals die van de server gehaald is.
     */
    val meetingList = MutableLiveData<List<Meeting>>()

    /**
     * De huidige door de gebruiker geselecteerde meeting.
     *
     * Maak gebruik van [setSelectedMeeting] voor de value in te stellen.
     */
    val selectedMeeting = MutableLiveData<Meeting>()

    /**
     * een instantie van de carmeetsApi om data van de server op te halen.
     */
    @Inject
    lateinit var carmeetsApi: CarmeetsApi

    /**
     * De subscription op het getAllMeetings verzoek.
     */
    private var getAllMeetingsSubscription: Disposable

    init {
        //initieel vullen met een lege lijst zodat dit niet nul is
        meetingList.value = emptyList()

        //alle meetings van de server halen
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
     * Functie voor het behandelen van het starten van een rest api call.
     */
    private fun onRetrieveStart() {
        //hier begint api call
        //nog een soort loading voozien
    }

    /**
     * Functie voor het behandelen van het eindigen van een rest api call.
     */
    private fun onRetrieveFinish() {
        //hier eindigt api call
        //de loading hier nog stoppen
    }

    /**
     * Functie voor het behandelen van het mislukken van het ophalen van data van de server
     */
    private fun onRetrieveError(error: Throwable) {
        //error is een http error
        if (error is HttpException) {
            //error body
            val errorJsonString = error.response().errorBody()?.string()
            if (errorJsonString != null) {
                //parse kan falen indien niet juiste format
                try {
                    //json parser indien
                    val jsonAdapter = Moshi.Builder().build().adapter<MessageResponse>(MessageResponse::class.java)
                    val messageRes = jsonAdapter.fromJson(errorJsonString)

                    //indien message van de server toon deze anders toon universeel
                    if (messageRes?.message != null) {
                        MessageUtil.showToast(messageRes.message)
                        return
                    }
                } catch (e: Throwable) {
                }

            }
            //geen server error code -> toon universele http error code
            MessageUtil.showToast(CarMeetsApplication.getContext().getString(R.string.error_httpRequest_crashed))
            return

        } else {
            //geen http error code -> toon universele error code
            MessageUtil.showToast(CarMeetsApplication.getContext().getString(R.string.error_something_crashed))
            return
        }
    }

    /**
     * Functie voor het behandelen van het succesvol ophalen van de meetings.
     *
     * Zal de lijst van meetings gelijkstellen met het results.
     */
    private fun onRetrieveMeetingsSuccess(result: List<Meeting>) {
        meetingList.value = result
    }

    /**
     * Stelt de door de gebruiker geselecteerde meeting in.
     *
     * @param meetingId : meetingId van meeting die als selected meeting moet ingesteld worden, verplicht van type [String].
     */
    fun setSelectedMeeting(meetingId: String) {
        selectedMeeting.value = meetingList.value!!.firstOrNull { it.meetingId == meetingId }
    }

    /**
     * Disposed alle subscriptions wanneer de [MeetingViewModel] niet meer gebruikt wordt.
     */
    override fun onCleared() {
        super.onCleared()
        getAllMeetingsSubscription.dispose()
    }

}