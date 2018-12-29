[app](../../index.md) / [com.lennertbontinck.carmeetsandroidapp.injection.modules](../index.md) / [NetworkModule](index.md) / [provideJSONConverter](./provide-j-s-o-n-converter.md)

# provideJSONConverter

`@Provides @Singleton internal fun provideJSONConverter(): Factory`

Returnt een [Moshi](#) object als [retrofit2.Converter.Factory](#) dat de json van de server omzet naar een model object.

Is voorzien van een custom date parser.

Meer info op [https//github.com/square/moshi/tree/master/adapters](https//github.com/square/moshi/tree/master/adapters) (wordt door moshi aangeraden dus depricated?)

