package com.example.heinhtet.mvps

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDexApplication
import com.example.heinhtet.mvps.di.component.AppComponent
import com.example.heinhtet.mvps.di.component.DaggerAppComponent
import com.example.heinhtet.mvps.di.module.AppModule
import com.example.heinhtet.mvps.di.module.NetworkModule
import timber.log.Timber

/**
 * Created by heinhtet on 11/22/2017.
 */
class App : MultiDexApplication() {

    var appComponent: AppComponent? = null

    companion object {
        operator fun get(context: Context): App {
            return context.applicationContext as App
        }
    }

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

    }

    var component: AppComponent
        get() {
            if (appComponent == null) {
                appComponent = DaggerAppComponent.builder()
                        .appModule(AppModule(this))
                        .networkModule(NetworkModule(this))
                        .build()
            }
            return appComponent as AppComponent
        }
        set(appComponent) {
            this.appComponent = appComponent
        }

}