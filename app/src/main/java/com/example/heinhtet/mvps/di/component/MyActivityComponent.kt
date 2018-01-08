package com.example.heinhtet.mvps.di.component

import com.example.heinhtet.MyActivity
import com.example.heinhtet.mvps.di.module.ActivityModule
import com.example.heinhtet.mvps.di.scope.PerActivity
import dagger.Component

/**
 * Created by heinhtet on 11/27/2017.
 */
@PerActivity
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(ActivityModule::class))
interface MyActivityComponent {
    fun inject(myActivity: MyActivity)
}