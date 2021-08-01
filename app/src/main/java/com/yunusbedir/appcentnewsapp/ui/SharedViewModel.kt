package com.yunusbedir.appcentnewsapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yunusbedir.appcentnewsapp.data.model.Article
import com.yunusbedir.appcentnewsapp.data.repository.NewsApiRepository
import javax.inject.Inject


/**
 * Created by YUNUS BEDİR on 1.08.2021.
 */
class SharedViewModel @Inject constructor(
    private val newsApiRepository: NewsApiRepository
) : ViewModel() {

    private val _selectedArticle = MutableLiveData<Article>()
    val selectedArticle = _selectedArticle as LiveData<Article>

    fun selectArticle(news: Article) {
        _selectedArticle.postValue(news)
    }

}