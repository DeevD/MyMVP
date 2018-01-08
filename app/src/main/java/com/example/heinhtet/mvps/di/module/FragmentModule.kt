package com.example.heinhtet.mvps.di.module

import android.app.Activity
import android.content.Context
import android.support.v4.app.Fragment
import com.example.heinhtet.mvps.di.scope.ApplicationContext
import dagger.Module
import dagger.Provides

/**
 * Created by heinhtet on 11/22/2017.
 */
@Module
class FragmentModule(val frag: Fragment) {

    @Provides
    internal fun provideFragment(): Fragment {
        return frag
    }

    @Provides
    internal fun provideActivity(): Activity {
        return frag.activity
    }

    @Provides
    @ApplicationContext
    internal fun provideContext(): Context {
        return frag.activity
    }

}