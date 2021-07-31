package com.yunusbedir.appcentnewsapp.ui.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.yunusbedir.appcentnewsapp.R
import com.yunusbedir.appcentnewsapp.databinding.FragmentFavoritesBinding
import com.yunusbedir.appcentnewsapp.ui.BaseFragment
import com.yunusbedir.appcentnewsapp.ui.news.NewsViewModel

class FavoritesFragment : BaseFragment() {

    private lateinit var binding: FragmentFavoritesBinding

    private val favoritesViewModel by viewModels<FavoritesViewModel> { factory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun initListeners() {

    }

    override fun initObservers() {

    }


}