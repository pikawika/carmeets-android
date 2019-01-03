[app](../../index.md) / [com.lennertbontinck.carmeetsandroidapp.viewmodels](../index.md) / [MeetingViewModel](./index.md)

# MeetingViewModel

`class MeetingViewModel : `[`InjectedViewModel`](../../com.lennertbontinck.carmeetsandroidapp.bases/-injected-view-model/index.md)

Een [InjectedViewModel](../../com.lennertbontinck.carmeetsandroidapp.bases/-injected-view-model/index.md) klasse die alle meetings bevat.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MeetingViewModel()`<br>Een [InjectedViewModel](../../com.lennertbontinck.carmeetsandroidapp.bases/-injected-view-model/index.md) klasse die alle meetings bevat. |

### Properties

| Name | Summary |
|---|---|
| [carmeetsApi](carmeets-api.md) | `lateinit var carmeetsApi: `[`CarmeetsApi`](../../com.lennertbontinck.carmeetsandroidapp.networks/-carmeets-api/index.md)<br>Een instantie van de carmeetsApi om data van de server op te halen. |
| [getAllMeetingsSubscription](get-all-meetings-subscription.md) | `var getAllMeetingsSubscription: Disposable`<br>De subscription op het getAllMeetings verzoek. |
| [isErrorPageWithRoomOptionVisible](is-error-page-with-room-option-visible.md) | `val isErrorPageWithRoomOptionVisible: MutableLiveData<`[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`>`<br>Bool of error fragment met optie voor het tonen van lokale items al dan niet zichtbaar is. |
| [isLoadingPageVisible](is-loading-page-visible.md) | `val isLoadingPageVisible: MutableLiveData<`[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`>`<br>Bool of loading fragment al dan niet zichtbaar is. |
| [isLocalRoomDatabaseUsedAsSource](is-local-room-database-used-as-source.md) | `val isLocalRoomDatabaseUsedAsSource: MutableLiveData<`[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`>`<br>Bool of de lokale room database al dan niet is ingesteld als databron |
| [meetingList](meeting-list.md) | `val meetingList: MutableLiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Meeting`](../../com.lennertbontinck.carmeetsandroidapp.models/-meeting/index.md)`>>`<br>De lijst van alle meetings zoals die van de server gehaald is. |
| [meetingRepository](meeting-repository.md) | `lateinit var meetingRepository: `[`MeetingRepository`](../../com.lennertbontinck.carmeetsandroidapp.roomdatabase/-meeting-repository/index.md)<br>De [MeetingRepository](../../com.lennertbontinck.carmeetsandroidapp.roomdatabase/-meeting-repository/index.md) gebruikt voor het ophalen van de meetings uit de lokale databank |
| [roomMeetingList](room-meeting-list.md) | `val roomMeetingList: LiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Meeting`](../../com.lennertbontinck.carmeetsandroidapp.models/-meeting/index.md)`>>`<br>De lijst van alle meetings zoals die uit de lokale room database is gehaald. |
| [selectedMeeting](selected-meeting.md) | `val selectedMeeting: MutableLiveData<`[`MeetingWithUserInfo`](../../com.lennertbontinck.carmeetsandroidapp.models/-meeting-with-user-info/index.md)`>`<br>De huidige door de gebruiker geselecteerde meeting. |
| [toggleGoingSubscription](toggle-going-subscription.md) | `lateinit var toggleGoingSubscription: Disposable`<br>De subscription op het toggle going verzoek. |
| [toggleLikedSubscription](toggle-liked-subscription.md) | `lateinit var toggleLikedSubscription: Disposable`<br>De subscription op het toggle liked verzoek. |

### Functions

| Name | Summary |
|---|---|
| [getFavouritesList](get-favourites-list.md) | `fun getFavouritesList(): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Meeting`](../../com.lennertbontinck.carmeetsandroidapp.models/-meeting/index.md)`>`<br>Return de meetings waarvoor de huidige gebruiker liked of going heeft ingesteld |
| [getLikedGoingAmountNext7Days](get-liked-going-amount-next7-days.md) | `fun getLikedGoingAmountNext7Days(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Return aantal meetings waarvoor de huidige gebruiker liked of going heeft ingesteld in de komende 7 dagen |
| [getUserId](get-user-id.md) | `fun getUserId(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Haalt de gebruikersId uit de token of returnt "-1" zijnde een onmogelijke userId |
| [onCleared](on-cleared.md) | `fun onCleared(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Disposed alle subscriptions wanneer de [MeetingViewModel](./index.md) niet meer gebruikt wordt. |
| [onRetrieveError](on-retrieve-error.md) | `fun onRetrieveError(error: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`, showCachedOptionOnFail: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Functie voor het behandelen van het mislukken van het ophalen van data van de server |
| [onRetrieveFinish](on-retrieve-finish.md) | `fun onRetrieveFinish(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Functie voor het behandelen van het eindigen van een rest api call. |
| [onRetrieveMeetingsSuccess](on-retrieve-meetings-success.md) | `fun onRetrieveMeetingsSuccess(result: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Meeting`](../../com.lennertbontinck.carmeetsandroidapp.models/-meeting/index.md)`>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Functie voor het behandelen van het succesvol ophalen van de meetings. |
| [onRetrieveStart](on-retrieve-start.md) | `fun onRetrieveStart(showIsLoadingFragment: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Functie voor het behandelen van het starten van een rest api call. |
| [refreshMeetingList](refresh-meeting-list.md) | `fun refreshMeetingList(showIsLoadingFragment: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Haalt de meetings opnieuw op van de server en stelt de lijst opnieuw gelijk |
| [refreshSelectedMeeting](refresh-selected-meeting.md) | `fun refreshSelectedMeeting(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Stelt de selected meeting opnieuw in door de meeting met dezelfde id uit de [meetingList](meeting-list.md) te halen. |
| [setSelectedMeeting](set-selected-meeting.md) | `fun setSelectedMeeting(meetingId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Stelt de door de gebruiker geselecteerde meeting in. |
| [toggleGoing](toggle-going.md) | `fun toggleGoing(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>toggled going voor de huidig geselecteerde meeting |
| [toggleLiked](toggle-liked.md) | `fun toggleLiked(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>toggled liked voor de huidig geselecteerde meeting |

### Inherited Functions

| Name | Summary |
|---|---|
| [inject](../../com.lennertbontinck.carmeetsandroidapp.bases/-injected-view-model/inject.md) | `fun inject(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Injecteren adhvd de reeds aangemaakte dagger instantie van de klasse die de [InjectedViewModel](../../com.lennertbontinck.carmeetsandroidapp.bases/-injected-view-model/index.md) overerft. |
