package com.example.heinhtet.mvps.di.component

import com.MyFragment
import com.example.heinhtet.mvps.di.module.FragmentModule
import com.example.heinhtet.mvps.di.scope.PerFragment
import dagger.Component

/**
 * Created by heinhtet on 11/29/2017.
 */
@PerFragment
@Component(dependencies = arrayOf(AppComponent::class),modules = arrayOf(FragmentModule::class))
interface MyFragmentComponent
{
    fun glue(myFragment:MyFragment)
}