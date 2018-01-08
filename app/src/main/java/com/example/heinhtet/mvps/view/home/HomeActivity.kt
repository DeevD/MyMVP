package com.example.heinhtet.mvps.view.home

import android.os.Bundle
import com.example.heinhtet.mvps.R
import com.example.heinhtet.mvps.data.User
import com.example.heinhtet.mvps.di.need.Constants
import com.example.heinhtet.mvps.mvp.base.BaseActivity
import com.example.heinhtet.mvps.network.data.CharactersList
import com.example.heinhtet.mvps.utils.GenerateUrl
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by heinhtet on 11/23/2017.
 */
class HomeActivity : BaseActivity(), HomeMvpView {

    lateinit var user: User


    override fun setCharacherList(charactersList: CharactersList) {
        var text = StringBuilder()
//        Timber.i("response ${charactersList.toString()}")
        var list = charactersList.data?.results
        var array = ArrayList<String>()
        array.add("dasf")
        list!!.toObservable()
                .subscribeBy(
                        onNext = {
                            text.append(it.name + "\n")
                            testname.text = text
                            Timber.i("hero Name ${it.name}")
                        },
                        onComplete = { Timber.i("complete") },
                        onError = { "error" }
                )
    }

    @Inject lateinit var presenter: HomePresenter


    override fun layoutId(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent().inject(this)
        presenter.attachView(this)
        Timber.i("Generate Url ${GenerateUrl.getGenerateHashedUrl()}")
        var needToHash = GenerateUrl.timeStamp() + Constants.PRIVATE_KEY + Constants.PUBLIC_KEY
        presenter.getCharacter(GenerateUrl.timeStamp(), Constants.PUBLIC_KEY, GenerateUrl.createHash(needToHash))

    }


    fun helloWorld(message: String?, age: Int) {
        println(message)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()

    }

}