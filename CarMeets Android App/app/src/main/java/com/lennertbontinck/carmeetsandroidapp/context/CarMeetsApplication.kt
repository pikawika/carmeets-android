package com.lennertbontinck.carmeetsandroidapp.context

import android.app.Application
import android.content.Context
import com.lennertbontinck.carmeetsandroidapp.injection.components.DaggerNetworkComponent
import com.lennertbontinck.carmeetsandroidapp.injection.components.NetworkComponent
import com.lennertbontinck.carmeetsandroidapp.injection.modules.NetworkModule

class CarMeetsApplication: Application() {

    /**
     * Er is een instance nodig van de dagger [NetworkComponent] om de injectie mee uit te voeren.
     *
     * Deze injector zal alle viewmodels injecten en moet dus voorzien worden.
     */
    companion object {
        lateinit var injector: NetworkComponent

        /**
         * een instantie van de [Application] voor system wide gebruik van de context
         */
        private var instance: Application? = null

        /**
         * returnt de [Context] van de [Application]
         */
        fun getContext(): Context {
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        injector = DaggerNetworkComponent.
            builder().
            networkModule(NetworkModule(this)).
            build()
    }
}