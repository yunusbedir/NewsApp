package com.yunusbedir.appcentnewsapp.ui.detail

import android.os.Bundle
import android.view.*
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.yunusbedir.appcentnewsapp.R
import com.yunusbedir.appcentnewsapp.databinding.FragmentNewsDetailBinding
import com.yunusbedir.appcentnewsapp.ui.BaseFragment
import com.yunusbedir.appcentnewsapp.ui.SharedViewModel

class NewsDetailFragment : BaseFragment() {

    private lateinit var binding: FragmentNewsDetailBinding

    private val newsDetailViewModel by viewModels<NewsDetailViewModel> { factory }
    private val sharedViewModel by activityViewModels<SharedViewModel> { factory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsDetailBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun initListeners() {
        binding.openWebView.setOnClickListener {
            findNavController().navigate(NewsDetailFragmentDirections.actionNewsDetailFragmentToWebViewFragment())
        }
    }

    override fun initObservers() {
        sharedViewModel.selectedArticle.observe(viewLifecycleOwner) {
            Glide.with(binding.root.context).load(it.urlToImage).into(binding.imageView)
            binding.textViewAuthor.text = it.author
            binding.textViewContent.text = it.content
            binding.textViewPublishDate.text = it.publishedAt
            binding.title.text = it.title
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_toolbar_news_detail, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        menu.findItem(R.id.item_favorite).icon = context?.getDrawable(R.drawable.ic_favorite_border)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_open_link -> {

            }
            R.id.item_favorite -> {

            }
        }
        return true
    }
}