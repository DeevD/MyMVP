package com.example.heinhtet

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.heinhtet.mvps.App
import com.example.heinhtet.mvps.R
import com.example.heinhtet.mvps.di.component.DaggerAppComponent
import com.example.heinhtet.mvps.di.component.DaggerMyActivityComponent
import com.example.heinhtet.mvps.di.module.ActivityModule
import com.example.heinhtet.mvps.di.need.Constants
import com.example.heinhtet.mvps.mvp.base.BaseActivity
import com.example.heinhtet.mvps.network.data.CharactersList
import com.example.heinhtet.mvps.utils.GenerateUrl
import com.example.heinhtet.mvps.view.home.HomeMvpView
import com.example.heinhtet.mvps.view.home.HomePresenter
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by heinhtet on 11/27/2017.
 */
class MyActivity : AppCompatActivity(), HomeMvpView {
    override fun setCharacherList(charactersList: CharactersList) {
        Timber.i("response ${charactersList.data!!.results!![0].name}")
    }


    @Inject lateinit var presenter: HomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerMyActivityComponent.builder().appComponent(App[this].component)
                .activityModule(ActivityModule(this)).build().inject(this)
        presenter.attachView(this)
        Timber.i("Generate Url ${GenerateUrl.getGenerateHashedUrl()}")
        var needToHash = GenerateUrl.timeStamp() + Constants.PRIVATE_KEY + Constants.PUBLIC_KEY
        presenter.getCharacter(GenerateUrl.timeStamp(), Constants.PUBLIC_KEY, GenerateUrl.createHash(needToHash))
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }
}