package com.yunusbedir.appcentnewsapp.ui.detail

import androidx.lifecycle.ViewModel
import com.yunusbedir.appcentnewsapp.data.repository.NewsApiRepository
import javax.inject.Inject


/**
 * Created by YUNUS BEDİR on 31.07.2021.
 */
class NewsDetailViewModel @Inject constructor(
    private val newsApiRepository: NewsApiRepository
): ViewModel()