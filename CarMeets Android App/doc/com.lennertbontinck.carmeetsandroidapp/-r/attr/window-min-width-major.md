[app](../../../index.md) / [com.lennertbontinck.carmeetsandroidapp](../../index.md) / [R](../index.md) / [attr](index.md) / [windowMinWidthMajor](./window-min-width-major.md)

# windowMinWidthMajor

`static val windowMinWidthMajor: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)
`static val windowMinWidthMajor: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)

The minimum width the window is allowed to be, along the major axis of the screen. That is, when in landscape. Can be either an absolute dimension or a fraction of the screen size in that dimension.

May be a dimension value, which is a floating point number appended with a unit such as "`14.5sp`". Available units are: px (pixels), dp (density-independent pixels), sp (scaled pixels based on preferred font size), in (inches), and mm (millimeters).

May be a fractional value, which is a floating point number appended with either % or %p, such as "`14.5%`". The % suffix always means a percentage of the base size; the optional %p suffix provides a size relative to some parent container.

