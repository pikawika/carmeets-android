[app](../../index.md) / [com.lennertbontinck.carmeetsandroidapp.injection.modules](../index.md) / [NetworkModule](./index.md)

# NetworkModule

`class NetworkModule`

Dit [Object](http://docs.oracle.com/javase/6/docs/api/java/lang/Object.html) is een dagger [Module](#) die alle nodige dependency voor de netwerkconnectie voorziet

Alle functies in dit object zijn singletons aangezien dezelfde dependency opnieuw gebruikt moet worden voor volgende
interacties.

Special thanks to Harm De Weirdt for base code and clear explanation of innerworkings
https://github.com/hdeweirdt/metar

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `NetworkModule(context: Context)`<br>Dit [Object](http://docs.oracle.com/javase/6/docs/api/java/lang/Object.html) is een dagger [Module](#) die alle nodige dependency voor de netwerkconnectie voorziet |

### Properties

| Name | Summary |
|---|---|
| [context](context.md) | `val context: Context` |

### Functions

| Name | Summary |
|---|---|
| [provideApplicationContext](provide-application-context.md) | `fun provideApplicationContext(): Context`<br>Return [Context](#) object dat de context van de applicatie bij een heel vroeg stadium van de app al kan voorzien. |
| [provideCallAdapterFactory](provide-call-adapter-factory.md) | `internal fun provideCallAdapterFactory(): Factory`<br>Return [retrofit2.CallAdapter.Factory](#) object als een [retrofit2.CallAdapter.Factory](#) dat de calls naar de api managed. |
| [provideCarmeetsApi](provide-carmeets-api.md) | `internal fun provideCarmeetsApi(retrofit: Retrofit): `[`CarmeetsApi`](../../com.lennertbontinck.carmeetsandroidapp.networks/-carmeets-api/index.md)<br>Returnt de [CarmeetsApi](../../com.lennertbontinck.carmeetsandroidapp.networks/-carmeets-api/index.md) om met de Carmeets backend te communiceren |
| [provideJSONConverter](provide-j-s-o-n-converter.md) | `internal fun provideJSONConverter(): Factory`<br>Returnt een [Moshi](#) object als [retrofit2.Converter.Factory](#) dat de json van de server omzet naar een model object. |
| [provideMeetingDao](provide-meeting-dao.md) | `fun provideMeetingDao(meetingDatabase: `[`MeetingDatabase`](../../com.lennertbontinck.carmeetsandroidapp.roomdatabase/-meeting-database/index.md)`): `[`MeetingDao`](../../com.lennertbontinck.carmeetsandroidapp.roomdatabase/-meeting-dao/index.md)<br>Return [MeetingDao](../../com.lennertbontinck.carmeetsandroidapp.roomdatabase/-meeting-dao/index.md) object voor acties op de room [MeetingDatabase](../../com.lennertbontinck.carmeetsandroidapp.roomdatabase/-meeting-database/index.md) |
| [provideMeetingDatabase](provide-meeting-database.md) | `fun provideMeetingDatabase(context: Context): `[`MeetingDatabase`](../../com.lennertbontinck.carmeetsandroidapp.roomdatabase/-meeting-database/index.md)<br>Return room [MeetingDatabase](../../com.lennertbontinck.carmeetsandroidapp.roomdatabase/-meeting-database/index.md) object van de huidige context |
| [provideMeetingRepository](provide-meeting-repository.md) | `fun provideMeetingRepository(meetingDao: `[`MeetingDao`](../../com.lennertbontinck.carmeetsandroidapp.roomdatabase/-meeting-dao/index.md)`): `[`MeetingRepository`](../../com.lennertbontinck.carmeetsandroidapp.roomdatabase/-meeting-repository/index.md)<br>Return [MeetingRepository](../../com.lennertbontinck.carmeetsandroidapp.roomdatabase/-meeting-repository/index.md) object voor communicatie met room database adhv [MeetingDao](../../com.lennertbontinck.carmeetsandroidapp.roomdatabase/-meeting-dao/index.md) |
| [provideOkHttpClient](provide-ok-http-client.md) | `internal fun provideOkHttpClient(): OkHttpClient`<br>Return een [OkHttpClient](#) die momenteel de body logt voor debugging redenen |
| [provideRetrofitInterface](provide-retrofit-interface.md) | `internal fun provideRetrofitInterface(okHttpClient: OkHttpClient, converterFactory: Factory, callAdapterFactory: Factory): Retrofit`<br>Returnt het [Retrofit](#) object dat voorzien is van een [OkHttpClient](#) om de effectieve connectie met de backend te doen (http requests) een [retrofit2.Converter.Factory](#) om de gereturnde json om te zetten naar een model object een [retrofit2.CallAdapter.Factory](#) om de management van de calls voor zich te nemen. (volgorde, executie en response handling) |
