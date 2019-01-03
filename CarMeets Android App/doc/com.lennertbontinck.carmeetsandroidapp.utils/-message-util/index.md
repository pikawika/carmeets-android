[app](../../index.md) / [com.lennertbontinck.carmeetsandroidapp.utils](../index.md) / [MessageUtil](./index.md)

# MessageUtil

`object MessageUtil`

Een util om je te helpen met het weergeven van *berichten* aan de gebruiker.

### Functions

| Name | Summary |
|---|---|
| [showDialogLoginRequired](show-dialog-login-required.md) | `fun showDialogLoginRequired(parentActivity: `[`MainActivity`](../../com.lennertbontinck.carmeetsandroidapp.activities/-main-activity/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Toont een dialoog die zegt dat een account nodig is voor deze functie met optie om naar account te gaan. |
| [showDialogWithTextInput](show-dialog-with-text-input.md) | `fun showDialogWithTextInput(context: Context, title: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, hint: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, func: (`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Toont een dialoog popup met een textinput en voert met de opgeleverde string een gegeven functie uit |
| [showDialogYesNo](show-dialog-yes-no.md) | `fun showDialogYesNo(parentActivity: Activity, title: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, func: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Toont een dialoog popup met ja nee knoppen en voert de meegegeven parameterloze functie uit. |
| [showToast](show-toast.md) | `fun showToast(message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, time: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = Toast.LENGTH_LONG): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Toont een toast op het scherm. Context is voorzien door de [MainActivity](../../com.lennertbontinck.carmeetsandroidapp.activities/-main-activity/index.md) |
