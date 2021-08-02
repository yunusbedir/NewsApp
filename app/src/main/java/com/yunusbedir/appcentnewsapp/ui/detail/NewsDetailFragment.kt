package com.yunusbedir.appcentnewsapp.ui.detail

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.yunusbedir.appcentnewsapp.R
import com.yunusbedir.appcentnewsapp.common.expConvertToDateFormat
import com.yunusbedir.appcentnewsapp.common.loadUrl
import com.yunusbedir.appcentnewsapp.databinding.FragmentNewsDetailBinding
import com.yunusbedir.appcentnewsapp.ui.BaseFragment
import com.yunusbedir.appcentnewsapp.ui.SharedViewModel


class NewsDetailFragment : BaseFragment() {

    private lateinit var binding: FragmentNewsDetailBinding

    private val sharedViewModel by activityViewModels<SharedViewModel> { factory }

    private lateinit var menu: Menu


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
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
            binding.imageView.loadUrl(it.urlToImage)
            binding.textViewAuthor.text = it.author
            binding.textViewContent.text = it.content
            binding.textViewPublishDate.text = it.publishedAt.expConvertToDateFormat()
            binding.title.text = it.title
            try {
                menu.findItem(R.id.item_favorite).isChecked = it.isFavoriteChecked
                context?.let { context ->
                    menu.findItem(R.id.item_favorite).icon =
                        if (it.isFavoriteChecked)
                            AppCompatResources.getDrawable(context, R.drawable.ic_favorite)
                        else
                            AppCompatResources.getDrawable(context, R.drawable.ic_favorite_border)
                }
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
            R.id.item_share_url -> {
                sharedViewModel.selectedArticle.value?.let {
                    val i = Intent(Intent.ACTION_SEND)
                    i.type = "text/plain"
                    i.putExtra(Intent.EXTRA_SUBJECT, "Sharing URL")
                    i.putExtra(Intent.EXTRA_TEXT, it.url)
                    startActivity(Intent.createChooser(i, "Share URL"))
                }
            }
            R.id.item_favorite -> {
                item.isChecked = !item.isChecked
                context?.let { context ->
                    item.icon =
                        if (item.isChecked) {
                            sharedViewModel.addFavoriteNews()
                            AppCompatResources.getDrawable(context, R.drawable.ic_favorite)
                        } else {
                            sharedViewModel.removeFavoriteNews()
                            AppCompatResources.getDrawable(context, R.drawable.ic_favorite_border)
                        }
                }
            }
        }
        return true
    }
}