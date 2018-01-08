package com.example.heinhtet.mvps.data

import com.example.heinhtet.mvps.local_data.PreferenceHelper
import com.example.heinhtet.mvps.network.ApiService
import com.example.heinhtet.mvps.network.data.CharactersList
import retrofit2.http.Query
import rx.Observable
import rx.Single
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by heinhtet on 11/22/2017.
 */

@Singleton
class DataCenter @Inject constructor(val apiService: ApiService, var preferenceHelper: PreferenceHelper) {


    fun getName(): String {
        return preferenceHelper.getName()
    }

    fun getCharacterLists(ts: String, apikay: String, hashkey: String): io.reactivex.Observable<CharactersList> {
        return apiService.getCharactersList(ts, apikay, hashkey)
    }

}