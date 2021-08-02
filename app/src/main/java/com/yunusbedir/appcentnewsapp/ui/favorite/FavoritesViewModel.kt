package com.yunusbedir.appcentnewsapp.ui.favorite

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
 * Created by YUNUS BEDİR on 31.07.2021.
 */
class FavoritesViewModel @Inject constructor(
    private val newsApiRepository: NewsApiRepository
) : ViewModel() {

    private val _newsList = MutableLiveData<List<FavoriteNews>>()
    val newsList = _newsList as LiveData<List<FavoriteNews>>

    fun getFavoritesNews() {
        viewModelScope.launch {
            try {
                val listNews = newsApiRepository.selectAllFavoriteNews()
                _newsList.postValue(listNews)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}