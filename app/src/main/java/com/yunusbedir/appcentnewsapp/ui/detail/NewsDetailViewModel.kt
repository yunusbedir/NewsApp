package com.yunusbedir.appcentnewsapp.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yunusbedir.appcentnewsapp.data.model.FavoriteNews
import com.yunusbedir.appcentnewsapp.data.repository.NewsApiRepository
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * Created by YUNUS BEDİR on 3.08.2021.
 */
class NewsDetailViewModel @Inject constructor(
    private val newsApiRepository: NewsApiRepository
) : ViewModel() {

    fun removeFavoriteNews(favoriteNews: FavoriteNews?) {
        viewModelScope.launch {
            try {
                favoriteNews?.let { newsApiRepository.deleteFavoriteNews(it) }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun addFavoriteNews(favoriteNews: FavoriteNews?) {
        viewModelScope.launch {
            try {
                favoriteNews?.let { newsApiRepository.addFavoriteNews(it) }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}