[app](../../../index.md) / [com.lennertbontinck.carmeetsandroidapp](../../index.md) / [R](../index.md) / [attr](index.md) / [layout_anchorGravity](./layout_anchor-gravity.md)

# layout_anchorGravity

`static val layout_anchorGravity: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)
`static val layout_anchorGravity: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)

Specifies how an object should position relative to an anchor, on both the X and Y axes, within its parent's bounds.

Must be one or more (separated by '|') of the following constant values.

     ConstantValueDescription bottom50Push object to the bottom of its container, not changing its size. center11Place the object in the center of its container in both the vertical and horizontal axis, not changing its size. center_horizontal1Place object in the horizontal center of its container, not changing its size. center_vertical10Place object in the vertical center of its container, not changing its size. clip_horizontal8Additional option that can be set to have the left and/or right edges of the child clipped to its container's bounds. The clip will be based on the horizontal gravity: a left gravity will clip the right edge, a right gravity will clip the left edge, and neither will clip both edges. clip_vertical80Additional option that can be set to have the top and/or bottom edges of the child clipped to its container's bounds. The clip will be based on the vertical gravity: a top gravity will clip the bottom edge, a bottom gravity will clip the top edge, and neither will clip both edges. end800005Push object to the end of its container, not changing its size. fill77Grow the horizontal and vertical size of the object if needed so it completely fills its container. fill_horizontal7Grow the horizontal size of the object if needed so it completely fills its container. fill_vertical70Grow the vertical size of the object if needed so it completely fills its container. left3Push object to the left of its container, not changing its size. right5Push object to the right of its container, not changing its size. start800003Push object to the beginning of its container, not changing its size. top30Push object to the top of its container, not changing its size.

