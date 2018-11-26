package com.lennertbontinck.carmeetsandroidapp.network

import com.lennertbontinck.carmeetsandroidapp.models.Meeting
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Een *interface* die de methoden voorziet om objecten van de *carmeets-backend server* te halen.
 */
interface CarmeetsApi {

    /**
     * Haal alle meetings op
     *
     * @param id
     */
    //voorbeeld url: https://carmeets-backend.herokuapp.com/API/meetings/singleMeeting/5bbd254ba1468a0013f104c6
    @GET("/API/meetings/alleMeetings")
    fun getAllMeetings(): Observable<List<Meeting>>
}