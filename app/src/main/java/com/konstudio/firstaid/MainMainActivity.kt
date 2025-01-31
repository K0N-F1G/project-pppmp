package com.konstudio.firstaid

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.konstudio.firstaid.databinding.ActivityMainMainBinding

class MainMainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainMainBinding
    lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        goToFragment(HomeFragment())

        binding.btnSettings.setOnClickListener {
            goToFragment(SettingsFragment())
            binding.crntPage.setText(R.string.topMenuSettings)
            binding.txtHome.setText(R.string.bottomMenuHome)
        }
        binding.btnHome.setOnClickListener {
            goToFragment(HomeFragment())
            binding.crntPage.setText(R.string.topMenuMain)
            binding.txtHome.setText(R.string.btnHome)
        }
    }

    private fun goToFragment(fragment: Fragment) {
        fragmentManager =  supportFragmentManager
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit()
    }

}