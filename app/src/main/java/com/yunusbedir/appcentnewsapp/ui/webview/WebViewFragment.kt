package com.yunusbedir.appcentnewsapp.ui.webview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import androidx.fragment.app.activityViewModels
import com.yunusbedir.appcentnewsapp.databinding.FragmentWebViewBinding
import com.yunusbedir.appcentnewsapp.ui.BaseFragment
import com.yunusbedir.appcentnewsapp.ui.SharedViewModel


class WebViewFragment : BaseFragment() {

    private lateinit var binding: FragmentWebViewBinding

    private val sharedViewModel by activityViewModels<SharedViewModel> { factory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWebViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.webView.settings.javaScriptEnabled = true
        super.onViewCreated(view, savedInstanceState)
    }

    override fun initListeners() {
        binding.webView.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView, progress: Int) {
                if (progress == 100)
                    hideProgressBarHorizontal()
                else
                    setProgressBarHorizontal(progress)
            }
        }
    }

    override fun initObservers() {
        sharedViewModel.selectedArticle.observe(viewLifecycleOwner) {
            binding.webView.loadUrl(it?.url)
        }
    }

}