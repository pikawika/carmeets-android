[app](../../index.md) / [com.lennertbontinck.carmeetsandroidapp.utils](../index.md) / [MessageUtil](index.md) / [showToast](./show-toast.md)

# showToast

`fun showToast(message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, time: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = Toast.LENGTH_LONG): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Toont een toast op het scherm. Context is voorzien door de [MainActivity](../../com.lennertbontinck.carmeetsandroidapp.activities/-main-activity/index.md)

### Parameters

`message` - Het message dat weergegeven moet worden. Required of type [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html).

`time` - Hoe lang de toast op het scherm moet blijven. Optional of type Int (Toast Length), default Toast.LENGTH_LONG.