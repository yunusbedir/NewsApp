package com.yunusbedir.appcentnewsapp.ui.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.yunusbedir.appcentnewsapp.R
import com.yunusbedir.appcentnewsapp.databinding.FragmentNewsBinding
import com.yunusbedir.appcentnewsapp.di.ViewModelFactory
import com.yunusbedir.appcentnewsapp.ui.BaseFragment
import javax.inject.Inject

class NewsFragment : BaseFragment() {

    private lateinit var binding: FragmentNewsBinding

    private val newsViewModel by viewModels<NewsViewModel> { factory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        newsViewModel.fetchNews("")
    }

    override fun initListeners() {

    }

    override fun initObservers() {

    }

}