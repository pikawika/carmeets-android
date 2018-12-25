package com.lennertbontinck.carmeetsandroidapp.networks.requests

/**
 * Een klasse die geconverteerd kan worden naar JSON. Deze klasse wordt gebruikt als data bij een toggle going request aan de server
 */
data class ToggleGoingRequest(
    val idMeeting : String
)