[app](../../index.md) / [com.lennertbontinck.carmeetsandroidapp.utils](../index.md) / [DataBindingUtil](index.md) / [setIsToggledOn](./set-is-toggled-on.md)

# setIsToggledOn

`@JvmStatic fun setIsToggledOn(view: AppCompatImageView, isToggledOn: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Zorgt er voor dat je gewoon boolean bind kan meegeven en aan de hand daarvan wordt toggled juiste kleur.

### Parameters

`view` - : [AppCompatImageView](#) die al dan niet zwarte of roze tint moet hebben. Required of type [AppCompatImageView](#).

`isToggledOn` - : of tint van de [AppCompatImageView](#) al dan niet actief moet zijn. True -&gt; colorPrimary, false -&gt; black. Required of type [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html).