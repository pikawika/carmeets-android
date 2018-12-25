package com.lennertbontinck.carmeetsandroidapp.networks.requests

/**
 * Een klasse die geconverteerd kan worden naar JSON. Deze klasse wordt gebruikt als data bij een toggle like request aan de server
 */
data class ToggleLikedRequest(
    val idMeeting : String
)