[app](../../index.md) / [com.lennertbontinck.carmeetsandroidapp.networks](../index.md) / [CarmeetsApi](./index.md)

# CarmeetsApi

`interface CarmeetsApi`

Een *interface* die de methoden voorziet om objecten van de *carmeets-backend server* te halen.

### Functions

| Name | Summary |
|---|---|
| [changeEmail](change-email.md) | `abstract fun changeEmail(changeEmailRequest: `[`ChangeEmailRequest`](../../com.lennertbontinck.carmeetsandroidapp.networks.requests/-change-email-request/index.md)`): Observable<`[`TokenResponse`](../../com.lennertbontinck.carmeetsandroidapp.networks.responses/-token-response/index.md)`>`<br>Verander het e-mailadres van de aangemelde gebruiker en return tokenresponse. |
| [changePassword](change-password.md) | `abstract fun changePassword(changePasswordRequest: `[`ChangePasswordRequest`](../../com.lennertbontinck.carmeetsandroidapp.networks.requests/-change-password-request/index.md)`): Observable<`[`TokenResponse`](../../com.lennertbontinck.carmeetsandroidapp.networks.responses/-token-response/index.md)`>`<br>Verander het wachtwoord van de aangemelde gebruiker en return tokenresponse. |
| [changeUsername](change-username.md) | `abstract fun changeUsername(changeUsernameRequest: `[`ChangeUsernameRequest`](../../com.lennertbontinck.carmeetsandroidapp.networks.requests/-change-username-request/index.md)`): Observable<`[`TokenResponse`](../../com.lennertbontinck.carmeetsandroidapp.networks.responses/-token-response/index.md)`>`<br>Verander de gebruikersnaam van de aangemelde gebruiker en return tokenresponse. |
| [getAllMeetings](get-all-meetings.md) | `abstract fun getAllMeetings(): Observable<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Meeting`](../../com.lennertbontinck.carmeetsandroidapp.models/-meeting/index.md)`>>`<br>Haal alle meetings op |
| [login](login.md) | `abstract fun login(loginRequest: `[`LoginRequest`](../../com.lennertbontinck.carmeetsandroidapp.networks.requests/-login-request/index.md)`): Observable<`[`TokenResponse`](../../com.lennertbontinck.carmeetsandroidapp.networks.responses/-token-response/index.md)`>`<br>Login en return tokenresponse. |
| [register](register.md) | `abstract fun register(registerRequest: `[`RegisterRequest`](../../com.lennertbontinck.carmeetsandroidapp.networks.requests/-register-request/index.md)`): Observable<`[`TokenResponse`](../../com.lennertbontinck.carmeetsandroidapp.networks.responses/-token-response/index.md)`>`<br>Registreer gebruiker en return tokenresponse. |
| [toggleGoing](toggle-going.md) | `abstract fun toggleGoing(toggleGoingRequest: `[`ToggleGoingRequest`](../../com.lennertbontinck.carmeetsandroidapp.networks.requests/-toggle-going-request/index.md)`): Observable<`[`GoingAmountResponse`](../../com.lennertbontinck.carmeetsandroidapp.networks.responses/-going-amount-response/index.md)`>`<br>Verander de going status van de aangemelde gebruiker voor een bepaalde meeting. |
| [toggleLiked](toggle-liked.md) | `abstract fun toggleLiked(toggleLikedRequest: `[`ToggleLikedRequest`](../../com.lennertbontinck.carmeetsandroidapp.networks.requests/-toggle-liked-request/index.md)`): Observable<`[`LikedAmountResponse`](../../com.lennertbontinck.carmeetsandroidapp.networks.responses/-liked-amount-response/index.md)`>`<br>Verander de like status van de aangemelde gebruiker voor een bepaalde meeting. |
