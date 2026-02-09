package com.konstudio.firstaid.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.konstudio.firstaid.Database.MainDb
import com.konstudio.firstaid.R
import com.konstudio.firstaid.Situations.SharedViewModel
import com.konstudio.firstaid.Situations.Multipage.MP_UBP_Activity
import com.konstudio.firstaid.Situations.Onepage.OP_UBP_Activity
import com.konstudio.firstaid.Situations.Slidable.SLIDE_UBP_Activity
import com.konstudio.firstaid.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val REQUEST_CODE = 1

    private lateinit var startForResult: ActivityResultLauncher<Intent>
    private lateinit var viewModel: SharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        startForResult = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == AppCompatActivity.RESULT_OK) {
                val data = result.data
                val navigateToHome = data?.getBooleanExtra("navigateToHome", false) ?: false
                val navigateToBook = data?.getBooleanExtra("navigateToBook", false) ?: false
                val navigateToSearch = data?.getBooleanExtra("navigateToSearch", false) ?: false
                val navigateToSettings = data?.getBooleanExtra("navigateToSettings", false) ?: false

                val navController = findNavController()

                if (navigateToHome) {
                    viewModel.crntPage.value = R.string.topMenuMain
                    viewModel.txtHome.value = R.string.btnHome
                    viewModel.txtSearch.value = R.string.bottomMenuSearch
                    viewModel.txtSituations.value = R.string.bottomMenuBook
                    navController.navigate(R.id.homeFragment)
                } else if (navigateToBook) {
                    viewModel.crntPage.value = R.string.topMenuBook
                    viewModel.txtHome.value = R.string.bottomMenuHome
                    viewModel.txtSearch.value = R.string.bottomMenuSearch
                    viewModel.txtSituations.value = R.string.btnBook
                    navController.navigate(R.id.situationsFragment)
                } else if (navigateToSearch) {
                    viewModel.crntPage.value = R.string.topMenuSearch
                    viewModel.txtHome.value = R.string.bottomMenuHome
                    viewModel.txtSearch.value = R.string.btnSearch
                    viewModel.txtSituations.value = R.string.bottomMenuBook
                    navController.navigate(R.id.searchFragment)
                } else if (navigateToSettings) {
                    viewModel.crntPage.value = R.string.topMenuSettings
                    viewModel.txtHome.value = R.string.bottomMenuHome
                    viewModel.txtSearch.value = R.string.bottomMenuSearch
                    viewModel.txtSituations.value = R.string.bottomMenuBook
                    navController.navigate(R.id.settingsFragment)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        val db = MainDb.Companion.getDb(requireContext())

        binding.btnUBP.setOnClickListener {
            Thread {
                val savedVariant = db.getDao().findByName("chosenVariant")?.value.toString()
                var intent = Intent(context, MP_UBP_Activity::class.java)
                if (savedVariant == "Одностраничный") {
                    intent = Intent(context, OP_UBP_Activity::class.java)
                } else if (savedVariant == "Пролистываемый") {
                    intent = Intent(context, SLIDE_UBP_Activity::class.java)
                }
                startForResult.launch(intent)
            }.start()
        }

        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}