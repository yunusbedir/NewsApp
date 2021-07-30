package com.yunusbedir.appcentnewsapp.di

import android.app.Application
import com.yunusbedir.appcentnewsapp.MainApplication
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


/**
 * Created by YUNUS BEDİR on 30.07.2021.
 */
@Singleton
@Component(
    modules = [
        AppModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: Application):Builder

        fun build():AppComponent
    }

    fun inject(mainApplication: MainApplication)
}