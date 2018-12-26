package com.lennertbontinck.carmeetsandroidapp.viewmodels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.lennertbontinck.carmeetsandroidapp.R
import com.lennertbontinck.carmeetsandroidapp.bases.InjectedViewModel
import com.lennertbontinck.carmeetsandroidapp.context.CarMeetsApplication
import com.lennertbontinck.carmeetsandroidapp.roomdatabase.MeetingRepository
import com.lennertbontinck.carmeetsandroidapp.models.Meeting
import com.lennertbontinck.carmeetsandroidapp.models.MeetingWithUserInfo
import com.lennertbontinck.carmeetsandroidapp.networks.CarmeetsApi
import com.lennertbontinck.carmeetsandroidapp.networks.requests.ToggleGoingRequest
import com.lennertbontinck.carmeetsandroidapp.networks.requests.ToggleLikedRequest
import com.lennertbontinck.carmeetsandroidapp.networks.responses.MessageResponse
import com.lennertbontinck.carmeetsandroidapp.utils.MessageUtil
import com.lennertbontinck.carmeetsandroidapp.utils.TokenUtil
import com.squareup.moshi.Moshi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.doAsync
import retrofit2.HttpException
import java.util.*
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
    val selectedMeeting = MutableLiveData<MeetingWithUserInfo>()

    /**
     * Een instantie van de carmeetsApi om data van de server op te halen.
     */
    @Inject
    lateinit var carmeetsApi: CarmeetsApi

    /**
     * Bool of optie voor items uit lokale room database weer te geven al dan niet zichtbaar is
     */
    val isShowRoomItemsVisible = MutableLiveData<Boolean>()

    /**
     * De lijst van alle meetings zoals die uit de lokale room database is gehaald.
     */
    val roomMeetingList: LiveData<List<Meeting>>

    /**
     * Bool of de lokale room database al dan niet is ingesteld als databron
     */
    val isLocalRoomDatabaseUsedAsSource = MutableLiveData<Boolean>()

    /**
     * De [MeetingRepository] gebruikt voor het ophalen van de meetings uit de lokale databank
     */
    @Inject
    lateinit var meetingRepository: MeetingRepository

    /**
     * De subscription op het getAllMeetings verzoek.
     */
    private var getAllMeetingsSubscription: Disposable

    /**
     * De subscription op het toggle liked verzoek.
     */
    private lateinit var toggleLikedSubscription: Disposable

    /**
     * De subscription op het toggle going verzoek.
     */
    private lateinit var toggleGoingSubscription: Disposable

    init {
        //initieel vullen met een lege lijst zodat dit niet nul is
        meetingList.value = emptyList()

        roomMeetingList = meetingRepository.meetings

        isLocalRoomDatabaseUsedAsSource.value = false

        isShowRoomItemsVisible.value = false

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
                { error -> onRetrieveError(error, true) }
            )
    }

    /**
     * Return de meetings waarvoor de huidige gebruiker liked of going heeft ingesteld
     */
    fun getFavouritesList(): List<Meeting> {
        return meetingList.value!!.filter {
            it.listUsersGoing.contains(getUserId()) || it.listUsersLiked.contains(
                getUserId()
            )
        }
    }

    /**
     * Haalt de meetings opnieuw op van de server en stelt de lijst opnieuw gelijk
     */
    fun refreshMeetingList() {
        //alle meetings van de server halen
        getAllMeetingsSubscription = carmeetsApi.getAllMeetings()
            //we tell it to fetch the data on background by
            .subscribeOn(Schedulers.io())
            //we like the fetched data to be displayed on the MainTread (UI)
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrieveStart() }
            .doOnTerminate { onRetrieveFinish() }
            .subscribe(
                { result -> onRetrieveMeetingsRefreshSuccess(result) },
                { error -> onRetrieveError(error, true) }
            )
    }

    /**
     * toggled liked voor de huidig geselecteerde meeting
     */
    fun toggleLiked() {
        toggleLikedSubscription = carmeetsApi.toggleLiked(ToggleLikedRequest(selectedMeeting.value!!.meetingId))
            //we tell it to fetch the data on background by
            .subscribeOn(Schedulers.io())
            //we like the fetched data to be displayed on the MainTread (UI)
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrieveStart() }
            .doOnTerminate { onRetrieveFinish() }
            .subscribe(
                { _ -> onRetrieveToggleLikedSuccess() },
                { error -> onRetrieveError(error) }
            )
    }

    /**
     * toggled going voor de huidig geselecteerde meeting
     */
    fun toggleGoing() {
        toggleGoingSubscription = carmeetsApi.toggleGoing(ToggleGoingRequest(selectedMeeting.value!!.meetingId))
            //we tell it to fetch the data on background by
            .subscribeOn(Schedulers.io())
            //we like the fetched data to be displayed on the MainTread (UI)
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrieveStart() }
            .doOnTerminate { onRetrieveFinish() }
            .subscribe(
                { _ -> onRetrieveToggleGoingSuccess() },
                { error -> onRetrieveError(error) }
            )
    }

    /**
     * Return aantal meetings waarvoor de huidige gebruiker liked of going heeft ingesteld in de komende 7 dagen
     */
    fun getLikedGoingAmountNext7Days(): Int {
        val dateInAWeek = Calendar.getInstance()
        dateInAWeek.add(Calendar.DAY_OF_YEAR, 7)
        return meetingList.value!!.asSequence().filter {
            (it.listUsersGoing.contains(getUserId()) || it.listUsersLiked.contains(getUserId()))
                    && it.date <= dateInAWeek.time
        }.count()
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
     *
     * @param error : de verkregeen error. Required of type [Throwable].
     *
     * @param showCachedOptionOnFail : of bij het falen de optie voor het ophalen van de cached meetings
     * aan de gebruiker moet worden voorgesteld
     */
    private fun onRetrieveError(error: Throwable, showCachedOptionOnFail: Boolean = false) {
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
            isShowRoomItemsVisible.value = showCachedOptionOnFail
            MessageUtil.showToast(CarMeetsApplication.getContext().getString(R.string.error_httpRequest_crashed))
            return

        } else {
            //geen http error code -> toon universele error code
            isShowRoomItemsVisible.value = showCachedOptionOnFail
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
        isShowRoomItemsVisible.value = false
        doAsync { meetingRepository.insert(result) }
    }

    /**
     * Functie voor het behandelen van het succesvol ophalen van de meetings *(bij refresh)*.
     *
     * Zal de lijst van meetings gelijkstellen met het results.
     */
    private fun onRetrieveMeetingsRefreshSuccess(result: List<Meeting>) {
        meetingList.value = result
        refreshSelectedMeeting()
    }

    /**
     * Functie voor het behandelen van het succesvol wijzigen van een liked status.
     *
     *
     */
    private fun onRetrieveToggleLikedSuccess() {
        refreshMeetingList()
    }

    /**
     * Functie voor het behandelen van het succesvol wijzigen van een going status.
     *
     *
     */
    private fun onRetrieveToggleGoingSuccess() {
        refreshMeetingList()
    }

    /**
     * Stelt de door de gebruiker geselecteerde meeting in.
     *
     * @param meetingId : meetingId van meeting die als selected meeting moet ingesteld worden, verplicht van type [String].
     */
    fun setSelectedMeeting(meetingId: String) {
        val selectedMeeting = meetingList.value!!.firstOrNull { it.meetingId == meetingId }
        if (selectedMeeting != null) {
            this.selectedMeeting.value = MeetingWithUserInfo(
                meetingId = selectedMeeting.meetingId,
                categories = selectedMeeting.categories,
                date = selectedMeeting.date,
                description = selectedMeeting.description,
                imageName = selectedMeeting.imageName,
                listUsersGoing = selectedMeeting.listUsersGoing,
                listUsersLiked = selectedMeeting.listUsersLiked,
                location = selectedMeeting.location,
                subtitle = selectedMeeting.subtitle,
                title = selectedMeeting.title,
                website = selectedMeeting.website,
                isUserGoing = (selectedMeeting.listUsersGoing.contains(getUserId())),
                isUserLiked = (selectedMeeting.listUsersLiked.contains(getUserId()))
            )
        }
    }

    private fun refreshSelectedMeeting() {
        if (this.selectedMeeting.value != null) {
            val selectedMeeting =
                meetingList.value!!.firstOrNull { it.meetingId == this.selectedMeeting.value!!.meetingId }
            if (selectedMeeting != null) {
                this.selectedMeeting.value = MeetingWithUserInfo(
                    meetingId = selectedMeeting.meetingId,
                    categories = selectedMeeting.categories,
                    date = selectedMeeting.date,
                    description = selectedMeeting.description,
                    imageName = selectedMeeting.imageName,
                    listUsersGoing = selectedMeeting.listUsersGoing,
                    listUsersLiked = selectedMeeting.listUsersLiked,
                    location = selectedMeeting.location,
                    subtitle = selectedMeeting.subtitle,
                    title = selectedMeeting.title,
                    website = selectedMeeting.website,
                    isUserGoing = (selectedMeeting.listUsersGoing.contains(getUserId())),
                    isUserLiked = (selectedMeeting.listUsersLiked.contains(getUserId()))
                )
            }
        }
    }

    private fun getUserId(): String {
        val tokenContent = TokenUtil.getTokenContent()

        //indien niet aangemeld onmogelijke id returnen
        return tokenContent?._id ?: "-1"
    }

    /**
     * Disposed alle subscriptions wanneer de [MeetingViewModel] niet meer gebruikt wordt.
     */
    override fun onCleared() {
        super.onCleared()
        getAllMeetingsSubscription.dispose()

        if (::toggleGoingSubscription.isInitialized) {
            toggleGoingSubscription.dispose()
        }

        if (::toggleLikedSubscription.isInitialized) {
            toggleLikedSubscription.dispose()
        }
    }
}