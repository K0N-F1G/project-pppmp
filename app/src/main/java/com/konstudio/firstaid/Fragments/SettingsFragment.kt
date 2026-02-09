package com.konstudio.firstaid.Fragments

import android.R
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.konstudio.firstaid.Database.MainDb
import com.konstudio.firstaid.Database.SettingsItem
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
        val adapter =
            ArrayAdapter(activity as Context, R.layout.simple_spinner_dropdown_item, languages)
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
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
            binding.txtMultipage.setText(com.konstudio.firstaid.R.string.u_Multipage)
            binding.txtOnepage.setText(com.konstudio.firstaid.R.string.Onepage)
            binding.txtSlide.setText(com.konstudio.firstaid.R.string.Slide)
//            Toast.makeText(activity, "Когда-нибудь вариант изменится на многостраничный", Toast.LENGTH_SHORT).show()
            binding.layoutVariants.tag = "Многостраничный"
            Log.d("Variants", "Selected Multipage variant, tag: " + binding.layoutVariants.tag)
        }
        binding.layoutOnepage.setOnClickListener {
            binding.txtMultipage.setText(com.konstudio.firstaid.R.string.Multipage)
            binding.txtOnepage.setText(com.konstudio.firstaid.R.string.u_Onepage)
            binding.txtSlide.setText(com.konstudio.firstaid.R.string.Slide)
//            Toast.makeText(activity, "Когда-нибудь вариант изменится на одностраничный", Toast.LENGTH_SHORT).show()
            binding.layoutVariants.tag = "Одностраничный"
            Log.d("Variants", "Selected Onepage variant, tag: " + binding.layoutVariants.tag)
        }
        binding.layoutSlide.setOnClickListener {
            binding.txtMultipage.setText(com.konstudio.firstaid.R.string.Multipage)
            binding.txtOnepage.setText(com.konstudio.firstaid.R.string.Onepage)
            binding.txtSlide.setText(com.konstudio.firstaid.R.string.u_Slide)
//            Toast.makeText(activity, "Когда-нибудь вариант изменится на пролистываемый", Toast.LENGTH_SHORT).show()
            binding.layoutVariants.tag = "Пролистываемый"
            Log.d("Variants", "Selected Slide variant, tag: " + binding.layoutVariants.tag)
        }

        binding.btnSave.setOnClickListener {
            saveData()
        }

        return binding.root
    }

    private fun saveData() {
//        val sharedPreferences =  this.activity?.getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
//        val editor = sharedPreferences?.edit()
//
//        editor?.apply {
//            putBoolean("SWITCH_SMP", binding.switchSMP.isChecked)
//            putInt("SPINNER_LANGUAGE", binding.spinnerLanguage.selectedItemPosition)
//            putString("CHOSEN_VARIANT", binding.layoutVariants.tag.toString())
//            //            putString("TXT_MULTIPAGE", stateMultipage)
//            //            putString("TXT_ONEPAGE", stateOnepage)
//            //            putString("TXT_SLIDE", stateSlide)
//
//        }?.apply()

        // SQLite + ROOM
        val db = MainDb.Companion.getDb(activity as Context)

        fun updateValueByName(name: String, value: String) {
            val entity = db.getDao().findByName(name)
            entity?.let {
                it.value = value
                db.getDao().updateItem(it)
            }
        }

        Thread{
            //Кнопка вызова СМП
            if (db.getDao().findByName("switchSMP") == null) {
                Log.d("DB", "switchSMP is null")
                db.getDao().insertItem(
                    SettingsItem(
                        null,
                        "switchSMP",
                        binding.switchSMP.isChecked.toString()
                    )
                )
            } else {
                updateValueByName("switchSMP", binding.switchSMP.isChecked.toString())
            }
            //Вариант
            if (db.getDao().findByName("chosenVariant") == null) {
                Log.d("DB", "chosenVariant is null")
                db.getDao().insertItem(
                    SettingsItem(
                        null,
                        "chosenVariant",
                        binding.layoutVariants.tag.toString()
                    )
                )
            } else {
                updateValueByName("chosenVariant", binding.layoutVariants.tag.toString())
            }
        }.start()
        db.close()
        Toast.makeText(activity, "Сохранено!", Toast.LENGTH_SHORT).show()
    }

    private fun loadData() {

        //ROOM
        val db = MainDb.Companion.getDb(activity as Context)
        Thread {
            val savedBooleanSwitchSMP = db.getDao().findByName("switchSMP")?.value
            val savedVariant = db.getDao().findByName("chosenVariant")?.value
            Log.d("DB", "savedBooleanSwitchSMp = $savedBooleanSwitchSMP\nsavedVariant = $savedVariant")


            if (savedBooleanSwitchSMP != null) {
                requireActivity().runOnUiThread {
                    binding.switchSMP.isChecked = savedBooleanSwitchSMP.toBoolean()
                }
            }

            if (savedVariant == "Одностраничный") {
                requireActivity().runOnUiThread {
                    binding.layoutVariants.tag = savedVariant
                    binding.txtMultipage.setText(com.konstudio.firstaid.R.string.Multipage)
                    binding.txtOnepage.setText(com.konstudio.firstaid.R.string.u_Onepage)
                    binding.txtSlide.setText(com.konstudio.firstaid.R.string.Slide)
                }
            } else if (savedVariant == "Пролистываемый") {
                    requireActivity().runOnUiThread {
                        binding.layoutVariants.tag = savedVariant
                        binding.txtMultipage.setText(com.konstudio.firstaid.R.string.Multipage)
                        binding.txtOnepage.setText(com.konstudio.firstaid.R.string.Onepage)
                        binding.txtSlide.setText(com.konstudio.firstaid.R.string.u_Slide)
                    }
            } else {
                    requireActivity().runOnUiThread {
                        binding.layoutVariants.tag = "Многостраничный"
                        binding.txtMultipage.setText(com.konstudio.firstaid.R.string.u_Multipage)
                        binding.txtOnepage.setText(com.konstudio.firstaid.R.string.Onepage)
                        binding.txtSlide.setText(com.konstudio.firstaid.R.string.Slide)
                    }
            }
        }.start()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}