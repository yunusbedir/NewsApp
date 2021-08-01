package com.yunusbedir.appcentnewsapp.common.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yunusbedir.appcentnewsapp.data.model.Article
import com.yunusbedir.appcentnewsapp.databinding.ItemRecyclerViewNewsBinding


/**
 * Created by YUNUS BEDİR on 31.07.2021.
 */
class NewsRecyclerViewAdapter :
    ListAdapter<Article, NewsRecyclerViewAdapter.NewsViewHolder>(NewsDiffUtil()) {

    private lateinit var listener: (Article) -> Unit

    fun setItemClickListener(listener: (Article) -> Unit) {
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

        fun bind(item: Article, listener: ((Article) -> Unit)?) {
            binding.textViewTitle.text = item.title
            binding.textViewDescription.text = item.description
            Glide.with(binding.root.context).load(item.urlToImage).into(binding.imageView)
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

    class NewsDiffUtil : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean =
            oldItem.description == newItem.description

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean =
            oldItem.description == newItem.description

    }

}