package com.lennertbontinck.carmeetsandroidapp.networks.requests

/**
 * Een klasse die geconverteerd kan worden naar JSON. Deze klasse wordt gebruikt als data bij een LoginRequest aan de server
 */
data class RegisterRequest(
    val username : String,
    val password : String,
    val email : String

)