package com.lennertbontinck.carmeetsandroidapp.networks.requests

/**
 * Een klasse die geconverteerd kan worden naar JSON. Deze klasse wordt gebruikt als data bij een change password request aan de server
 */
data class ChangePasswordRequest(
    val newPassword : String
)