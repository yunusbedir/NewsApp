package com.yunusbedir.appcentnewsapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yunusbedir.appcentnewsapp.data.model.FavoriteNews


/**
 * Created by YUNUS BEDİR on 1.08.2021.
 */
@Database(
    entities = [
        FavoriteNews::class
    ],
    version = 1
)
abstract class RoomDB : RoomDatabase() {
    abstract fun getFavoriteNewsDao(): FavoriteNewsDao
}