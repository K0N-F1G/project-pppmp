package com.konstudio.firstaid

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.konstudio.firstaid.Situations.SharedViewModel
import com.konstudio.firstaid.databinding.ActivityMainMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainMainBinding
    private val REQUEST_CODE = 1 // Request code for the activity result

    private lateinit var crntPageView: TextView
    private lateinit var txtHomeView: TextView
    private lateinit var txtSearchView: TextView
    private lateinit var txtSituationsView: TextView
    private lateinit var viewModel: SharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        crntPageView = binding.crntPage
        txtHomeView = binding.txtHome
        txtSearchView = binding.txtSearch
        txtSituationsView = binding.txtBook
        viewModel = ViewModelProvider(this).get(SharedViewModel::class.java)



        viewModel.crntPage.observe(this, Observer { newText ->
            crntPageView.setText(newText)
        })
        viewModel.txtHome.observe(this, Observer { newText ->
            txtHomeView.setText(newText)
        })
        viewModel.txtSearch.observe(this, Observer { newText ->
            txtSearchView.setText(newText)
        })
        viewModel.txtSituations.observe(this, Observer { newText ->
            txtSituationsView.setText(newText)
        })


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
//        binding.btnBookmark.setOnClickListener {
//            binding.crntPage.setText(R.string.topMenuSearch)
//            binding.txtHome.setText(R.string.bottomMenuHome)
//            binding.txtBookmark.setText(R.string.btnBookmark)
//            binding.txtSearch.setText(R.string.bottomMenuSearch)
//            binding.txtBook.setText(R.string.bottomMenuBook)
//            navController.navigate(R.id.favoritesFragment)
//        }
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        if (requestCode == REQUEST_CODE) {
//            if (resultCode == RESULT_OK) {
//                val navigateToHome = data?.getBooleanExtra("navigateToHome", false) ?: false
//                val navigateToSearch = data?.getBooleanExtra("navigateToSearch", false) ?: false
//                val navigateToBook = data?.getBooleanExtra("navigateToBook", false) ?: false
//                val navigateToSettings = data?.getBooleanExtra("navigateToSettings", false) ?: false
//
//                Log.d("MainActivity", "navigateToHome: $navigateToHome")
//                Log.d("MainActivity", "navigateToSearch: $navigateToSearch")
//                Log.d("MainActivity", "navigateToBook: $navigateToBook")
//                Log.d("MainActivity", "navigateToSettings: $navigateToSettings")
//
//                val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
//                val navController = navHostFragment.navController
//                if (navigateToHome) {
//                    binding.crntPage.setText(R.string.topMenuMain)
//                    binding.txtHome.setText(R.string.btnHome)
//                    binding.txtBookmark.setText(R.string.bottomMenuBookmark)
//                    binding.txtSearch.setText(R.string.bottomMenuSearch)
//                    binding.txtBook.setText(R.string.bottomMenuBook)
//                    navController.navigate(R.id.homeFragment)
//                } else if (navigateToSearch) {
//                    binding.crntPage.setText(R.string.topMenuSearch)
//                    binding.txtHome.setText(R.string.bottomMenuHome)
//                    binding.txtBookmark.setText(R.string.bottomMenuBookmark)
//                    binding.txtSearch.setText(R.string.btnSearch)
//                    binding.txtBook.setText(R.string.bottomMenuBook)
//                    navController.navigate(R.id.searchFragment)
//                } else if (navigateToBook) {
//                    binding.crntPage.setText(R.string.topMenuMain)
//                    binding.txtHome.setText(R.string.bottomMenuHome)
//                    binding.txtBookmark.setText(R.string.bottomMenuBookmark)
//                    binding.txtSearch.setText(R.string.bottomMenuSearch)
//                    binding.txtBook.setText(R.string.btnBook)
//                    navController.navigate(R.id.situationsFragment)
//                } else if (navigateToSettings) {
//                    binding.crntPage.setText(R.string.topMenuMain)
//                    binding.txtHome.setText(R.string.btnHome)
//                    binding.txtBookmark.setText(R.string.bottomMenuBookmark)
//                    binding.txtSearch.setText(R.string.bottomMenuSearch)
//                    binding.txtBook.setText(R.string.bottomMenuBook)
//                    navController.navigate(R.id.settingsFragment)
//                }
//
//            }
//        }
//    }
}