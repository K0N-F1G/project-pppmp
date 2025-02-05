package com.konstudio.firstaid

import android.os.Bundle
import android.text.Html
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.konstudio.firstaid.databinding.ActivityUbpSlideBinding

class UBPSLIDEActivity : AppCompatActivity() {
    lateinit var binding: ActivityUbpSlideBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUbpSlideBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}