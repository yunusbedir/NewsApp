package com.yunusbedir.appcentnewsapp.common

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import java.text.SimpleDateFormat
import java.util.*


/**
 * Created by YUNUS BEDİR on 2.08.2021.
 */

const val DATE_FORMAT = "dd.MM.yyyy"

fun String.expConvertToDateFormat(): String =
    try {
        val date = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:SSSXXX", Locale.getDefault()).parse(this)
        if (date != null)
            SimpleDateFormat(DATE_FORMAT, Locale.getDefault()).format(date)
        else
            this
    } catch (e: Exception) {
        this
    }

fun ImageView.loadUrl(url: String) {
    Glide.with(context)
        .load(url)
        .priority(Priority.HIGH)
        .into(this)
}