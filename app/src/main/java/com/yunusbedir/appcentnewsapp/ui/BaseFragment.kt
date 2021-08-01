package com.yunusbedir.appcentnewsapp.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.yunusbedir.appcentnewsapp.di.ViewModelFactory
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject


/**
 * Created by YUNUS BEDİR on 30.07.2021.
 */
abstract class BaseFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelFactory

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
        initObservers()
    }

    abstract fun initListeners()

    abstract fun initObservers()
}