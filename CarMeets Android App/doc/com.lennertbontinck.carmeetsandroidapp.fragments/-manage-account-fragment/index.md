[app](../../index.md) / [com.lennertbontinck.carmeetsandroidapp.fragments](../index.md) / [ManageAccountFragment](./index.md)

# ManageAccountFragment

`class ManageAccountFragment : Fragment`

Een [Fragment](#) die de accountpagina van een aangemelde gebruiker laat zien.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ManageAccountFragment()`<br>Een [Fragment](#) die de accountpagina van een aangemelde gebruiker laat zien. |

### Properties

| Name | Summary |
|---|---|
| [accountViewModel](account-view-model.md) | `lateinit var accountViewModel: `[`AccountViewModel`](../../com.lennertbontinck.carmeetsandroidapp.viewmodels/-account-view-model/index.md)<br>[AccountViewModel](../../com.lennertbontinck.carmeetsandroidapp.viewmodels/-account-view-model/index.md) met de data over account |
| [guiViewModel](gui-view-model.md) | `lateinit var guiViewModel: `[`GuiViewModel`](../../com.lennertbontinck.carmeetsandroidapp.viewmodels/-gui-view-model/index.md)<br>[GuiViewModel](../../com.lennertbontinck.carmeetsandroidapp.viewmodels/-gui-view-model/index.md) met de data over de GUI instellingen |

### Functions

| Name | Summary |
|---|---|
| [changeEmail](change-email.md) | `fun changeEmail(): (`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Als parameter mee te geven functie die een wijzig email verzoek uitvoert met een meegegeven string |
| [changeUsername](change-username.md) | `fun changeUsername(): (`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Als parameter mee te geven functie die een wijzig wachtwoord verzoek uitvoert met een meegegeven string |
| [initListeners](init-listeners.md) | `fun initListeners(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Functie voor het instantiëren van de listeners. |
| [onCreateView](on-create-view.md) | `fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?` |
| [onStart](on-start.md) | `fun onStart(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onStop](on-stop.md) | `fun onStop(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [stopListeners](stop-listeners.md) | `fun stopListeners(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Functie voor het stoppen van de listeners |
