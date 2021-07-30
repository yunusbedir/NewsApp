package com.yunusbedir.appcentnewsapp.ui

import android.content.Context
import androidx.fragment.app.Fragment
import dagger.android.support.AndroidSupportInjection


/**
 * Created by YUNUS BEDİR on 30.07.2021.
 */
abstract class BaseFragment : Fragment() {

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

}