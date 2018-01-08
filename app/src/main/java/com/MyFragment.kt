package com

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.heinhtet.mvps.App
import com.example.heinhtet.mvps.R
import com.example.heinhtet.mvps.di.component.DaggerMyFragmentComponent
import com.example.heinhtet.mvps.di.component.MyFragmentComponent
import com.example.heinhtet.mvps.di.module.ActivityModule
import com.example.heinhtet.mvps.di.module.FragmentModule

/**
 * Created by heinhtet on 11/29/2017.
 */
class MyFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.activity_main, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DaggerMyFragmentComponent.builder().
                appComponent(App[activity].appComponent).
                fragmentModule(FragmentModule(this))
                .build().glue(this)
    }
}