[app](../index.md) / [com.lennertbontinck.carmeetsandroidapp.extensions](./index.md)

## Package com.lennertbontinck.carmeetsandroidapp.extensions

### Types

| Name | Summary |
|---|---|
| [DateParser](-date-parser/index.md) | `class DateParser : JsonAdapter<`[`Date`](http://docs.oracle.com/javase/6/docs/api/java/util/Date.html)`>`<br>Formats dates using [RFC 3339](#), which is formatted like `2015-09-26T18:23:50.250Z`. To use, add this as an adapter for `Date.class` on your com.squareup.moshi.Moshi.Builder:

```
`Moshi moshi = new Moshi.Builder() .add(Date.class, new Rfc3339DateJsonAdapter()) .build(); `<br>```
<br> |
| [IsoConverter](-iso-converter/index.md) | `class IsoConverter` |
