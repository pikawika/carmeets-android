[app](../../index.md) / [com.lennertbontinck.carmeetsandroidapp.injection.modules](../index.md) / [NetworkModule](index.md) / [provideRetrofitInterface](./provide-retrofit-interface.md)

# provideRetrofitInterface

`@Provides @Singleton internal fun provideRetrofitInterface(okHttpClient: OkHttpClient, converterFactory: Factory, callAdapterFactory: Factory): Retrofit`

Returnt het [Retrofit](#) object dat voorzien is van
een [OkHttpClient](#) om de effectieve connectie met de backend te doen (http requests)
een [retrofit2.Converter.Factory](#) om de gereturnde json om te zetten naar een model object
een [retrofit2.CallAdapter.Factory](#) om de management van de calls voor zich te nemen. (volgorde, executie en response handling)

