package com.yunusbedir.appcentnewsapp.data.remote.service

import com.yunusbedir.appcentnewsapp.BuildConfig
import com.yunusbedir.appcentnewsapp.data.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by YUNUS BEDİR on 30.07.2021.
 */
interface NewsApiService {

    @GET("everything")
    suspend fun fetchNews(
        @Query("q") searchText: String,
        @Query("page") page: Int,
        @Query("apiKey") apiKey: String = BuildConfig.NEWS_API_KEY,
    ): NewsResponse
}