[app](../../index.md) / [com.lennertbontinck.carmeetsandroidapp.extensions](../index.md) / [DateParser](index.md) / [&lt;init&gt;](./-init-.md)

# &lt;init&gt;

`DateParser()`

Formats dates using [RFC 3339](#), which is formatted like `2015-09-26T18:23:50.250Z`. To use, add this as an adapter for `Date.class` on your com.squareup.moshi.Moshi.Builder:

```
`Moshi moshi = new Moshi.Builder() .add(Date.class, new Rfc3339DateJsonAdapter()) .build(); `
```

