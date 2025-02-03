package com.konstudio.firstaid

import android.os.Bundle
import android.text.Html
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.konstudio.firstaid.databinding.ActivityUbpOpBinding

class UBPOPActivity : AppCompatActivity() {
    lateinit var binding: ActivityUbpOpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUbpOpBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}