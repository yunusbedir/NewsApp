package com.yunusbedir.appcentnewsapp

import android.app.Application
import com.yunusbedir.appcentnewsapp.di.DaggerAppComponent


/**
 * Created by YUNUS BEDİR on 30.07.2021.
 */
class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)
    }
}