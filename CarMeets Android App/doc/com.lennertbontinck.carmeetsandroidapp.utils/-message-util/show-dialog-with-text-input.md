[app](../../index.md) / [com.lennertbontinck.carmeetsandroidapp.utils](../index.md) / [MessageUtil](index.md) / [showDialogWithTextInput](./show-dialog-with-text-input.md)

# showDialogWithTextInput

`fun showDialogWithTextInput(context: Context, title: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, hint: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, func: (`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Toont een dialoog popup met een textinput en voert met de opgeleverde string een gegeven functie uit

### Parameters

`context` - : context van het huidige omgeving (niet de [MainActivity](../../com.lennertbontinck.carmeetsandroidapp.activities/-main-activity/index.md) !)

`title` - : de gewenste titel van de popup

`message` - : de gewenste omschrijving in de popup

`hint` - : de gewenste hint in het inputveld

`func` - : een funtie dat moet uitgevoerd worden met de opgeleverde string