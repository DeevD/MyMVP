package com.example.heinhtet.mvps.di.component

import com.example.heinhtet.mvps.di.module.ActivityModule
import com.example.heinhtet.mvps.di.module.FragmentModule
import com.example.heinhtet.mvps.di.scope.ConfigPersistent
import dagger.Component

/**
 * Created by heinhtet on 11/22/2017.
 */
@ConfigPersistent
@Component(dependencies = arrayOf(AppComponent::class))
interface ConfigPersistentComponent {


    fun activityComponent(activityModule: ActivityModule): ActivityComponent
    fun fragmentComponent(fragmentModul: FragmentModule): FragmentComponent


}