[app](../../index.md) / [com.lennertbontinck.carmeetsandroidapp.context](../index.md) / [CarMeetsApplication](./index.md)

# CarMeetsApplication

`class CarMeetsApplication : Application`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `CarMeetsApplication()` |

### Functions

| Name | Summary |
|---|---|
| [onCreate](on-create.md) | `fun onCreate(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Companion Object Properties

| Name | Summary |
|---|---|
| [injector](injector.md) | `lateinit var injector: `[`NetworkComponent`](../../com.lennertbontinck.carmeetsandroidapp.injection.components/-network-component/index.md) |
| [instance](instance.md) | `var instance: Application?`<br>een instantie van de [Application](#) voor system wide gebruik van de context |

### Companion Object Functions

| Name | Summary |
|---|---|
| [getContext](get-context.md) | `fun getContext(): Context`<br>returnt de [Context](#) van de [Application](#) |
