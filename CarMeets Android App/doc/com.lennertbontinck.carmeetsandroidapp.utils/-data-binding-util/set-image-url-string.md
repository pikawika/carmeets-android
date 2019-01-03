[app](../../index.md) / [com.lennertbontinck.carmeetsandroidapp.utils](../index.md) / [DataBindingUtil](index.md) / [setImageUrlString](./set-image-url-string.md)

# setImageUrlString

`@JvmStatic fun setImageUrlString(view: ImageView, imageName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Zorgt er voor dat een android;src bij een imageview gevult wordt adhv glide indien string meegegeven.

Indien string loading_animation_carmeets_3e157a5f-56dc-4017-85ce-ee679d3e0967 is zal de gif voor loading ingesteld worden
Dit is een random GUID dus de kans dat dit overeenkomt met een afbeeldingsurl is zo goed als onbestaande.

### Parameters

`view` - : [ImageView](#) die van src voorzien moet worden. Required of type [ImageView](#).

`imageName` - : de naam van de afbeelding de op de backend staat. Required of type [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html).