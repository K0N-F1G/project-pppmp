package com.konstudio.firstaid

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.konstudio.firstaid.databinding.ActivityMainBinding


class StartActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val text = SpannableString("Это спрограммированный макет мобильного приложения. Внешний вид приложения может быть изменён во время его дальнейшей разработки. \n\nУчтите, что на главной странице (следующей) из рабочих инструкций только 'Устойчивое Боковое Положение'")

        text.setSpan(ForegroundColorSpan(Color.RED), 206, 234, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
//        text.setSpan(ForegroundColorSpan(Color.RED), 239, 251, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        binding.txtMain.setText(text)

        binding.btnContinue.setOnClickListener {
            Log.d("Layouts", "Opened Home\nClosed Main")
            val homeIntent = Intent(this, MainActivity::class.java)
            startActivity(homeIntent)
            finish()
        }
    }
}