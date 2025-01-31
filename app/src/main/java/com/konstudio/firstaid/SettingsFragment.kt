package com.konstudio.firstaid

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.konstudio.firstaid.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {
    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)

        val languages = arrayOf("Русский", "English")

        loadData()

        val spinner = binding.spinnerLanguage
        val adapter = ArrayAdapter(activity as Context, android.R.layout.simple_spinner_dropdown_item, languages)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.isEnabled = false
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
            Toast.makeText(activity, "Когда-нибудь вариант изменится на многостраничный", Toast.LENGTH_SHORT).show()
        }
        binding.layoutOnepage.setOnClickListener {
            Log.d("Variants", "Selected Onepage variant")
            binding.txtMultipage.setText(R.string.Multipage)
            binding.txtOnepage.setText(R.string.u_Onepage)
            binding.txtSlide.setText(R.string.Slide)
            Toast.makeText(activity, "Когда-нибудь вариант изменится на одностраничный", Toast.LENGTH_SHORT).show()
        }
        binding.layoutSlide.setOnClickListener {
            Log.d("Variants", "Selected Slide variant")
            binding.txtMultipage.setText(R.string.Multipage)
            binding.txtOnepage.setText(R.string.Onepage)
            binding.txtSlide.setText(R.string.u_Slide)
            Toast.makeText(activity, "Когда-нибудь вариант изменится на пролистываемый", Toast.LENGTH_SHORT).show()
        }

        binding.btnSave.setOnClickListener {
            saveData()
        }

        return binding.root
    }

    private fun saveData() {
        val sharedPreferences =  this.activity?.getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences?.edit()

        editor?.apply {
            putBoolean("SWITCH_SMP", binding.switchSMP.isChecked)
            putInt("SPINNER_LANGUAGE", binding.spinnerLanguage.selectedItemPosition)
            //            putString("TXT_MULTIPAGE", stateMultipage)
            //            putString("TXT_ONEPAGE", stateOnepage)
            //            putString("TXT_SLIDE", stateSlide)

        }?.apply()
        Toast.makeText(activity, "Сохранено... наверное...", Toast.LENGTH_SHORT).show()
    }

    private fun loadData() {
        val sharedPreferences = this.activity?.getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val savedBooleanSwitchSMP = sharedPreferences?.getBoolean("SWITCH_SMP", true)
        val savedLanguagePos = sharedPreferences?.getInt("SPINNER_LANGUAGE", 0)

        if (savedBooleanSwitchSMP != null) {
            binding.switchSMP.isChecked = savedBooleanSwitchSMP
        }
        if (savedLanguagePos != null) {
            binding.spinnerLanguage.setSelection(savedLanguagePos)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}