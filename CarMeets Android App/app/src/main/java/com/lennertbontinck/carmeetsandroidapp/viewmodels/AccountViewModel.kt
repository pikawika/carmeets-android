package com.lennertbontinck.carmeetsandroidapp.viewmodels

import android.arch.lifecycle.MutableLiveData
import com.lennertbontinck.carmeetsandroidapp.R
import com.lennertbontinck.carmeetsandroidapp.bases.InjectedViewModel
import com.lennertbontinck.carmeetsandroidapp.context.CarMeetsApplication
import com.lennertbontinck.carmeetsandroidapp.networks.CarmeetsApi
import com.lennertbontinck.carmeetsandroidapp.networks.requests.*
import com.lennertbontinck.carmeetsandroidapp.networks.responses.MessageResponse
import com.lennertbontinck.carmeetsandroidapp.networks.responses.TokenResponse
import com.lennertbontinck.carmeetsandroidapp.utils.MessageUtil
import com.lennertbontinck.carmeetsandroidapp.utils.PreferenceUtil
import com.lennertbontinck.carmeetsandroidapp.utils.TokenUtil
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
    val username = MutableLiveData<String>()

    /**
     * De userId van de aangemelde user
     */
    private val userId = MutableLiveData<String>()

    /**
     * Bool of user al dan niet aangemeld is
     */
    val isLoggedIn = MutableLiveData<Boolean>()

    /**
     * Bool of loading fragment al dan niet zichtbaar is.
     */
    val isLoadingPageVisible = MutableLiveData<Boolean>()

    /**
     * De subscription voor het login verzoek
     */
    private lateinit var loginSubscription: Disposable

    /**
     * De subscription voor het registreer verzoek
     */
    private lateinit var registerSubscription: Disposable

    /**
     * De subscription voor het wijzig wachtwoord verzoek
     */
    private lateinit var changePasswordSubscription: Disposable

    /**
     * De subscription voor het wijzig gebruikersnaam verzoek
     */
    private lateinit var changeUsernameSubscription: Disposable

    /**
     * De subscription voor het wijzig e-mailadres verzoek
     */
    private lateinit var changeEmailSubscription: Disposable

    init {
        isLoggedIn.value = PreferenceUtil.getToken() != ""
        isLoadingPageVisible.value = false
        tokenContentToViewModel()
    }

    /**
     * Logt de gebruiker in en returnt token
     *
     * @param username : gebruikersnaam. Required of type [String].
     *
     * @param password : wachtwoord. Required of type [String].
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
                { result -> onRetrieveLoginSuccess(result) },
                { error -> onRetrieveError(error) }
            )
    }

    /**
     * Registreert de gebruiker en returnt of al dan niet gelukt
     *
     * @param email : email te registreren gebruiker. Required of type [String].
     *
     * @param username : gebruikersnaam te registreren gebruiker. Required of type [String].
     *
     * @param password : wachtwoord te registreren gebruiker. Required of type [String].
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
                { result -> onRetrieveRegisterSuccess(result) },
                { error -> onRetrieveError(error) }
            )
    }

    /**
     * Veranderd het password van de gebruiker
     *
     * @param newPassword : nieuwe wachtwoord. Required of type [String].
     */
    fun changePassword(newPassword: String) {
        changePasswordSubscription = carmeetsApi.changePassword(ChangePasswordRequest(newPassword))
            //we tell it to fetch the data on background by
            .subscribeOn(Schedulers.io())
            //we like the fetched data to be displayed on the MainTread (UI)
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrieveStart() }
            .doOnTerminate { onRetrieveFinish() }
            .subscribe(
                { result -> onRetrieveChangePasswordSuccess(result) },
                { error -> onRetrieveError(error) }
            )
    }

    /**
     * Veranderd de gebruikersnaam van de gebruiker
     *
     * @param newUsername : nieuwe gebruikersnaam. Required of type [String].
     */
    fun changeUsername(newUsername: String) {
        changePasswordSubscription = carmeetsApi.changeUsername(ChangeUsernameRequest(newUsername))
            //we tell it to fetch the data on background by
            .subscribeOn(Schedulers.io())
            //we like the fetched data to be displayed on the MainTread (UI)
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrieveStart() }
            .doOnTerminate { onRetrieveFinish() }
            .subscribe(
                { result -> onRetrieveChangeUsernameSuccess(result) },
                { error -> onRetrieveError(error) }
            )
    }

    /**
     * Veranderd het e-mailadres van de gebruiker
     *
     * @param newEmail : nieuw e-mailadres. Required of type [String].
     */
    fun changeEmail(newEmail: String) {
        changePasswordSubscription = carmeetsApi.changeEmail(ChangeEmailRequest(newEmail))
            //we tell it to fetch the data on background by
            .subscribeOn(Schedulers.io())
            //we like the fetched data to be displayed on the MainTread (UI)
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrieveStart() }
            .doOnTerminate { onRetrieveFinish() }
            .subscribe(
                { result -> onRetrieveChangeEmailSuccess(result) },
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
        isLoadingPageVisible.value = true
    }

    /**
     * Functie voor het behandelen van het eindigen van een rest api call
     */
    private fun onRetrieveFinish() {
        isLoadingPageVisible.value = false
    }

    /**
     * Functie voor het behandelen van het mislukken van het ophalen van data van de server
     *
     * @param error : de verkregeen error. Required of type [Throwable].
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
            //geen http error code, kijken of door geen internet anders universele error
            if (error.cause.toString() == "android.system.GaiException: android_getaddrinfo failed: EAI_NODATA (No address associated with hostname)")
                MessageUtil.showToast(CarMeetsApplication.getContext().getString(R.string.error_dns_server_not_avaible))
            else
                MessageUtil.showToast(CarMeetsApplication.getContext().getString(R.string.error_something_crashed))
            return
        }
    }

    /**
     * Functie voor het behandelen van het succesvol aanmelden
     *
     * zal token instellen en opslaan, en isLoggedIn in de VM op true zetten
     *
     * @param result : de response van de server. Required of type [TokenResponse].
     */
    private fun onRetrieveLoginSuccess(result: TokenResponse) {
        PreferenceUtil.setToken(result.token)
        isLoggedIn.value = true
        tokenContentToViewModel()
    }

    /**
     * Functie voor het behandelen van het succesvol registreren
     *
     * @param result : de response van de server. Required of type [TokenResponse].
     */
    private fun onRetrieveRegisterSuccess(result: TokenResponse) {
        PreferenceUtil.setToken(result.token)
        isLoggedIn.value = true
        tokenContentToViewModel()
    }

    /**
     * Functie voor het behandelen van het succesvol wijzigen van het wachtwoord
     *
     * zal token instellen en opslaan
     *
     * @param result : de response van de server. Required of type [TokenResponse].
     */
    private fun onRetrieveChangePasswordSuccess(result: TokenResponse) {
        PreferenceUtil.setToken(result.token)
        tokenContentToViewModel()
        MessageUtil.showToast(CarMeetsApplication.getContext().getString(R.string.notification_password_change_success))
    }

    /**
     * Functie voor het behandelen van het succesvol wijzigen van de gebruikersnaam
     *
     * zal token instellen en opslaan
     *
     * @param result : de response van de server. Required of type [TokenResponse].
     */
    private fun onRetrieveChangeUsernameSuccess(result: TokenResponse) {
        PreferenceUtil.setToken(result.token)
        tokenContentToViewModel()
        MessageUtil.showToast(CarMeetsApplication.getContext().getString(R.string.notification_username_change_success))

    }

    /**
     * Functie voor het behandelen van het succesvol wijzigen van de gebruikersnaam
     *
     * zal token instellen en opslaan
     *
     * @param result : de response van de server. Required of type [TokenResponse].
     */
    private fun onRetrieveChangeEmailSuccess(result: TokenResponse) {
        PreferenceUtil.setToken(result.token)
        MessageUtil.showToast(CarMeetsApplication.getContext().getString(R.string.notification_email_change_success))
    }

    /**
     * Stelt de info uit de token in op deze viewmodel:
     * - [username]
     * - [userId]
     */
    private fun tokenContentToViewModel() {
        val tokenContent = TokenUtil.getTokenContent()

        if (tokenContent != null) {
            username.value = tokenContent.username
            userId.value = tokenContent._id
        }
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
        if (::changePasswordSubscription.isInitialized) {
            changePasswordSubscription.dispose()
        }
        if (::changeUsernameSubscription.isInitialized) {
            changeUsernameSubscription.dispose()
        }
        if (::changeEmailSubscription.isInitialized) {
            changeEmailSubscription.dispose()
        }
    }
}