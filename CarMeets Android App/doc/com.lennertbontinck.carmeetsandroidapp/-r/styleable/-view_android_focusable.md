[app](../../../index.md) / [com.lennertbontinck.carmeetsandroidapp](../../index.md) / [R](../index.md) / [styleable](index.md) / [View_android_focusable](./-view_android_focusable.md)

# View_android_focusable

`static val View_android_focusable: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)
`static val View_android_focusable: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)

**Attr**
description Boolean that controls whether a view can take focus. By default the user can not move focus to a view; by setting this attribute to true the view is allowed to take focus. This value does not impact the behavior of directly calling ``[`android.view.View#requestFocus`](#), which will always request focus regardless of this view. It only impacts where focus navigation will try to move focus.

May be a boolean value, such as "`true`" or "`false`".

Must be one of the following constant values.

     ConstantValueDescription auto10

**Attr**
name android:focusable

