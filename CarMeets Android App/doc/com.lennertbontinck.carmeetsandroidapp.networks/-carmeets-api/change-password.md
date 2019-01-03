[app](../../index.md) / [com.lennertbontinck.carmeetsandroidapp.networks](../index.md) / [CarmeetsApi](index.md) / [changePassword](./change-password.md)

# changePassword

`@POST("users/changePassword") abstract fun changePassword(@Body changePasswordRequest: `[`ChangePasswordRequest`](../../com.lennertbontinck.carmeetsandroidapp.networks.requests/-change-password-request/index.md)`): Observable<`[`TokenResponse`](../../com.lennertbontinck.carmeetsandroidapp.networks.responses/-token-response/index.md)`>`

Verander het wachtwoord van de aangemelde gebruiker en return tokenresponse.

### Parameters

`changePasswordRequest` - een [ChangePasswordRequest](../../com.lennertbontinck.carmeetsandroidapp.networks.requests/-change-password-request/index.md) object van het nieuwe wachtwoord dat de gebruiker wilt instellen.