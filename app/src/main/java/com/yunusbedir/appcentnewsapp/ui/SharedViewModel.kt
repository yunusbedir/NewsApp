package com.yunusbedir.appcentnewsapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yunusbedir.appcentnewsapp.data.model.Article
import com.yunusbedir.appcentnewsapp.data.model.FavoriteNews
import com.yunusbedir.appcentnewsapp.data.repository.NewsApiRepository
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * Created by YUNUS BEDİR on 1.08.2021.
 */
class SharedViewModel @Inject constructor(
    private val newsApiRepository: NewsApiRepository
) : ViewModel() {

    private val _selectedArticle = MutableLiveData<FavoriteNews?>()
    val selectedArticle = _selectedArticle as LiveData<FavoriteNews?>

    fun selectArticle(news: FavoriteNews?) {
        viewModelScope.launch {
            try {
                val favoriteNews = newsApiRepository.getFavoriteNews(news?.url ?: "")
                if (favoriteNews != null)
                    _selectedArticle.postValue(favoriteNews)
                else
                    _selectedArticle.postValue(news)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}