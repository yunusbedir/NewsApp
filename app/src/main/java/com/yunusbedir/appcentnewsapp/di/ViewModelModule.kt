package com.yunusbedir.appcentnewsapp.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yunusbedir.appcentnewsapp.ui.SharedViewModel
import com.yunusbedir.appcentnewsapp.ui.detail.NewsDetailViewModel
import com.yunusbedir.appcentnewsapp.ui.favorite.FavoritesViewModel
import com.yunusbedir.appcentnewsapp.ui.news.NewsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


/**
 * Created by YUNUS BEDİR on 31.07.2021.
 */
@Module
abstract class ViewModelModule {

    @Binds
    abstract fun binViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(NewsViewModel::class)
    abstract fun bindNewsViewModel(viewModel: NewsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FavoritesViewModel::class)
    abstract fun bindFavoritesViewModel(viewModel: FavoritesViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(NewsDetailViewModel::class)
    abstract fun bindNewsDetailViewModel(viewModel: NewsDetailViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SharedViewModel::class)
    abstract fun bindSharedViewModel(viewModel: SharedViewModel): ViewModel
}