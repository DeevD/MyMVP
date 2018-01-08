package com.example.heinhtet.mvps.di.module

import android.app.Activity
import android.content.Context
import com.example.heinhtet.mvps.di.scope.ActivityContext
import dagger.Module
import dagger.Provides

/**
 * Created by heinhtet on 11/22/2017.
 */

@Module
class ActivityModule(val activity: Activity) {

    @Provides
    internal fun provideActivity(): Activity {
        return activity
    }

    @Provides
    @ActivityContext
    internal fun provideContext(): Context {
        return activity
    }
}