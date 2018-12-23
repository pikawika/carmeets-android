@file:Suppress("DEPRECATION")

package com.lennertbontinck.carmeetsandroidapp.injection.modules

import android.content.Context
import com.lennertbontinck.carmeetsandroidapp.constants.BASE_URL_BACKEND_API
import com.lennertbontinck.carmeetsandroidapp.extensions.DateParser
import com.lennertbontinck.carmeetsandroidapp.networks.CarmeetsApi
import com.lennertbontinck.carmeetsandroidapp.utils.PreferenceUtil
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*
import javax.inject.Singleton


/**
 * Dit [Object] is een dagger [Module] die alle nodige dependency voor de netwerkconnectie voorziet
 *
 * Alle functies in dit object zijn singletons aangezien dezelfde dependency opnieuw gebruikt moet worden voor volgende
 * interacties.
 *
 * Special thanks to Harm De Weirdt for base code and clear explanation of innerworkings
 * https://github.com/hdeweirdt/metar
 */
@Module
class NetworkModule(private val context: Context) {

    /**
     * Returnt de [CarmeetsApi] om met de Carmeets backend te communiceren
     * @param retrofit het retrofit object dat gebruikt zal worden om de carmeets api te instantieren
     */
    @Provides
    @Singleton
    internal fun provideCarmeetsApi(retrofit: Retrofit): CarmeetsApi {
        return retrofit.create(CarmeetsApi::class.java)
    }


    /**
     * Returnt het [Retrofit] object dat voorzien is van
     * een [OkHttpClient] om de effectieve connectie met de backend te doen (http requests)
     * een [retrofit2.Converter.Factory] om de gereturnde json om te zetten naar een model object
     * een [retrofit2.CallAdapter.Factory] om de management van de calls voor zich te nemen. (volgorde, executie en response handling)
     */
    @Provides
    @Singleton
    internal fun provideRetrofitInterface(
        okHttpClient: OkHttpClient,
        converterFactory: retrofit2.Converter.Factory,
        callAdapterFactory: retrofit2.CallAdapter.Factory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL_BACKEND_API)
            .client(okHttpClient)
            .addConverterFactory(converterFactory)
            .addCallAdapterFactory(callAdapterFactory)
            .build()
    }

    /**
     * Return een [OkHttpClient] die momenteel de body logt voor debugging redenen
     *
     * Hier kan mogelijk later een methode voorzien worden om header te voorzien van token
     */
    @Provides
    @Singleton
    internal fun provideOkHttpClient(): OkHttpClient {
        val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }

        val authInterceptor = Interceptor { chain ->
            val accessToken = PreferenceUtil.getToken()
            chain.proceed(
                chain.request().newBuilder()
                    .addHeader("Authorization", "Bearer $accessToken")
                    .build()
            )
        }

        return OkHttpClient.Builder().apply {
            addInterceptor(interceptor)
            addInterceptor(authInterceptor)
        }.build()
    }


    /**
     * Returnt een [Moshi] object als [retrofit2.Converter.Factory] dat de json van de server omzet naar een model object.
     *
     * Is voorzien van een custom date parser.
     *
     * Meer info op [https://github.com/square/moshi/tree/master/adapters] (wordt door moshi aangeraden dus depricated?)
     */
    @Provides
    @Singleton
    internal fun provideJSONConverter(): retrofit2.Converter.Factory {
        val moshi = Moshi.Builder()
            .add(Date::class.java, DateParser().nullSafe())
            .build()
        return MoshiConverterFactory.create(moshi)
    }

    /**
     * Return [retrofit2.CallAdapter.Factory] object als een [retrofit2.CallAdapter.Factory] dat de calls naar de api managed.
     */
    @Provides
    @Singleton
    internal fun provideCallAdapterFactory(): retrofit2.CallAdapter.Factory {
        return RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io())
    }

    /**
     * Return [Context] object dat de context van de applicatie bij een heel vroeg stadium van de app al kan voorzien.
     */
    @Provides
    @Singleton
    fun provideApplicationContext(): Context {
        return context.applicationContext
    }
}