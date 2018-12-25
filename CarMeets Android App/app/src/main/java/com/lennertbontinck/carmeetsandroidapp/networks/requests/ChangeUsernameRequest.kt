package com.lennertbontinck.carmeetsandroidapp.networks.requests

/**
 * Een klasse die geconverteerd kan worden naar JSON. Deze klasse wordt gebruikt als data bij een change username request aan de server
 */
data class ChangeUsernameRequest(
    val newUsername : String
)