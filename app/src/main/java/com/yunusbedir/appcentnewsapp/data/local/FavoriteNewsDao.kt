package com.yunusbedir.appcentnewsapp.data.local

import androidx.room.*
import com.yunusbedir.appcentnewsapp.data.model.FavoriteNews


/**
 * Created by YUNUS BEDİR on 1.08.2021.
 */
@Dao
interface FavoriteNewsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoriteNews(favoriteNews: FavoriteNews)

    @Delete
    suspend fun deleteFavoriteNews(favoriteNews: FavoriteNews)

    @Query("SELECT * FROM FavoriteNews")
    suspend fun selectAllFavoriteNews(): List<FavoriteNews>

    @Query("SELECT * FROM FavoriteNews WHERE url = :url ")
    suspend fun getFavoriteNews(url: String): FavoriteNews?

}