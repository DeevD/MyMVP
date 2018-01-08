package com.example.heinhtet.mvps.view.home

import com.dev.sample.features.base.MvpView
import com.example.heinhtet.mvps.network.data.CharactersList

/**
 * Created by heinhtet on 11/23/2017.
 */
interface HomeMvpView : MvpView {

    fun setCharacherList(charactersList: CharactersList)
}