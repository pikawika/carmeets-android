[app](../../index.md) / [com.lennertbontinck.carmeetsandroidapp.viewmodels](../index.md) / [AccountViewModel](index.md) / [onRetrieveLoginSuccess](./on-retrieve-login-success.md)

# onRetrieveLoginSuccess

`private fun onRetrieveLoginSuccess(result: `[`TokenResponse`](../../com.lennertbontinck.carmeetsandroidapp.networks.responses/-token-response/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Functie voor het behandelen van het succesvol aanmelden

zal token instellen en opslaan, en isLoggedIn in de VM op true zetten

### Parameters

`result` - : de response van de server. Required of type [TokenResponse](../../com.lennertbontinck.carmeetsandroidapp.networks.responses/-token-response/index.md).