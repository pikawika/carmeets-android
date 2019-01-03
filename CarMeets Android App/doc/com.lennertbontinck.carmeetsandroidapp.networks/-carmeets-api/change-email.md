[app](../../index.md) / [com.lennertbontinck.carmeetsandroidapp.networks](../index.md) / [CarmeetsApi](index.md) / [changeEmail](./change-email.md)

# changeEmail

`@POST("users/changeEmail") abstract fun changeEmail(@Body changeEmailRequest: `[`ChangeEmailRequest`](../../com.lennertbontinck.carmeetsandroidapp.networks.requests/-change-email-request/index.md)`): Observable<`[`TokenResponse`](../../com.lennertbontinck.carmeetsandroidapp.networks.responses/-token-response/index.md)`>`

Verander het e-mailadres van de aangemelde gebruiker en return tokenresponse.

### Parameters

`changeEmailRequest` - een [ChangeEmailRequest](../../com.lennertbontinck.carmeetsandroidapp.networks.requests/-change-email-request/index.md) object van het nieuwe e-mailadres dat de gebruiker wilt instellen.