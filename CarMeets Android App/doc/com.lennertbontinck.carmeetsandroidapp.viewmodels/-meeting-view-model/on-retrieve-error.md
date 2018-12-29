[app](../../index.md) / [com.lennertbontinck.carmeetsandroidapp.viewmodels](../index.md) / [MeetingViewModel](index.md) / [onRetrieveError](./on-retrieve-error.md)

# onRetrieveError

`private fun onRetrieveError(error: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`, showCachedOptionOnFail: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Functie voor het behandelen van het mislukken van het ophalen van data van de server

### Parameters

`error` - : de verkregeen error. Required of type [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html).

`showCachedOptionOnFail` - : of bij het falen de optie voor het ophalen van de cached meetings
aan de gebruiker moet worden voorgesteld