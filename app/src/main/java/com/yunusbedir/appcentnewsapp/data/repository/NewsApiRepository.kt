package com.yunusbedir.appcentnewsapp.data.repository

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
    private val newsApiService: NewsApiService
) {
    private var searchText: String = ""
    private var page: Int = 1

    suspend fun searchNews(search: String) =
        withContext(Dispatchers.IO) {
            searchText = search
            page = 1
            newsApiService.fetchNews(searchText, page)
        }

    suspend fun nextPageNews() =
        withContext(Dispatchers.IO) {
            page++
            newsApiService.fetchNews(searchText, page)
        }

}