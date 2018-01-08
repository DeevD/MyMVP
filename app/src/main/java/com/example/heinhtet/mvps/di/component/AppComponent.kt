package com.example.heinhtet.mvps.di.component

import android.app.Application
import android.content.Context
import com.example.heinhtet.mvps.data.DataCenter
import com.example.heinhtet.mvps.di.module.AppModule
import com.example.heinhtet.mvps.di.scope.ApplicationContext
import com.example.heinhtet.mvps.local_data.PreferenceHelper
import com.example.heinhtet.mvps.network.ApiService
import dagger.Component
import javax.inject.Singleton

/**
 * Created by heinhtet on 11/22/2017.
 */


@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {


    @ApplicationContext
    fun context(): Context

    fun application(): Application

    fun apiService(): ApiService

    fun dataCenter(): DataCenter

    fun pef() : PreferenceHelper

}