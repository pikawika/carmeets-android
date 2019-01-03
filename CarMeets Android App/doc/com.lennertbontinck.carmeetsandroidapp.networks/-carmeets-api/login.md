[app](../../index.md) / [com.lennertbontinck.carmeetsandroidapp.networks](../index.md) / [CarmeetsApi](index.md) / [login](./login.md)

# login

`@POST("users/login") abstract fun login(@Body loginRequest: `[`LoginRequest`](../../com.lennertbontinck.carmeetsandroidapp.networks.requests/-login-request/index.md)`): Observable<`[`TokenResponse`](../../com.lennertbontinck.carmeetsandroidapp.networks.responses/-token-response/index.md)`>`

Login en return tokenresponse.

### Parameters

`loginRequest` - een [loginRequest](login.md#com.lennertbontinck.carmeetsandroidapp.networks.CarmeetsApi$login(com.lennertbontinck.carmeetsandroidapp.networks.requests.LoginRequest)/loginRequest) object van de gebruiker die zich wilt aanmelden.