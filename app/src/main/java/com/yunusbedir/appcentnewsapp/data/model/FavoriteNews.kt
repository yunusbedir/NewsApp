package com.yunusbedir.appcentnewsapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * Created by YUNUS BEDİR on 1.08.2021.
 */
@Entity
class FavoriteNews(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val title: String,
    val urlToImage: String,
    var isFavoriteChecked: Boolean,
    @PrimaryKey
    val url: String
)