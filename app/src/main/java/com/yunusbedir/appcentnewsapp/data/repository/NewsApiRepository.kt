package com.yunusbedir.appcentnewsapp.data.repository

import com.yunusbedir.appcentnewsapp.data.remote.service.NewsApiService
import javax.inject.Inject
import javax.inject.Singleton


/**
 * Created by YUNUS BEDİR on 30.07.2021.
 */
@Singleton
class NewsApiRepository @Inject constructor(
    val newsApiService: NewsApiService
)