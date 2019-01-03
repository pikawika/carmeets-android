[app](../../index.md) / [com.lennertbontinck.carmeetsandroidapp.fragments](../index.md) / [LoginFragment](./index.md)

# LoginFragment

`class LoginFragment : Fragment`

Een [Fragment](#) waar een gebruiker zich kan aanmelden of kan doorklikken naar registreren.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `LoginFragment()`<br>Een [Fragment](#) waar een gebruiker zich kan aanmelden of kan doorklikken naar registreren. |

### Properties

| Name | Summary |
|---|---|
| [accountViewModel](account-view-model.md) | `lateinit var accountViewModel: `[`AccountViewModel`](../../com.lennertbontinck.carmeetsandroidapp.viewmodels/-account-view-model/index.md)<br>[AccountViewModel](../../com.lennertbontinck.carmeetsandroidapp.viewmodels/-account-view-model/index.md) met de data over account |
| [guiViewModel](gui-view-model.md) | `lateinit var guiViewModel: `[`GuiViewModel`](../../com.lennertbontinck.carmeetsandroidapp.viewmodels/-gui-view-model/index.md)<br>[GuiViewModel](../../com.lennertbontinck.carmeetsandroidapp.viewmodels/-gui-view-model/index.md) met de data over de GUI instellingen |

### Functions

| Name | Summary |
|---|---|
| [goToRegister](go-to-register.md) | `fun goToRegister(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Gaat naar register fragment |
| [initListeners](init-listeners.md) | `fun initListeners(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Instantieer de listeners |
| [login](login.md) | `fun login(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Controleert de waarden en logt in |
| [onCreateView](on-create-view.md) | `fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?` |
| [onStart](on-start.md) | `fun onStart(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onStop](on-stop.md) | `fun onStop(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [stopListeners](stop-listeners.md) | `fun stopListeners(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Stop de listeners |
