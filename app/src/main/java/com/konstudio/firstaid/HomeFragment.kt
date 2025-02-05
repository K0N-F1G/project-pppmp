package com.konstudio.firstaid

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.konstudio.firstaid.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        val db = MainDb.getDb(activity as Context)

        binding.btnUBP.setOnClickListener() {
            Thread {
                val savedVariant = db.getDao().findByName("chosenVariant")?.value.toString()
                var intent = Intent(context, UBPMPActivity::class.java)
                if (savedVariant == "Одностраничный") {
                    intent = Intent(context, UBPOPActivity::class.java)
                } else if (savedVariant == "Пролистываемый") {
                    intent = Intent(context, UBPSLIDEActivity::class.java)
                }
                startActivity(intent)
            }.start()
        }
//        binding.btnUBPMP.setOnClickListener() {
//            val intentMP = Intent(context, UBPMPActivity::class.java)
//            startActivity(intentMP)
//        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()
        // [button].setOnClickListener {navController.navigate(R.id.[fragment])}
    }
}