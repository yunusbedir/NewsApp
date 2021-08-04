package com.yunusbedir.appcentnewsapp.di

import dagger.Module
import dagger.android.AndroidInjector
import dagger.internal.Beta
import dagger.multibindings.Multibinds


/**
 * Created by YUNUS BEDİR on 30.07.2021.
 */
@Beta
@Module
abstract class AndroidInjectionModule private constructor() {
    @Multibinds
    abstract fun classKeyedInjectorFactories(): Map<Class<*>?, AndroidInjector.Factory<*>?>?
    @Multibinds
    abstract fun stringKeyedInjectorFactories(): Map<String?, AndroidInjector.Factory<*>?>?
}