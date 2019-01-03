[app](../../index.md) / [com.lennertbontinck.carmeetsandroidapp.utils](../index.md) / [RoomUtil](./index.md)

# RoomUtil

`class RoomUtil`

Een util om je te helpen met de room database,
in het bijzonder voor het converten van waardes naar een in room opslaanbaar type.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `RoomUtil()`<br>Een util om je te helpen met de room database, in het bijzonder voor het converten van waardes naar een in room opslaanbaar type. |

### Functions

| Name | Summary |
|---|---|
| [dateToLong](date-to-long.md) | `fun dateToLong(date: `[`Date`](http://docs.oracle.com/javase/6/docs/api/java/util/Date.html)`?): `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`?`<br>; Zet een [Date](http://docs.oracle.com/javase/6/docs/api/java/util/Date.html) object om naar een [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) zodat deze kan worden opgeslaan in de lokale databank |
| [jsonToStringList](json-to-string-list.md) | `fun jsonToStringList(stringListJson: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>`<br>Zet een json [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) (uit db) om naar een [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html) object van [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) objecten voor gebruik in de app. |
| [longToDate](long-to-date.md) | `fun longToDate(value: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`?): `[`Date`](http://docs.oracle.com/javase/6/docs/api/java/util/Date.html)`?`<br>Zet een [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) time object (uit db) om naar een [Date](http://docs.oracle.com/javase/6/docs/api/java/util/Date.html) object voor gebruik in de app. |
| [stringListToJson](string-list-to-json.md) | `fun stringListToJson(stringList: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Zet een [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html) object van [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) objecten om naar een json [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) zodat deze kan worden opgeslaan in de lokale databank. |
