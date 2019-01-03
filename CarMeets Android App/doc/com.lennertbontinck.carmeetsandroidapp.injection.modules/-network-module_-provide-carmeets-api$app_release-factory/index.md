[app](../../index.md) / [com.lennertbontinck.carmeetsandroidapp.injection.modules](../index.md) / [NetworkModule_ProvideCarmeetsApi$app_releaseFactory](./index.md)

# NetworkModule_ProvideCarmeetsApi$app_releaseFactory

`class NetworkModule_ProvideCarmeetsApi$app_releaseFactory : Factory<`[`CarmeetsApi`](../../com.lennertbontinck.carmeetsandroidapp.networks/-carmeets-api/index.md)`>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `NetworkModule_ProvideCarmeetsApi$app_releaseFactory(module: `[`NetworkModule`](../-network-module/index.md)`, retrofitProvider: Provider<Retrofit>)` |

### Properties

| Name | Summary |
|---|---|
| [module](module.md) | `val module: `[`NetworkModule`](../-network-module/index.md) |
| [retrofitProvider](retrofit-provider.md) | `val retrofitProvider: Provider<Retrofit>` |

### Functions

| Name | Summary |
|---|---|
| [create](create.md) | `static fun create(module: `[`NetworkModule`](../-network-module/index.md)`, retrofitProvider: Provider<Retrofit>): `[`NetworkModule_ProvideCarmeetsApi$app_releaseFactory`](./index.md) |
| [get](get.md) | `fun get(): `[`CarmeetsApi`](../../com.lennertbontinck.carmeetsandroidapp.networks/-carmeets-api/index.md) |
| [provideInstance](provide-instance.md) | `static fun provideInstance(module: `[`NetworkModule`](../-network-module/index.md)`, retrofitProvider: Provider<Retrofit>): `[`CarmeetsApi`](../../com.lennertbontinck.carmeetsandroidapp.networks/-carmeets-api/index.md) |
| [proxyProvideCarmeetsApi$app_release](proxy-provide-carmeets-api$app_release.md) | `static fun proxyProvideCarmeetsApi$app_release(instance: `[`NetworkModule`](../-network-module/index.md)`, retrofit: Retrofit): `[`CarmeetsApi`](../../com.lennertbontinck.carmeetsandroidapp.networks/-carmeets-api/index.md) |
