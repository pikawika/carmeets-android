[app](../../index.md) / [com.lennertbontinck.carmeetsandroidapp.networks](../index.md) / [CarmeetsApi](index.md) / [register](./register.md)

# register

`@POST("users/registreer") abstract fun register(@Body registerRequest: `[`RegisterRequest`](../../com.lennertbontinck.carmeetsandroidapp.networks.requests/-register-request/index.md)`): Observable<`[`TokenResponse`](../../com.lennertbontinck.carmeetsandroidapp.networks.responses/-token-response/index.md)`>`

Registreer gebruiker en return tokenresponse.

### Parameters

`registerRequest` - een [RegisterRequest](../../com.lennertbontinck.carmeetsandroidapp.networks.requests/-register-request/index.md) object van de gebruiker die zich wilt registreren.