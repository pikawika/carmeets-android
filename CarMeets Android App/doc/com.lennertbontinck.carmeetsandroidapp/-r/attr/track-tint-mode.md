[app](../../../index.md) / [com.lennertbontinck.carmeetsandroidapp](../../index.md) / [R](../index.md) / [attr](index.md) / [trackTintMode](./track-tint-mode.md)

# trackTintMode

`static val trackTintMode: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)
`static val trackTintMode: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)

Blending mode used to apply the track tint.

Must be one of the following constant values.

     ConstantValueDescription add10Combines the tint and drawable color and alpha channels, clamping the result to valid color values. Saturate(S + D) multiplyeMultiplies the color and alpha channels of the drawable with those of the tint. [Sa * Da, Sc * Dc] screenf[Sa + Da - Sa * Da, Sc + Dc - Sc * Dc] src_atop9The tint is drawn above the drawable, but with the drawable’s alpha channel masking the result. [Da, Sc * Da + (1 - Sa) * Dc] src_in5The tint is masked by the alpha channel of the drawable. The drawable’s color channels are thrown out. [Sa * Da, Sc * Da] src_over3The tint is drawn on top of the drawable. [Sa + (1 - Sa)*Da, Rc = Sc + (1 - Sa)*Dc]

