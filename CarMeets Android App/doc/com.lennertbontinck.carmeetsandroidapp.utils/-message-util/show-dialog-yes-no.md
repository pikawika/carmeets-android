[app](../../index.md) / [com.lennertbontinck.carmeetsandroidapp.utils](../index.md) / [MessageUtil](index.md) / [showDialogYesNo](./show-dialog-yes-no.md)

# showDialogYesNo

`fun showDialogYesNo(parentActivity: Activity, title: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, func: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Toont een dialoog popup met ja nee knoppen en voert de meegegeven parameterloze functie uit.

### Parameters

`parentActivity` - : activity van de huidige omgeving. Required of type [Activity](#).

`title` - : de gewenste titel van de popup. Required of type [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html).

`message` - : de gewenste omschrijving in de popup. Required of type [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html).

`func` - : een funtie dat moet uitgevoerd worden, parameterloos. Required of type [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html).