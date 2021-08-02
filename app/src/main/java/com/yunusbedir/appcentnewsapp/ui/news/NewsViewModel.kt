package com.yunusbedir.appcentnewsapp.ui.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yunusbedir.appcentnewsapp.data.model.Article
import com.yunusbedir.appcentnewsapp.data.model.FavoriteNews
import com.yunusbedir.appcentnewsapp.data.remote.ApiErrorResponse
import com.yunusbedir.appcentnewsapp.data.remote.ApiResponse
import com.yunusbedir.appcentnewsapp.data.remote.ApiSuccessResponse
import com.yunusbedir.appcentnewsapp.data.repository.NewsApiRepository
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * Created by YUNUS BEDİR on 30.07.2021.
 */
class NewsViewModel @Inject constructor(
    private val newsApiRepository: NewsApiRepository
) : ViewModel() {

    private val _newsList = MutableLiveData<ApiResponse<List<FavoriteNews>>>()
    val newsList = _newsList as LiveData<ApiResponse<List<FavoriteNews>>>

    fun fetchNews(searchText: String) {
        viewModelScope.launch {
            try {
                val response = newsApiRepository.searchNews(searchText)
                val listNews = response.articles.map {
                    it.convertToFavoriteNews(false)
                }
                _newsList.postValue(ApiResponse.create(listNews))
            } catch (e: Exception) {
                e.printStackTrace()
                _newsList.postValue(ApiResponse.create(e))
            }
        }
    }

    fun fetchNextPageNews() {
        viewModelScope.launch {
            try {
                val response = newsApiRepository.nextPageNews()
                when (_newsList.value) {
                    is ApiErrorResponse ->{
                        val listNews = response.articles.map {
                            it.convertToFavoriteNews(false)
                        }
                        _newsList.postValue(ApiResponse.create(listNews))
                    }
                    is ApiSuccessResponse -> {
                        val newsListArray = arrayListOf<Article>().apply {
                            addAll((_newsList.value as ApiSuccessResponse<List<Article>>).response)
                            addAll(response.articles)
                        }
                        val listNews = newsListArray.map {
                            it.convertToFavoriteNews(false)
                        }
                        _newsList.postValue(ApiResponse.create(listNews))
                    }
                }
            } catch (e: Exception) {
                _newsList.postValue(ApiResponse.create(e))
            }
        }
    }

}