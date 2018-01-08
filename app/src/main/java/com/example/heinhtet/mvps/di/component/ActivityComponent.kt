package com.example.heinhtet.mvps.di.component

import com.example.heinhtet.mvps.MainActivity
import com.example.heinhtet.mvps.di.module.ActivityModule
import com.example.heinhtet.mvps.di.scope.PerActivity
import com.example.heinhtet.mvps.mvp.base.BaseActivity
import com.example.heinhtet.mvps.view.home.HomeActivity
import dagger.Subcomponent

/**
 * Created by heinhtet on 11/22/2017.
 */
@PerActivity
@Subcomponent(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun inject(baseActivity: BaseActivity)
    fun inject(mainActivity: MainActivity)
    fun inject(homeActivity: HomeActivity)


}