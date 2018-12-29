[app](../../index.md) / [com.lennertbontinck.carmeetsandroidapp.injection.components](../index.md) / [NetworkComponent](./index.md)

# NetworkComponent

`@Singleton @Component([NetworkModule]) interface NetworkComponent`

Deze [NetworkComponent](./index.md) dient als tussenlaag tussen de [NetworkModule](../../com.lennertbontinck.carmeetsandroidapp.injection.modules/-network-module/index.md) en de effectieve [MeetingViewModel](../../com.lennertbontinck.carmeetsandroidapp.viewmodels/-meeting-view-model/index.md)

Momenteel compatibel met: [MeetingViewModel](../../com.lennertbontinck.carmeetsandroidapp.viewmodels/-meeting-view-model/index.md)

### Functions

| Name | Summary |
|---|---|
| [inject](inject.md) | `abstract fun inject(meetingViewModel: `[`MeetingViewModel`](../../com.lennertbontinck.carmeetsandroidapp.viewmodels/-meeting-view-model/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Doet dependency injection op de meegegeven [MeetingViewModel](../../com.lennertbontinck.carmeetsandroidapp.viewmodels/-meeting-view-model/index.md)`abstract fun inject(accountViewModel: `[`AccountViewModel`](../../com.lennertbontinck.carmeetsandroidapp.viewmodels/-account-view-model/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Doet dependency injection op de meegegeven [AccountViewModel](../../com.lennertbontinck.carmeetsandroidapp.viewmodels/-account-view-model/index.md) |

### Inheritors

| Name | Summary |
|---|---|
| [DaggerNetworkComponent](../-dagger-network-component/index.md) | `class DaggerNetworkComponent : `[`NetworkComponent`](./index.md) |
