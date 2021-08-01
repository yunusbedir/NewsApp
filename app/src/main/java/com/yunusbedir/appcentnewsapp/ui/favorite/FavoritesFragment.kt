package com.yunusbedir.appcentnewsapp.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.yunusbedir.appcentnewsapp.common.adapter.NewsRecyclerViewAdapter
import com.yunusbedir.appcentnewsapp.databinding.FragmentFavoritesBinding
import com.yunusbedir.appcentnewsapp.ui.BaseFragment

class FavoritesFragment : BaseFragment() {

    private lateinit var binding: FragmentFavoritesBinding

    private val favoritesViewModel by viewModels<FavoritesViewModel> { factory }

    private val adapter: NewsRecyclerViewAdapter by lazy {
        NewsRecyclerViewAdapter()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.recyclerViewNews.adapter = adapter
        super.onViewCreated(view, savedInstanceState)
    }


    override fun initListeners() {
        adapter.setItemClickListener {
            findNavController().navigate(FavoritesFragmentDirections.actionFavoritesFragmentToNewsDetailFragment())
        }
    }

    override fun initObservers() {
        favoritesViewModel.newsList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }


}