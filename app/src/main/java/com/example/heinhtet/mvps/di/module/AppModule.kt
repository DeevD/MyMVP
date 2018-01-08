package com.example.heinhtet.mvps.di.module

import android.app.Application
import android.content.Context
import com.example.heinhtet.mvps.di.scope.ApplicationContext
import dagger.Module
import dagger.Provides

/**
 * Created by heinhtet on 11/22/2017.
 */

@Module(includes = arrayOf(ApiModule::class))
class AppModule(val application: Application) {

    @Provides

    internal fun provideApplication(): Application {
        return application
    }

    @Provides
    @ApplicationContext
    internal fun provideContext(): Context {
        return application
    }

}