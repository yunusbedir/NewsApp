package com.yunusbedir.appcentnewsapp.di

import com.yunusbedir.appcentnewsapp.ui.detail.NewsDetailFragment
import com.yunusbedir.appcentnewsapp.ui.favorite.FavoritesFragment
import com.yunusbedir.appcentnewsapp.ui.news.NewsFragment
import com.yunusbedir.appcentnewsapp.ui.webview.WebViewFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * Created by YUNUS BEDİR on 30.07.2021.
 */
@Module
abstract class FragmentsModule {

    @ContributesAndroidInjector
    abstract fun contributesNewsFragment():NewsFragment

    @ContributesAndroidInjector
    abstract fun contributesFavoritesFragment():FavoritesFragment

    @ContributesAndroidInjector
    abstract fun contributesNewsDetailFragment():NewsDetailFragment

    @ContributesAndroidInjector
    abstract fun contributesWebViewFragment():WebViewFragment
}