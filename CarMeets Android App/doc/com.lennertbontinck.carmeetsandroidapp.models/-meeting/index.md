[app](../../index.md) / [com.lennertbontinck.carmeetsandroidapp.models](../index.md) / [Meeting](./index.md)

# Meeting

`open class Meeting : Parcelable`

Een Data [Class](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html) die de informatie van een meeting bevat.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Meeting(meetingId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, title: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, subtitle: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, description: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, categories: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>, listUsersGoing: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>, listUsersLiked: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>, date: `[`Date`](http://docs.oracle.com/javase/6/docs/api/java/util/Date.html)`, city: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, postalCode: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, streetName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, houseNumber: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, imageName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, website: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`)`<br>Een Data [Class](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html) die de informatie van een meeting bevat. |

### Properties

| Name | Summary |
|---|---|
| [categories](categories.md) | `val categories: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |
| [city](city.md) | `val city: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [date](date.md) | `val date: `[`Date`](http://docs.oracle.com/javase/6/docs/api/java/util/Date.html) |
| [description](description.md) | `val description: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [houseNumber](house-number.md) | `val houseNumber: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [imageName](image-name.md) | `val imageName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [listUsersGoing](list-users-going.md) | `val listUsersGoing: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |
| [listUsersLiked](list-users-liked.md) | `val listUsersLiked: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |
| [location](location.md) | `val location: `[`Location`](../-location/index.md) |
| [meetingId](meeting-id.md) | `val meetingId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [postalCode](postal-code.md) | `val postalCode: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [streetName](street-name.md) | `val streetName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [subtitle](subtitle.md) | `val subtitle: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [title](title.md) | `val title: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [website](website.md) | `val website: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [MeetingWithUserInfo](../-meeting-with-user-info/index.md) | `data class MeetingWithUserInfo : `[`Meeting`](./index.md)<br>Een Data [Class](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html) die de informatie van een meeting bevat met als extentie info over de user m.b.t deze meeting (al dan niet liked en going). |
