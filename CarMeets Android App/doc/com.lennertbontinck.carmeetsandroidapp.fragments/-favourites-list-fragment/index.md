[app](../../index.md) / [com.lennertbontinck.carmeetsandroidapp.fragments](../index.md) / [FavouritesListFragment](./index.md)

# FavouritesListFragment

`class FavouritesListFragment : Fragment`

Een [Fragment](#) die alle gelikete en going meetings van een gebruiker laat zien.
Hiervoor moet de gebruiker uiteraard een account hebben en ingelogd zijn.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `FavouritesListFragment()`<br>Een [Fragment](#) die alle gelikete en going meetings van een gebruiker laat zien. Hiervoor moet de gebruiker uiteraard een account hebben en ingelogd zijn. |

### Properties

| Name | Summary |
|---|---|
| [accountViewModel](account-view-model.md) | `lateinit var accountViewModel: `[`AccountViewModel`](../../com.lennertbontinck.carmeetsandroidapp.viewmodels/-account-view-model/index.md)<br>[AccountViewModel](../../com.lennertbontinck.carmeetsandroidapp.viewmodels/-account-view-model/index.md) met de data over de aangemelde gebruiker |
| [favouritesAdapter](favourites-adapter.md) | `lateinit var favouritesAdapter: `[`FavouritesAdapter`](../../com.lennertbontinck.carmeetsandroidapp.adapters/-favourites-adapter/index.md)<br>[FavouritesAdapter](../../com.lennertbontinck.carmeetsandroidapp.adapters/-favourites-adapter/index.md) voor het vullen van de favorieten lijst |
| [guiViewModel](gui-view-model.md) | `lateinit var guiViewModel: `[`GuiViewModel`](../../com.lennertbontinck.carmeetsandroidapp.viewmodels/-gui-view-model/index.md)<br>[GuiViewModel](../../com.lennertbontinck.carmeetsandroidapp.viewmodels/-gui-view-model/index.md) met de data over de GUI instellingen |
| [meetingViewModel](meeting-view-model.md) | `lateinit var meetingViewModel: `[`MeetingViewModel`](../../com.lennertbontinck.carmeetsandroidapp.viewmodels/-meeting-view-model/index.md)<br>[MeetingViewModel](../../com.lennertbontinck.carmeetsandroidapp.viewmodels/-meeting-view-model/index.md) met de data van alle meetings |

### Functions

| Name | Summary |
|---|---|
| [initListeners](init-listeners.md) | `fun initListeners(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Functie voor het instantiëren van de listeners. |
| [onCreateView](on-create-view.md) | `fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?` |
| [onStart](on-start.md) | `fun onStart(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onStop](on-stop.md) | `fun onStop(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [stopListeners](stop-listeners.md) | `fun stopListeners(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Functie voor het stoppen van de listeners |
