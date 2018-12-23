package com.lennertbontinck.carmeetsandroidapp.viewmodels

import android.arch.lifecycle.MutableLiveData
import com.lennertbontinck.carmeetsandroidapp.R
import com.lennertbontinck.carmeetsandroidapp.bases.InjectedViewModel
import com.lennertbontinck.carmeetsandroidapp.context.CarMeetsApplication
import com.lennertbontinck.carmeetsandroidapp.networks.CarmeetsApi
import com.lennertbontinck.carmeetsandroidapp.networks.requests.LoginRequest
import com.lennertbontinck.carmeetsandroidapp.networks.requests.RegisterRequest
import com.lennertbontinck.carmeetsandroidapp.networks.responses.MessageResponse
import com.lennertbontinck.carmeetsandroidapp.networks.responses.TokenResponse
import com.lennertbontinck.carmeetsandroidapp.utils.MessageUtil
import com.lennertbontinck.carmeetsandroidapp.utils.PreferenceUtil
import com.squareup.moshi.Moshi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException
import javax.inject.Inject

/**
 * Een [InjectedViewModel] klasse die alle info over de aangemelde gebruiker bevat.
 */
class AccountViewModel : InjectedViewModel() {
    /**
     * een instantie van de [CarmeetsApi] om data van de server op te halen
     */
    @Inject
    lateinit var carmeetsApi: CarmeetsApi

    /**
     * De gebruikersnaam van de aangemelde user
     */
    var username = MutableLiveData<String>()
        private set

    /**
     * Bool of user al dan niet aangemeld is
     */
    var isLoggedIn = MutableLiveData<Boolean>()
        private set

    /**
     * De subscription voor het login verzoek
     */
    private lateinit var loginSubscription: Disposable

    /**
     * De subscription voor het registreer verzoek
     */
    private lateinit var registerSubscription: Disposable

    init {
        username.value = PreferenceUtil.getUsername()
        isLoggedIn.value = PreferenceUtil.getToken() != ""
    }

    /**
     * Logt de gebruiker in en returnt token
     */
    fun login(username: String, password: String) {
        loginSubscription = carmeetsApi.login(LoginRequest(username, password))
            //we tell it to fetch the data on background by
            .subscribeOn(Schedulers.io())
            //we like the fetched data to be displayed on the MainTread (UI)
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrieveStart() }
            .doOnTerminate { onRetrieveFinish() }
            .subscribe(
                { result -> onRetrieveLoginSuccess(result, username) },
                { error -> onRetrieveError(error) }
            )
    }

    /**
     * Registreert de gebruiker en returnt of al dan niet gelukt
     */
    fun register(email: String, username: String, password: String) {
        val registerRequest = RegisterRequest(username, password, email)
        registerSubscription = carmeetsApi.register(registerRequest)
            //we tell it to fetch the data on background by
            .subscribeOn(Schedulers.io())
            //we like the fetched data to be displayed on the MainTread (UI)
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrieveStart() }
            .doOnTerminate { onRetrieveFinish() }
            .subscribe(
                { result -> onRetrieveRegisterSuccess(result, username) },
                { error -> onRetrieveError(error) }
            )
    }

    /**
     * meld af door de shared preferences te verwijderen en isLoggedIn te veranderen
     */
    fun logout() {
        PreferenceUtil.deletePreferences()
        isLoggedIn.value = false
    }

    /**
     * Functie voor het behandelen van het starten van een rest api call
     */
    private fun onRetrieveStart() {
        //hier begint api call
        //nog een soort loading voozien
    }

    /**
     * Functie voor het behandelen van het eindigen van een rest api call
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
            //json parser indien
            val jsonAdapter = Moshi.Builder().build().adapter<MessageResponse>(MessageResponse::class.java)
            val messageRes = jsonAdapter.fromJson(errorJsonString)

            //indien message van de server toon deze anders toon universeel
            if (messageRes?.message != null) {
                MessageUtil.showToast(messageRes.message)
                return
            } else {
                MessageUtil.showToast(CarMeetsApplication.getContext().getString(R.string.error_httpRequest_crashed))
                return
            }
        } else {
            MessageUtil.showToast(CarMeetsApplication.getContext().getString(R.string.error_something_crashed))
            return
        }

    }

    /**
     * Functie voor het behandelen van het succesvol aanmelden
     *
     * zal token instellen en opslaan, en isLoggedIn in de VM op true zetten
     */
    private fun onRetrieveLoginSuccess(result: TokenResponse, username: String) {
        PreferenceUtil.setToken(result.token)
        isLoggedIn.value = true
        this.username.value = username
        PreferenceUtil.setUsername(username)
    }

    /**
     * Functie voor het behandelen van het succesvol registreren
     *
     * zal token instellen en opslaan, en isLoggedIn in de VM op true zetten
     */
    private fun onRetrieveRegisterSuccess(result: TokenResponse, username: String) {
        PreferenceUtil.setToken(result.token)
        isLoggedIn.value = true
        this.username.value = username
        PreferenceUtil.setUsername(username)
    }

    /**
     * Disposed alle subscriptions wanneer de [AccountViewModel] niet meer gebruikt wordt.
     */
    override fun onCleared() {
        super.onCleared()
        if (::loginSubscription.isInitialized) {
            loginSubscription.dispose()
        }
        if (::registerSubscription.isInitialized) {
            registerSubscription.dispose()
        }
    }
}