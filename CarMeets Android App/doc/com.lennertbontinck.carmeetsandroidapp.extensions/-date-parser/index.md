[app](../../index.md) / [com.lennertbontinck.carmeetsandroidapp.extensions](../index.md) / [DateParser](./index.md)

# DateParser

`class DateParser : JsonAdapter<`[`Date`](http://docs.oracle.com/javase/6/docs/api/java/util/Date.html)`>`

Formats dates using [RFC 3339](#), which is formatted like `2015-09-26T18:23:50.250Z`. To use, add this as an adapter for `Date.class` on your com.squareup.moshi.Moshi.Builder:

```
`Moshi moshi = new Moshi.Builder() .add(Date.class, new Rfc3339DateJsonAdapter()) .build(); `
```

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `DateParser()`<br>Formats dates using [RFC 3339](#), which is formatted like `2015-09-26T18:23:50.250Z`. To use, add this as an adapter for `Date.class` on your com.squareup.moshi.Moshi.Builder:

```
`Moshi moshi = new Moshi.Builder() .add(Date.class, new Rfc3339DateJsonAdapter()) .build(); `<br>```
<br> |

### Functions

| Name | Summary |
|---|---|
| [fromJson](from-json.md) | `fun fromJson(reader: JsonReader): `[`Date`](http://docs.oracle.com/javase/6/docs/api/java/util/Date.html)`?` |
| [toJson](to-json.md) | `fun toJson(writer: JsonWriter, value: `[`Date`](http://docs.oracle.com/javase/6/docs/api/java/util/Date.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
