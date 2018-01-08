package com.example.heinhtet.mvps.di.module

import com.example.heinhtet.mvps.local_data.PreferenceHelper
import com.example.heinhtet.mvps.network.ApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by heinhtet on 11/22/2017.
 */
@Module(includes = arrayOf(NetworkModule::class))
class ApiModule {

    @Provides
    @Singleton
    internal fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

//    @Provides
//    @Singleton
//    internal fun providePref(preferenceHelper: PreferenceHelper): PreferenceHelper = preferenceHelper
}