package com.konstudio.firstaid

import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.konstudio.firstaid.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {
    lateinit var binding: ActivitySettingsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val languages = arrayOf("Русский", "English")

        loadData()

        binding.btnHome.setOnClickListener {
            Log.d("Layouts", "Opened Home\nPaused Settings")
            val homeIntent = Intent(this, MainActivity::class.java)
            startActivity(homeIntent)
        }

        val spinner = binding.spinnerLanguage
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, languages)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, pos: Int, id: Long) {
//                Toast.makeText(applicationContext, "Когда-нибудь язык изменится на "+languages[pos], Toast.LENGTH_SHORT).show()
            }
            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }

        binding.layoutMultipage.setOnClickListener {
            Log.d("Variants", "Selected Multipage variant")
            binding.txtMultipage.setText(R.string.u_Multipage)
            binding.txtOnepage.setText(R.string.Onepage)
            binding.txtSlide.setText(R.string.Slide)
            Toast.makeText(applicationContext, "Когда-нибудь вариант изменится на многостраничный", Toast.LENGTH_SHORT).show()
        }
        binding.layoutOnepage.setOnClickListener {
            Log.d("Variants", "Selected Onepage variant")
            binding.txtMultipage.setText(R.string.Multipage)
            binding.txtOnepage.setText(R.string.u_Onepage)
            binding.txtSlide.setText(R.string.Slide)
            Toast.makeText(applicationContext, "Когда-нибудь вариант изменится на одностраничный", Toast.LENGTH_SHORT).show()
        }
        binding.layoutSlide.setOnClickListener {
            Log.d("Variants", "Selected Slide variant")
            binding.txtMultipage.setText(R.string.Multipage)
            binding.txtOnepage.setText(R.string.Onepage)
            binding.txtSlide.setText(R.string.u_Slide)
            Toast.makeText(applicationContext, "Когда-нибудь вариант изменится на пролистываемый", Toast.LENGTH_SHORT).show()
        }

        binding.btnSave.setOnClickListener {
            saveData()
        }

    }

    private fun saveData() {
        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        editor.apply {
            putBoolean("SWITCH_SMP", binding.switchSMP.isChecked)
            putInt("SPINNER_LANGUAGE", binding.spinnerLanguage.selectedItemPosition)
//            putString("TXT_MULTIPAGE", stateMultipage)
//            putString("TXT_ONEPAGE", stateOnepage)
//            putString("TXT_SLIDE", stateSlide)

        }.apply()
        Toast.makeText(this, "Сохранено... наверное...", Toast.LENGTH_SHORT).show()
    }

    private fun loadData() {
        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val savedBooleanSwitchSMP = sharedPreferences.getBoolean("SWITCH_SMP", true)
        val savedLanguagePos = sharedPreferences.getInt("SPINNER_LANGUAGE", 0)

        binding.switchSMP.isChecked = savedBooleanSwitchSMP
        binding.spinnerLanguage.setSelection(savedLanguagePos)
    }

}