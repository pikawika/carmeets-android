package com.lennertbontinck.carmeetsandroidapp.models

/**
 * Een Data [Class] die de informatie van een token bevat.
 */
data class TokenContent(
    val _id : String,
    val username : String,
    val role : String
)