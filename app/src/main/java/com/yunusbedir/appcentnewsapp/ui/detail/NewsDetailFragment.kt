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
import java.lang.Exception

class NewsDetailFragment : BaseFragment() {

    private lateinit var binding: FragmentNewsDetailBinding

    private val sharedViewModel by activityViewModels<SharedViewModel> { factory }

    private lateinit var menu: Menu


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
            try {
                menu.findItem(R.id.item_favorite).isChecked = it.isFavoriteChecked
                menu.findItem(R.id.item_favorite).icon =
                if (it.isFavoriteChecked)
                    context?.getDrawable(R.drawable.ic_favorite)
                else
                    context?.getDrawable(R.drawable.ic_favorite_border)

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_toolbar_news_detail, menu)
        this.menu = menu
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_open_link -> {

            }
            R.id.item_favorite -> {
                item.isChecked = !item.isChecked
                if (item.isChecked) {
                    item.icon = context?.getDrawable(R.drawable.ic_favorite)
                    sharedViewModel.addFavoriteNews()
                }
                else {
                    item.icon = context?.getDrawable(R.drawable.ic_favorite_border)
                    sharedViewModel.removeFavoriteNews()
                }
            }
        }
        return true
    }
}