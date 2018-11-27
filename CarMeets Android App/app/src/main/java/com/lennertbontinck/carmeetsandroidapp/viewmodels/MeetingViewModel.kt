package com.lennertbontinck.carmeetsandroidapp.viewmodels

import android.arch.lifecycle.MutableLiveData
import com.lennertbontinck.carmeetsandroidapp.bases.InjectedViewModel
import com.lennertbontinck.carmeetsandroidapp.models.Meeting
import com.lennertbontinck.carmeetsandroidapp.networks.CarmeetsApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Een [InjectedViewModel] klasse die alle meetings bevat.
 */
class MeetingViewModel() : InjectedViewModel() {

    private val meetingsLijst = MutableLiveData<List<Meeting>>()

    /**
     * The instance of the MetarApi class
     * to get back the results of the API
     */
    @Inject
    lateinit var carmeetsApi: CarmeetsApi

    /**
     * Represents a disposable resources
     */
    private var subscription: Disposable

    init {
        meetingsLijst.value = emptyList()
        subscription = carmeetsApi.getAllMeetings()
            //we tell it to fetch the data on background by
            .subscribeOn(Schedulers.io())
            //we like the fetched data to be displayed on the MainTread (UI)
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrieveMeetingsStart() }
            .doOnTerminate { onRetrieveMeetingsFinish() }
            .subscribe(
                { result -> onRetrieveMeetingsSuccess(result) },
                { error -> onRetrieveMeetingsError(error) }
            )

    }

    private fun onRetrieveMeetingsError(error: Throwable) {
        //Currently requests fail silently, which isn't great for the user.
        //It would be better to show a Toast, or maybe make a TextView visible with the error message.

        throw Exception("onRetrieveMetarError")
    }

    private fun onRetrieveMeetingsSuccess(result: List<Meeting>) {
        meetingsLijst.value = result
    }

    private fun onRetrieveMeetingsFinish() {
        //hier eindigt api call
    }

    private fun onRetrieveMeetingsStart() {
        //hier begint api call
    }

    /**
     * Disposes the subscription when the [InjectedViewModel] is no longer used.
     */
    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    fun getMeetings(): MutableLiveData<List<Meeting>> {
        return meetingsLijst
    }

}