package com.konstudio.firstaid

import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.util.Log
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

        binding.btnHome.setOnClickListener {
            val intent = Intent()
            intent.putExtra("navigateToHome", true)
            setResult(RESULT_OK, intent)
            finish()
        }
        binding.btnSearch.setOnClickListener {
            val intent = Intent()
            intent.putExtra("navigateToSearch", true)
            setResult(RESULT_OK, intent)
            finish()
        }
        binding.btnBook.setOnClickListener {
            val intent = Intent()
            intent.putExtra("navigateToBook", true)
            setResult(RESULT_OK, intent)
            finish()
        }
        binding.btnSettings.setOnClickListener {
            val intent = Intent()
            intent.putExtra("navigateToSettings", true)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}