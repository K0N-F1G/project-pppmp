package com.konstudio.firstaid.Fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.konstudio.firstaid.R
import com.konstudio.firstaid.Situations.SituationsAdapter
import com.konstudio.firstaid.Situations.SituationsData
import com.konstudio.firstaid.databinding.FragmentSearchBinding
import java.util.Locale

class SearchFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private var mList = ArrayList<SituationsData>()
    private lateinit var adapter: SituationsAdapter

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)

        recyclerView = binding.recyclerView
        searchView = binding.searchView

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(activity as Context)
        addDataToList()
        adapter = SituationsAdapter(mList)
        recyclerView.adapter = adapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }
        })


        return binding.root
    }

    private fun filterList(query : String?) {
        if (query != null) {
            val filteredList = ArrayList<SituationsData>()
            for (i in mList) {
                if (i.name.lowercase(Locale.ROOT).contains(query)) {
                    filteredList.add(i)
                }
            }

            if (filteredList.isEmpty()) {
                Log.d("SEARCH", "Подходящих инструкций не найдено - $query")
            } else {
                adapter.setFilteredList(filteredList)
            }
        }
    }

    private fun addDataToList() {
        mList.add(SituationsData("Устойчивое Боковое Положение", R.drawable.ic_user))
        mList.add(SituationsData("Кровотечение", R.drawable.ic_wound))
        mList.add(SituationsData("Укус", R.drawable.ic_mite))
        mList.add(SituationsData("Ожог", R.drawable.ic_fire))
        mList.add(SituationsData("Гипертония", R.drawable.ic_hypertension))
        mList.add(SituationsData("Гипотония", R.drawable.ic_hypotension))
        mList.add(SituationsData("Удушье", R.drawable.ic_choking))
        mList.add(SituationsData("Отравление", R.drawable.ic_poisoning))
        mList.add(SituationsData("Удар током", R.drawable.ic_electrical))
        mList.add(SituationsData("Обморожение", R.drawable.ic_hand))
        mList.add(SituationsData("Передозировка", R.drawable.ic_drugs))
        mList.add(SituationsData("СЛР", R.drawable.ic_cpr))
    }
}