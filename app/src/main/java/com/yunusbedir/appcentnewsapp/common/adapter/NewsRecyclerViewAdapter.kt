package com.yunusbedir.appcentnewsapp.common.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yunusbedir.appcentnewsapp.common.loadUrl
import com.yunusbedir.appcentnewsapp.data.model.FavoriteNews
import com.yunusbedir.appcentnewsapp.databinding.ItemRecyclerViewNewsBinding


/**
 * Created by YUNUS BEDİR on 31.07.2021.
 */
class NewsRecyclerViewAdapter :
    ListAdapter<FavoriteNews, NewsRecyclerViewAdapter.NewsViewHolder>(NewsDiffUtil()) {

    private lateinit var listener: (FavoriteNews) -> Unit

    fun setItemClickListener(listener: (FavoriteNews) -> Unit) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }

    class NewsViewHolder(private val binding: ItemRecyclerViewNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: FavoriteNews, listener: ((FavoriteNews) -> Unit)?) {
            binding.textViewTitle.text = item.title
            binding.textViewDescription.text = item.description
            binding.imageView.loadUrl(item.urlToImage)
            binding.root.setOnClickListener {
                listener?.invoke(item)
            }
        }

        companion object {
            fun from(parent: ViewGroup): NewsViewHolder {
                val binding = ItemRecyclerViewNewsBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return NewsViewHolder(binding)
            }
        }
    }

    class NewsDiffUtil : DiffUtil.ItemCallback<FavoriteNews>() {
        override fun areItemsTheSame(oldItem: FavoriteNews, newItem: FavoriteNews): Boolean =
            oldItem.description == newItem.description

        override fun areContentsTheSame(oldItem: FavoriteNews, newItem: FavoriteNews): Boolean =
            oldItem.description == newItem.description

    }

}