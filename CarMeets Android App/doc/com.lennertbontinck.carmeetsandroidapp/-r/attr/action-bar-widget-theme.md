[app](../../../index.md) / [com.lennertbontinck.carmeetsandroidapp](../../index.md) / [R](../index.md) / [attr](index.md) / [actionBarWidgetTheme](./action-bar-widget-theme.md)

# actionBarWidgetTheme

`static val actionBarWidgetTheme: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)
`static val actionBarWidgetTheme: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)

Reference to a theme that should be used to inflate widgets and layouts destined for the action bar. Most of the time this will be a reference to the current theme, but when the action bar has a significantly different contrast profile than the rest of the activity the difference can become important. If this is set to @null the current theme will be used.

May be a reference to another resource, in the form "`@[+][*package*:]*type*/*name*`" or a theme attribute in the form "`?[*package*:]*type*/*name*`".

