package com.yunusbedir.appcentnewsapp.ui.news

import android.os.Bundle
import android.view.KeyEvent
import android.view.KeyEvent.KEYCODE_ENTER
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.yunusbedir.appcentnewsapp.common.adapter.NewsRecyclerViewAdapter
import com.yunusbedir.appcentnewsapp.data.remote.ApiErrorResponse
import com.yunusbedir.appcentnewsapp.data.remote.ApiSuccessResponse
import com.yunusbedir.appcentnewsapp.databinding.FragmentNewsBinding
import com.yunusbedir.appcentnewsapp.ui.BaseFragment
import com.yunusbedir.appcentnewsapp.ui.SharedViewModel


class NewsFragment : BaseFragment() {

    private lateinit var binding: FragmentNewsBinding

    private val newsViewModel by viewModels<NewsViewModel> { factory }
    private val sharedViewModel by activityViewModels<SharedViewModel> { factory }


    private val adapter: NewsRecyclerViewAdapter by lazy {
        NewsRecyclerViewAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.recyclerViewNews.adapter = adapter
        super.onViewCreated(view, savedInstanceState)
    }

    override fun initListeners() {
        binding.tilSearch.setStartIconOnClickListener {
            newsViewModel.fetchNews(binding.editTextSearch.text.toString())
        }

        binding.editTextSearch.setOnKeyListener { _, _, event ->
            if (event.action == KeyEvent.ACTION_UP && event.keyCode == KEYCODE_ENTER) {
                newsViewModel.fetchNews(binding.editTextSearch.text.toString())
            }
            false
        }

        adapter.setItemClickListener {
            sharedViewModel.selectArticle(it)
            findNavController().navigate(NewsFragmentDirections.actionNewsFragmentToNewsDetailFragment())
        }
    }

    override fun initObservers() {
        newsViewModel.newsList.observe(viewLifecycleOwner) {
            when (it) {
                is ApiSuccessResponse -> {
                    adapter.submitList(it.response)
                }
                is ApiErrorResponse -> {
                    Toast.makeText(context, it.errorMessage, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

}