package com.example.heinhtet.mvps.di.component

import com.example.heinhtet.mvps.di.module.FragmentModule
import com.example.heinhtet.mvps.di.scope.PerFragment
import com.example.heinhtet.mvps.mvp.base.BaseFragment
import dagger.Subcomponent

/**
 * Created by heinhtet on 11/22/2017.
 */

/*
*
*
*   Subcomponent mean Component of each component because Fragment module is alrady in Conpersistant Component decla
*
*/

@PerFragment
@Subcomponent(modules = arrayOf(FragmentModule::class))
interface FragmentComponent {
    fun inject(baseFragment: BaseFragment)
}