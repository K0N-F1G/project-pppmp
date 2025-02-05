package com.konstudio.firstaid

import android.content.Intent
import android.os.Bundle
import android.text.Html
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.konstudio.firstaid.databinding.ActivityUbpMpBinding
import me.relex.circleindicator.CircleIndicator3


class UBPMPActivity : AppCompatActivity() {
    lateinit var binding: ActivityUbpMpBinding

    private var txtList = mutableListOf<String>()
    private var imgList = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUbpMpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        postToList()

        binding.viewPager2.adapter = ViewPagerAdapter(txtList, imgList)
        binding.viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        val indicator = findViewById<CircleIndicator3>(R.id.indicator)
        indicator.setViewPager(binding.viewPager2)
    }

    private fun addToList(txt: String, img: Int) {
        txtList.add(txt)
        imgList.add(img)
    }

    private fun postToList() {
        addToList(getString(R.string.ubp_1), R.drawable.ubp1)
        addToList(getString(R.string.ubp_2), R.drawable.ubp2)
        addToList(getString(R.string.ubp_3), R.drawable.ubp3)
        addToList(getString(R.string.ubp_4), R.drawable.ubp4)
    }
}