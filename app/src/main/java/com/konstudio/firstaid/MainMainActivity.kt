package com.konstudio.firstaid

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.konstudio.firstaid.databinding.ActivityMainMainBinding

class MainMainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController


        binding.btnSettings.setOnClickListener { view ->
            binding.crntPage.setText(R.string.topMenuSettings)
            binding.txtHome.setText(R.string.bottomMenuHome)
            binding.txtBookmark.setText(R.string.bottomMenuBookmark)
            binding.txtSearch.setText(R.string.bottomMenuSearch)
            binding.txtBook.setText(R.string.bottomMenuBook)
            navController.navigate(R.id.settingsFragment)
        }
        binding.btnHome.setOnClickListener {
            binding.crntPage.setText(R.string.topMenuMain)
            binding.txtHome.setText(R.string.btnHome)
            binding.txtBookmark.setText(R.string.bottomMenuBookmark)
            binding.txtSearch.setText(R.string.bottomMenuSearch)
            binding.txtBook.setText(R.string.bottomMenuBook)
            navController.navigate(R.id.homeFragment)
        }
        binding.btnBook.setOnClickListener {
            binding.crntPage.setText(R.string.topMenuBook)
            binding.txtHome.setText(R.string.bottomMenuHome)
            binding.txtBookmark.setText(R.string.bottomMenuBookmark)
            binding.txtSearch.setText(R.string.bottomMenuSearch)
            binding.txtBook.setText(R.string.btnBook)
            navController.navigate(R.id.situationsFragment)
        }
        binding.btnSearch.setOnClickListener {
            binding.crntPage.setText(R.string.topMenuSearch)
            binding.txtHome.setText(R.string.bottomMenuHome)
            binding.txtBookmark.setText(R.string.bottomMenuBookmark)
            binding.txtSearch.setText(R.string.btnSearch)
            binding.txtBook.setText(R.string.bottomMenuBook)
            navController.navigate(R.id.searchFragment)
        }
        binding.btnBookmark.setOnClickListener {
            binding.crntPage.setText(R.string.topMenuSearch)
            binding.txtHome.setText(R.string.bottomMenuHome)
            binding.txtBookmark.setText(R.string.btnBookmark)
            binding.txtSearch.setText(R.string.bottomMenuSearch)
            binding.txtBook.setText(R.string.bottomMenuBook)
            navController.navigate(R.id.favoritesFragment)
        }
    }
}