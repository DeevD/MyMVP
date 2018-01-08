package com.example.heinhtet.mvps.local_data

import android.content.Context
import android.content.SharedPreferences
import com.example.heinhtet.mvps.di.scope.ApplicationContext
import javax.annotation.Signed
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by heinhtet on 11/22/2017.
 */
class PreferenceHelper @Inject constructor(@ApplicationContext context: Context) {

    private val preferences: SharedPreferences

    init {
        preferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE)
    }

    fun clear() {
        preferences.edit().clear().apply()
    }

    companion object {
        val PREF_FILE_NAME = "mvpstarter_pref_file"
    }

    fun setName(n:String){
        preferences.edit().putString("testing","heihtet2")
    }

    fun getName() :String{
        return preferences.getString("testing","heinhtet")
    }

}