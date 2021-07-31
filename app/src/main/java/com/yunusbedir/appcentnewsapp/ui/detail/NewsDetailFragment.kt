package com.yunusbedir.appcentnewsapp.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.yunusbedir.appcentnewsapp.R
import com.yunusbedir.appcentnewsapp.databinding.FragmentNewsDetailBinding
import com.yunusbedir.appcentnewsapp.ui.BaseFragment
import com.yunusbedir.appcentnewsapp.ui.favorite.FavoritesViewModel

class NewsDetailFragment : BaseFragment() {

    private lateinit var binding: FragmentNewsDetailBinding

    private val newsDetailViewModel by viewModels<NewsDetailViewModel> { factory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun initListeners() {

    }

    override fun initObservers() {

    }


}