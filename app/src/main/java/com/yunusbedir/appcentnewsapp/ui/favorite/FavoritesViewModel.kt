package com.yunusbedir.appcentnewsapp.ui.favorite

import androidx.lifecycle.ViewModel
import com.yunusbedir.appcentnewsapp.data.repository.NewsApiRepository
import javax.inject.Inject


/**
 * Created by YUNUS BEDİR on 31.07.2021.
 */
class FavoritesViewModel @Inject constructor(
    private val newsApiRepository: NewsApiRepository
) : ViewModel()