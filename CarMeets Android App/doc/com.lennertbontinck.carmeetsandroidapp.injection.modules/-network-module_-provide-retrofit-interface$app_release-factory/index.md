[app](../../index.md) / [com.lennertbontinck.carmeetsandroidapp.injection.modules](../index.md) / [NetworkModule_ProvideRetrofitInterface$app_releaseFactory](./index.md)

# NetworkModule_ProvideRetrofitInterface$app_releaseFactory

`class NetworkModule_ProvideRetrofitInterface$app_releaseFactory : Factory<Retrofit>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `NetworkModule_ProvideRetrofitInterface$app_releaseFactory(module: `[`NetworkModule`](../-network-module/index.md)`, okHttpClientProvider: Provider<OkHttpClient>, converterFactoryProvider: Provider<Factory>, callAdapterFactoryProvider: Provider<Factory>)` |

### Properties

| Name | Summary |
|---|---|
| [callAdapterFactoryProvider](call-adapter-factory-provider.md) | `val callAdapterFactoryProvider: Provider<Factory>` |
| [converterFactoryProvider](converter-factory-provider.md) | `val converterFactoryProvider: Provider<Factory>` |
| [module](module.md) | `val module: `[`NetworkModule`](../-network-module/index.md) |
| [okHttpClientProvider](ok-http-client-provider.md) | `val okHttpClientProvider: Provider<OkHttpClient>` |

### Functions

| Name | Summary |
|---|---|
| [create](create.md) | `static fun create(module: `[`NetworkModule`](../-network-module/index.md)`, okHttpClientProvider: Provider<OkHttpClient>, converterFactoryProvider: Provider<Factory>, callAdapterFactoryProvider: Provider<Factory>): `[`NetworkModule_ProvideRetrofitInterface$app_releaseFactory`](./index.md) |
| [get](get.md) | `fun get(): Retrofit` |
| [provideInstance](provide-instance.md) | `static fun provideInstance(module: `[`NetworkModule`](../-network-module/index.md)`, okHttpClientProvider: Provider<OkHttpClient>, converterFactoryProvider: Provider<Factory>, callAdapterFactoryProvider: Provider<Factory>): Retrofit` |
| [proxyProvideRetrofitInterface$app_release](proxy-provide-retrofit-interface$app_release.md) | `static fun proxyProvideRetrofitInterface$app_release(instance: `[`NetworkModule`](../-network-module/index.md)`, okHttpClient: OkHttpClient, converterFactory: Factory, callAdapterFactory: Factory): Retrofit` |
