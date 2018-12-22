package com.lennertbontinck.carmeetsandroidapp.networks.responses

/**
 * Een klasse die van JSON extracted kan worden. Deze klasse wordt gebruikt als de server een token antwoord.
 */
data class TokenResponse(
    val token: String
)