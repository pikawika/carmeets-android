[app](../../index.md) / [com.lennertbontinck.carmeetsandroidapp.networks](../index.md) / [CarmeetsApi](index.md) / [changeUsername](./change-username.md)

# changeUsername

`@POST("users/changeUsername") abstract fun changeUsername(@Body changeUsernameRequest: `[`ChangeUsernameRequest`](../../com.lennertbontinck.carmeetsandroidapp.networks.requests/-change-username-request/index.md)`): Observable<`[`TokenResponse`](../../com.lennertbontinck.carmeetsandroidapp.networks.responses/-token-response/index.md)`>`

Verander de gebruikersnaam van de aangemelde gebruiker en return tokenresponse.

### Parameters

`changeUsernameRequest` - een [ChangeUsernameRequest](../../com.lennertbontinck.carmeetsandroidapp.networks.requests/-change-username-request/index.md) object van de nieuwe gebruikersnaam dat de gebruiker wilt instellen.