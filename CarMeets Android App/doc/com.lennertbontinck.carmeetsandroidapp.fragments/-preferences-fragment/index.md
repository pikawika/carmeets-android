[app](../../index.md) / [com.lennertbontinck.carmeetsandroidapp.fragments](../index.md) / [PreferencesFragment](./index.md)

# PreferencesFragment

`class PreferencesFragment : Fragment`

Een [Fragment](#) die de accountpagina van een aangemelde gebruiker laat zien.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `PreferencesFragment()`<br>Een [Fragment](#) die de accountpagina van een aangemelde gebruiker laat zien. |

### Properties

| Name | Summary |
|---|---|
| [accountViewModel](account-view-model.md) | `lateinit var accountViewModel: `[`AccountViewModel`](../../com.lennertbontinck.carmeetsandroidapp.viewmodels/-account-view-model/index.md)<br>[AccountViewModel](../../com.lennertbontinck.carmeetsandroidapp.viewmodels/-account-view-model/index.md) met de data over account |
| [guiViewModel](gui-view-model.md) | `lateinit var guiViewModel: `[`GuiViewModel`](../../com.lennertbontinck.carmeetsandroidapp.viewmodels/-gui-view-model/index.md)<br>[GuiViewModel](../../com.lennertbontinck.carmeetsandroidapp.viewmodels/-gui-view-model/index.md) met de data over de GUI instellingen |

### Functions

| Name | Summary |
|---|---|
| [initListeners](init-listeners.md) | `fun initListeners(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Functie voor het instantiëren van de listeners. |
| [onCreateView](on-create-view.md) | `fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?` |
| [onStart](on-start.md) | `fun onStart(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onStop](on-stop.md) | `fun onStop(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [showBootPageSelector](show-boot-page-selector.md) | `fun showBootPageSelector(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Toont het keuze menu voor de boot page en stelt de gekozen boot page in. |
| [showDefaultListLayoutSelector](show-default-list-layout-selector.md) | `fun showDefaultListLayoutSelector(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Toont het keuze menu voor de standaard lijst design en stelt de gekozen lijstdesign in. |
| [stopListeners](stop-listeners.md) | `fun stopListeners(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Functie voor het stoppen van de listeners |
