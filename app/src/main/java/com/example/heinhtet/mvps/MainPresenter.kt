package com.example.heinhtet.mvps

import com.dev.sample.features.base.BasePresenter
import com.example.heinhtet.mvps.data.DataCenter
import javax.inject.Inject

/**
 * Created by heinhtet on 11/22/2017.
 */
class MainPresenter
@Inject
constructor(private val dataCenter: DataCenter) : BasePresenter<MainMvpView>() {

    fun getName():String{
        return dataCenter.getName()
    }
}
