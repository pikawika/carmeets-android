[app](../../index.md) / [com.lennertbontinck.carmeetsandroidapp.viewmodels](../index.md) / [AccountViewModel](./index.md)

# AccountViewModel

`class AccountViewModel : `[`InjectedViewModel`](../../com.lennertbontinck.carmeetsandroidapp.bases/-injected-view-model/index.md)

Een [InjectedViewModel](../../com.lennertbontinck.carmeetsandroidapp.bases/-injected-view-model/index.md) klasse die alle info over de aangemelde gebruiker bevat.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `AccountViewModel()`<br>Een [InjectedViewModel](../../com.lennertbontinck.carmeetsandroidapp.bases/-injected-view-model/index.md) klasse die alle info over de aangemelde gebruiker bevat. |

### Properties

| Name | Summary |
|---|---|
| [carmeetsApi](carmeets-api.md) | `lateinit var carmeetsApi: `[`CarmeetsApi`](../../com.lennertbontinck.carmeetsandroidapp.networks/-carmeets-api/index.md)<br>een instantie van de [CarmeetsApi](../../com.lennertbontinck.carmeetsandroidapp.networks/-carmeets-api/index.md) om data van de server op te halen |
| [changeEmailSubscription](change-email-subscription.md) | `lateinit var changeEmailSubscription: Disposable`<br>De subscription voor het wijzig e-mailadres verzoek |
| [changePasswordSubscription](change-password-subscription.md) | `lateinit var changePasswordSubscription: Disposable`<br>De subscription voor het wijzig wachtwoord verzoek |
| [changeUsernameSubscription](change-username-subscription.md) | `lateinit var changeUsernameSubscription: Disposable`<br>De subscription voor het wijzig gebruikersnaam verzoek |
| [isLoadingPageVisible](is-loading-page-visible.md) | `val isLoadingPageVisible: MutableLiveData<`[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`>`<br>Bool of loading fragment al dan niet zichtbaar is. |
| [isLoggedIn](is-logged-in.md) | `val isLoggedIn: MutableLiveData<`[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`>`<br>Bool of user al dan niet aangemeld is |
| [loginSubscription](login-subscription.md) | `lateinit var loginSubscription: Disposable`<br>De subscription voor het login verzoek |
| [registerSubscription](register-subscription.md) | `lateinit var registerSubscription: Disposable`<br>De subscription voor het registreer verzoek |
| [userId](user-id.md) | `val userId: MutableLiveData<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>`<br>De userId van de aangemelde user |
| [username](username.md) | `val username: MutableLiveData<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>`<br>De gebruikersnaam van de aangemelde user |

### Functions

| Name | Summary |
|---|---|
| [changeEmail](change-email.md) | `fun changeEmail(newEmail: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Veranderd het e-mailadres van de gebruiker |
| [changePassword](change-password.md) | `fun changePassword(newPassword: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Veranderd het password van de gebruiker |
| [changeUsername](change-username.md) | `fun changeUsername(newUsername: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Veranderd de gebruikersnaam van de gebruiker |
| [login](login.md) | `fun login(username: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, password: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Logt de gebruiker in en returnt token |
| [logout](logout.md) | `fun logout(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>meld af door de shared preferences te verwijderen en isLoggedIn te veranderen |
| [onCleared](on-cleared.md) | `fun onCleared(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Disposed alle subscriptions wanneer de [AccountViewModel](./index.md) niet meer gebruikt wordt. |
| [onRetrieveChangeEmailSuccess](on-retrieve-change-email-success.md) | `fun onRetrieveChangeEmailSuccess(result: `[`TokenResponse`](../../com.lennertbontinck.carmeetsandroidapp.networks.responses/-token-response/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Functie voor het behandelen van het succesvol wijzigen van de gebruikersnaam |
| [onRetrieveChangePasswordSuccess](on-retrieve-change-password-success.md) | `fun onRetrieveChangePasswordSuccess(result: `[`TokenResponse`](../../com.lennertbontinck.carmeetsandroidapp.networks.responses/-token-response/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Functie voor het behandelen van het succesvol wijzigen van het wachtwoord |
| [onRetrieveChangeUsernameSuccess](on-retrieve-change-username-success.md) | `fun onRetrieveChangeUsernameSuccess(result: `[`TokenResponse`](../../com.lennertbontinck.carmeetsandroidapp.networks.responses/-token-response/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Functie voor het behandelen van het succesvol wijzigen van de gebruikersnaam |
| [onRetrieveError](on-retrieve-error.md) | `fun onRetrieveError(error: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Functie voor het behandelen van het mislukken van het ophalen van data van de server |
| [onRetrieveFinish](on-retrieve-finish.md) | `fun onRetrieveFinish(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Functie voor het behandelen van het eindigen van een rest api call |
| [onRetrieveLoginSuccess](on-retrieve-login-success.md) | `fun onRetrieveLoginSuccess(result: `[`TokenResponse`](../../com.lennertbontinck.carmeetsandroidapp.networks.responses/-token-response/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Functie voor het behandelen van het succesvol aanmelden |
| [onRetrieveRegisterSuccess](on-retrieve-register-success.md) | `fun onRetrieveRegisterSuccess(result: `[`TokenResponse`](../../com.lennertbontinck.carmeetsandroidapp.networks.responses/-token-response/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Functie voor het behandelen van het succesvol registreren |
| [onRetrieveStart](on-retrieve-start.md) | `fun onRetrieveStart(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Functie voor het behandelen van het starten van een rest api call |
| [register](register.md) | `fun register(email: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, username: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, password: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Registreert de gebruiker en returnt of al dan niet gelukt |
| [tokenContentToViewModel](token-content-to-view-model.md) | `fun tokenContentToViewModel(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Stelt de info uit de token in op deze viewmodel: |

### Inherited Functions

| Name | Summary |
|---|---|
| [inject](../../com.lennertbontinck.carmeetsandroidapp.bases/-injected-view-model/inject.md) | `fun inject(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Injecteren adhvd de reeds aangemaakte dagger instantie van de klasse die de [InjectedViewModel](../../com.lennertbontinck.carmeetsandroidapp.bases/-injected-view-model/index.md) overerft. |
