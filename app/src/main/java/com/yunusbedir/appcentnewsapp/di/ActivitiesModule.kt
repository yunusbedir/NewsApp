package com.yunusbedir.appcentnewsapp.di

import com.yunusbedir.appcentnewsapp.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * Created by YUNUS BEDİR on 30.07.2021.
 */
@Module
abstract class ActivitiesModule {

    @ContributesAndroidInjector(modules = [FragmentsModule::class])
    abstract fun contributesMainActivity(): MainActivity

}