package com.yunusbedir.appcentnewsapp.di

import android.app.Application
import androidx.room.Room
import com.yunusbedir.appcentnewsapp.BuildConfig
import com.yunusbedir.appcentnewsapp.common.adapter.NewsRecyclerViewAdapter
import com.yunusbedir.appcentnewsapp.data.local.FavoriteNewsDao
import com.yunusbedir.appcentnewsapp.data.local.RoomDB
import com.yunusbedir.appcentnewsapp.data.remote.service.NewsApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


/**
 * Created by YUNUS BEDİR on 30.07.2021.
 */
@Module
class AppModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().apply {
            readTimeout(30, TimeUnit.SECONDS)
            writeTimeout(30, TimeUnit.SECONDS)
        }.build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BuildConfig.NEWS_API_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

    @Singleton
    @Provides
    fun provideNewsApiService(retrofit: Retrofit): NewsApiService =
        retrofit.create(NewsApiService::class.java)

    @Singleton
    @Provides
    fun provideRoomDB(app: Application): RoomDB =
        Room.databaseBuilder(app, RoomDB::class.java, "appcent")
            .fallbackToDestructiveMigration()
            .build()

    @Singleton
    @Provides
    fun provideFavoriteNewsDao(roomDB: RoomDB): FavoriteNewsDao =
        roomDB.getFavoriteNewsDao()

    @Provides
    fun provideNewsAdapter(): NewsRecyclerViewAdapter =
        NewsRecyclerViewAdapter()
}