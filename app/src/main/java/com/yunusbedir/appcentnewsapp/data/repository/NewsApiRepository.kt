package com.yunusbedir.appcentnewsapp.data.repository

import com.yunusbedir.appcentnewsapp.data.local.FavoriteNewsDao
import com.yunusbedir.appcentnewsapp.data.model.FavoriteNews
import com.yunusbedir.appcentnewsapp.data.remote.service.NewsApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton


/**
 * Created by YUNUS BEDİR on 30.07.2021.
 */
@Singleton
class NewsApiRepository @Inject constructor(
    private val newsApiService: NewsApiService,
    private val favoriteNewsDao: FavoriteNewsDao
) {
    private var searchText: String = ""
    private var page: Int = 1

    suspend fun searchNews(search: String) =
        withContext(Dispatchers.IO) {
            searchText = search
            page = 1
            newsApiService.fetchNews(searchText, page)
        }

    suspend fun refreshNews() =
        withContext(Dispatchers.IO) {
            newsApiService.fetchNews(searchText, page)
        }

    suspend fun addFavoriteNews(favoriteNews: FavoriteNews) =
        withContext(Dispatchers.IO) {
            favoriteNewsDao.insertFavoriteNews(favoriteNews.apply { isFavoriteChecked = true })
        }

    suspend fun deleteFavoriteNews(favoriteNews: FavoriteNews) =
        withContext(Dispatchers.IO) {
            favoriteNewsDao.deleteFavoriteNews(favoriteNews)
        }

    suspend fun selectAllFavoriteNews() =
        withContext(Dispatchers.IO) {
            favoriteNewsDao.selectAllFavoriteNews()
        }

    suspend fun getFavoriteNews(url: String) =
        withContext(Dispatchers.IO) {
            favoriteNewsDao.getFavoriteNews(url)
        }


}