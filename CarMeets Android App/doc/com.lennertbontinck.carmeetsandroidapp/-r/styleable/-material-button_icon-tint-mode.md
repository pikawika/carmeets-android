[app](../../../index.md) / [com.lennertbontinck.carmeetsandroidapp](../../index.md) / [R](../index.md) / [styleable](index.md) / [MaterialButton_iconTintMode](./-material-button_icon-tint-mode.md)

# MaterialButton_iconTintMode

`static val MaterialButton_iconTintMode: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)
`static val MaterialButton_iconTintMode: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)

**Attr**
description Blending mode used to apply the icon tint.

Must be one of the following constant values.

     ConstantValueDescription add10Combines the tint and icon color and alpha channels, clamping the result to valid color values. Saturate(S + D) multiplyeMultiplies the color and alpha channels of the icon with those of the tint. [Sa * Da, Sc * Dc] screenf[Sa + Da - Sa * Da, Sc + Dc - Sc * Dc] src_atop9The tint is drawn above the icon, but with the icon’s alpha channel masking the result. [Da, Sc * Da + (1 - Sa) * Dc] src_in5The tint is masked by the alpha channel of the icon. The icon’s color channels are thrown out. [Sa * Da, Sc * Da] src_over3The tint is drawn on top of the icon. [Sa + (1 - Sa)*Da, Rc = Sc + (1 - Sa)*Dc]

**Attr**
name com.lennertbontinck.carmeetsandroidapp:iconTintMode

