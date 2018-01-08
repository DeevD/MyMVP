package com.example.heinhtet.mvps

import android.os.Bundle
import android.view.View
import android.widget.Toast
import butterknife.OnClick
import com.example.heinhtet.mvps.local_data.PreferenceHelper
import com.example.heinhtet.mvps.mvp.base.BaseActivity
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toFlowable
import io.reactivex.rxkotlin.toObservable

import rx.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class MainActivity : BaseActivity(), MainMvpView {

    @Inject lateinit var presenter: MainPresenter
    @Inject lateinit var pref: PreferenceHelper //  you can inject

    override fun layoutId(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent().inject(this)
        presenter.attachView(this)


        var ob = Observable.just(presenter.getName()).subscribe({
            Timber.i("ob" + it)
            Toast.makeText(this, "$it", Toast.LENGTH_SHORT).show()
        })

        Observable.just("hello World").map({

        })


        Observable.just("Hello, world!")
                .map<Any> { s -> s + " -Dan" }
                .subscribe { s -> println(s) }

        Observable.just("heinhtet")
                .map<Any> { s -> s + "heinhtet" }
                .subscribe { s ->
                    Toast.makeText(this, "hello$s", Toast.LENGTH_SHORT).show()
                }


        val list = listOf("Alpha", "Beta", "Gamma", "Delta", "Epsilon")

        list.toObservable() // extension function for Iterables
                .filter { it.length >= 5 }
                .subscribeBy(  // named arguments for lambda Subscribers
                        onNext = { println(it) },
                        onError = { it.printStackTrace() },
                        onComplete = { println("Done!") }

                )
        var intS = listOf(1, 1, 3, 5, 3)

        intS.toObservable()
                .subscribeBy(onError = { print(it) },
                        onComplete = { println("Done") }
                        , onNext = { Timber.i("Print" + it.toString()) })


        var myArray = ArrayList<String>()
        myArray.add("heinhtet")
        myArray.add("android")
        myArray.add("hello")

        myArray.toFlowable()
                .subscribeBy(onError = { callTimber(it.printStackTrace()) },
                        onNext = { callTimber(it) },
                        onComplete = { callTimber("Done") })

    }

    fun callTimber(mess: Any) {
        Timber.i("Log $mess")
    }

    fun query(string: String): () -> String {
        return { "1,2" }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }


    @OnClick(R.id.click)
    fun btnClick(v: View) {
        when (v.id) {
            R.id.click -> {


                Observable.just("hello wor" +
                        "ld").subscribeOn(io.reactivex.schedulers.Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe()
            }
        }

    }

}
