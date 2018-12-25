package com.lennertbontinck.carmeetsandroidapp.networks

import com.lennertbontinck.carmeetsandroidapp.models.Meeting
import com.lennertbontinck.carmeetsandroidapp.networks.requests.*
import com.lennertbontinck.carmeetsandroidapp.networks.responses.TokenResponse
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * Een *interface* die de methoden voorziet om objecten van de *carmeets-backend server* te halen.
 */
interface CarmeetsApi {

    /**
     * Haal alle meetings op
     */
    //voorbeeld url: https://carmeets-backend.herokuapp.com/API/meetings/singleMeeting/5bbd254ba1468a0013f104c6
    @GET("meetings/alleMeetings")
    fun getAllMeetings(): Observable<List<Meeting>>

    /**
     * Login en return tokenresponse.
     *
     * @param loginRequest een [loginRequest] object van de gebruiker die zich wilt aanmelden.
     */
    @POST("users/login")
    fun login(@Body loginRequest: LoginRequest): Observable<TokenResponse>

    /**
     * Registreer gebruiker en return tokenresponse.
     *
     * @param registerRequest een [RegisterRequest] object van de gebruiker die zich wilt registreren.
     */
    @POST("users/registreer")
    fun register(@Body registerRequest: RegisterRequest): Observable<TokenResponse>

    /**
     * Verander het wachtwoord van de aangemelde gebruiker en return tokenresponse.
     *
     * @param changePasswordRequest een [ChangePasswordRequest] object van het nieuwe wachtwoord dat de gebruiker wilt instellen.
     */
    @POST("users/changePassword")
    fun changePassword(@Body changePasswordRequest: ChangePasswordRequest): Observable<TokenResponse>

    /**
     * Verander de gebruikersnaam van de aangemelde gebruiker en return tokenresponse.
     *
     * @param changeUsernameRequest een [ChangeUsernameRequest] object van de nieuwe gebruikersnaam dat de gebruiker wilt instellen.
     */
    @POST("users/changeUsername")
    fun changeUsername(@Body changeUsernameRequest: ChangeUsernameRequest): Observable<TokenResponse>

    /**
     * Verander het e-mailadres van de aangemelde gebruiker en return tokenresponse.
     *
     * @param changeEmailRequest een [ChangeEmailRequest] object van het nieuwe e-mailadres dat de gebruiker wilt instellen.
     */
    @POST("users/changeEmail")
    fun changeEmail(@Body changeEmailRequest: ChangeEmailRequest): Observable<TokenResponse>
}