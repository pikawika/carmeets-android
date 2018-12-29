[app](../../index.md) / [com.lennertbontinck.carmeetsandroidapp.fragments](../index.md) / [RegisterFragment](./index.md)

# RegisterFragment

`class RegisterFragment : Fragment`

Een [Fragment](#) waarmee een gebruiker hem kan registreren.

Gebruiker kan doorklikken naar goToLogin.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `RegisterFragment()`<br>Een [Fragment](#) waarmee een gebruiker hem kan registreren. |

### Properties

| Name | Summary |
|---|---|
| [accountViewModel](account-view-model.md) | `lateinit var accountViewModel: `[`AccountViewModel`](../../com.lennertbontinck.carmeetsandroidapp.viewmodels/-account-view-model/index.md)<br>[AccountViewModel](../../com.lennertbontinck.carmeetsandroidapp.viewmodels/-account-view-model/index.md) met de data over account |
| [guiViewModel](gui-view-model.md) | `lateinit var guiViewModel: `[`GuiViewModel`](../../com.lennertbontinck.carmeetsandroidapp.viewmodels/-gui-view-model/index.md)<br>[GuiViewModel](../../com.lennertbontinck.carmeetsandroidapp.viewmodels/-gui-view-model/index.md) met de data over de GUI instellingen |

### Functions

| Name | Summary |
|---|---|
| [goToLogin](go-to-login.md) | `fun goToLogin(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Gaat naar login fragment |
| [initListeners](init-listeners.md) | `fun initListeners(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Instantieer de listeners |
| [onCreateView](on-create-view.md) | `fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?` |
| [onStart](on-start.md) | `fun onStart(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onStop](on-stop.md) | `fun onStop(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [register](register.md) | `fun register(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Kijkt of velden ingevuld zijn en wachtwoorden overeenkomen en probeert vervolgens te registreren |
| [stopListeners](stop-listeners.md) | `fun stopListeners(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Stop de listeners |
