package com.yunusbedir.appcentnewsapp.ui

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.yunusbedir.appcentnewsapp.R
import com.yunusbedir.appcentnewsapp.databinding.ActivityMainBinding


class MainActivity : BaseActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpNavigation()
    }

    private fun setUpNavigation() {
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment?

        val navController = navHostFragment!!.navController
        NavigationUI.setupWithNavController(
            binding.bottomNavigation, navController
        )

        setSupportActionBar(binding.toolbar)
        val appBarConfiguration = AppBarConfiguration.Builder(
            setOf(R.id.favoritesFragment, R.id.newsFragment)
        ).build()
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)

    }
}