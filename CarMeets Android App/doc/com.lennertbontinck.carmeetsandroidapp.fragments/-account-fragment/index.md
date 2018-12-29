[app](../../index.md) / [com.lennertbontinck.carmeetsandroidapp.fragments](../index.md) / [AccountFragment](./index.md)

# AccountFragment

`class AccountFragment : Fragment`

Een [Fragment](#) die de accountpagina van een aangemelde gebruiker laat zien.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `AccountFragment()`<br>Een [Fragment](#) die de accountpagina van een aangemelde gebruiker laat zien. |

### Properties

| Name | Summary |
|---|---|
| [accountViewModel](account-view-model.md) | `lateinit var accountViewModel: `[`AccountViewModel`](../../com.lennertbontinck.carmeetsandroidapp.viewmodels/-account-view-model/index.md)<br>[AccountViewModel](../../com.lennertbontinck.carmeetsandroidapp.viewmodels/-account-view-model/index.md) met de data over account |
| [binding](binding.md) | `lateinit var binding: `[`FragmentAccountBinding`](../../com.lennertbontinck.carmeetsandroidapp.databinding/-fragment-account-binding/index.md)<br>De [FragmentAccountBinding](../../com.lennertbontinck.carmeetsandroidapp.databinding/-fragment-account-binding/index.md) dat we gebruiken voor de effeciteve databinding |
| [guiViewModel](gui-view-model.md) | `lateinit var guiViewModel: `[`GuiViewModel`](../../com.lennertbontinck.carmeetsandroidapp.viewmodels/-gui-view-model/index.md)<br>[GuiViewModel](../../com.lennertbontinck.carmeetsandroidapp.viewmodels/-gui-view-model/index.md) met de data over de GUI instellingen |

### Functions

| Name | Summary |
|---|---|
| [initListeners](init-listeners.md) | `fun initListeners(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Functie voor het instantiëren van de listeners. |
| [logOut](log-out.md) | `fun logOut(): () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Een als parameter mee te geven functie om af te melden. |
| [onCreateView](on-create-view.md) | `fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?` |
| [onStart](on-start.md) | `fun onStart(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onStop](on-stop.md) | `fun onStop(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [stopListeners](stop-listeners.md) | `fun stopListeners(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Functie voor het stoppen van de listeners |
