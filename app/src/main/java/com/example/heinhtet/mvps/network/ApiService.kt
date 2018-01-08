package com.example.heinhtet.mvps.network

import com.example.heinhtet.mvps.network.data.CharactersList
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable
import rx.Single

/**
 * Created by heinhtet on 11/22/2017.
 */
interface ApiService {


    @GET("characters")
    fun getCharactersList(@Query("ts") ts: String, @Query("apikey") apikay: String, @Query("hash") hashkey: String): io.reactivex.Observable<CharactersList>


}