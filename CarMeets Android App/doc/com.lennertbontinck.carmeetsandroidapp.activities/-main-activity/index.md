[app](../../index.md) / [com.lennertbontinck.carmeetsandroidapp.activities](../index.md) / [MainActivity](./index.md)

# MainActivity

`class MainActivity : AppCompatActivity`

De *mainactivity* van de applicatie. Er is maar 1 activity doorheen de app.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MainActivity()`<br>De *mainactivity* van de applicatie. Er is maar 1 activity doorheen de app. |

### Properties

| Name | Summary |
|---|---|
| [accountViewModel](account-view-model.md) | `lateinit var accountViewModel: `[`AccountViewModel`](../../com.lennertbontinck.carmeetsandroidapp.viewmodels/-account-view-model/index.md)<br>[AccountViewModel](../../com.lennertbontinck.carmeetsandroidapp.viewmodels/-account-view-model/index.md) met de data over account. |
| [backClickedOnce](back-clicked-once.md) | `var backClickedOnce: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>[Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) of backknop al dan niet al is ingedrukt. |
| [binding](binding.md) | `lateinit var binding: `[`ActivityMainBinding`](../../com.lennertbontinck.carmeetsandroidapp.databinding/-activity-main-binding/index.md)<br>De [ActivityMainBinding](../../com.lennertbontinck.carmeetsandroidapp.databinding/-activity-main-binding/index.md) dat we gebruiken voor de effeciteve databinding. |
| [guiViewModel](gui-view-model.md) | `lateinit var guiViewModel: `[`GuiViewModel`](../../com.lennertbontinck.carmeetsandroidapp.viewmodels/-gui-view-model/index.md)<br>[GuiViewModel](../../com.lennertbontinck.carmeetsandroidapp.viewmodels/-gui-view-model/index.md) met de data over de GUI instellingen. |
| [meetingViewModel](meeting-view-model.md) | `lateinit var meetingViewModel: `[`MeetingViewModel`](../../com.lennertbontinck.carmeetsandroidapp.viewmodels/-meeting-view-model/index.md)<br>[MeetingViewModel](../../com.lennertbontinck.carmeetsandroidapp.viewmodels/-meeting-view-model/index.md) met de data over alle meetings. |
| [onNavigationItemSelectedListener](on-navigation-item-selected-listener.md) | `val onNavigationItemSelectedListener: OnNavigationItemSelectedListener`<br>methode voor de *bottom navigation* selected item te monitoren. |

### Functions

| Name | Summary |
|---|---|
| [goToAccount](go-to-account.md) | `fun goToAccount(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Gaat naar de account fragment of login fragment met een gepaste animatie |
| [goToFavourites](go-to-favourites.md) | `fun goToFavourites(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Gaat naar de favourites list fragment gepaste animatie. |
| [goToMeetings](go-to-meetings.md) | `fun goToMeetings(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Gaat naar de meeting list fragment gepaste animatie. |
| [initListeners](init-listeners.md) | `fun initListeners(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Functie voor het instantiëren van de listeners. |
| [notificationsClicked](notifications-clicked.md) | `fun notificationsClicked(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Functie die het aanklikken van het notificatie icoon behandeld. |
| [onBackPressed](on-back-pressed.md) | `fun onBackPressed(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onCreate](on-create.md) | `fun onCreate(savedInstanceState: Bundle?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onCreateOptionsMenu](on-create-options-menu.md) | `fun onCreateOptionsMenu(menu: Menu?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [onOptionsItemSelected](on-options-item-selected.md) | `fun onOptionsItemSelected(item: MenuItem?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [onStart](on-start.md) | `fun onStart(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onStop](on-stop.md) | `fun onStop(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [stopListeners](stop-listeners.md) | `fun stopListeners(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Functie voor het stoppen van de listeners |
| [updateNotificationAmount](update-notification-amount.md) | `fun updateNotificationAmount(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Synct de notification amount uit de [MeetingViewModel.getLikedGoingAmountNext7Days](../../com.lennertbontinck.carmeetsandroidapp.viewmodels/-meeting-view-model/get-liked-going-amount-next7-days.md) met die uit de actionbar. |
