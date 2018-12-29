[app](../../../index.md) / [com.lennertbontinck.carmeetsandroidapp](../../index.md) / [R](../index.md) / [attr](index.md) / [showAsAction](./show-as-action.md)

# showAsAction

`static val showAsAction: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)
`static val showAsAction: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)

How this item should display in the Action Bar, if present.

Must be one or more (separated by '|') of the following constant values.

     ConstantValueDescription always2Always show this item in an actionbar, even if it would override the system's limits of how much stuff to put there. This may make your action bar look bad on some screens. In most cases you should use "ifRoom" instead. Mutually exclusive with "ifRoom" and "never". collapseActionView8This item's action view collapses to a normal menu item. When expanded, the action view takes over a larger segment of its container. ifRoom1Show this item in an action bar if there is room for it as determined by the system. Favor this option over "always" where possible. Mutually exclusive with "never" and "always". never0Never show this item in an action bar, show it in the overflow menu instead. Mutually exclusive with "ifRoom" and "always". withText4When this item is shown as an action in the action bar, show a text label with it even if it has an icon representation.

