package com.example.heinhtet.mvps.view.home

import com.dev.sample.features.base.BasePresenter
import com.example.heinhtet.mvps.data.DataCenter
import com.example.heinhtet.mvps.utils.ErrorUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import retrofit2.HttpException
import timber.log.Timber
import javax.inject.Inject


/**
 * Created by heinhtet on 11/23/2017.
 */
class HomePresenter @Inject
constructor(val dataCenter: DataCenter) : BasePresenter<HomeMvpView>() {


    fun getCharacter(ts: String, apikay: String, hashkey: String) {
        dataCenter.getCharacterLists(ts, apikay, hashkey)
                .subscribeOn(io.reactivex.schedulers.Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ c ->
                    if (isViewAttached) {
                        mvpView?.apply {
                            setCharacherList(c)
                            Timber.i("charachterlist ${c.data?.results!![0].name}")
                        }
                    }

                }) { throwable ->
                    Timber.i("error code " + throwable)

                    if (throwable is HttpException) {
                        var body = ((throwable) as HttpException).response().errorBody()
                        Timber.i("Error Response ${ErrorUtils.getErrorResponse(body!!)}")
                    }
                }


    }
}