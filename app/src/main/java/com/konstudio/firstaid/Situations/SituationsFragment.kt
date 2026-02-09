package com.konstudio.firstaid.Situations

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.konstudio.firstaid.R
import com.konstudio.firstaid.Situations.Multipage.MP_UBP_Activity
import com.konstudio.firstaid.Situations.Onepage.OP_UBP_Activity
import com.konstudio.firstaid.Situations.Slidable.SLIDE_UBP_Activity
import com.konstudio.firstaid.databinding.FragmentSituationsBinding

class SituationsFragment : Fragment() {

    private var _binding: FragmentSituationsBinding? = null
    private val binding get() = _binding!!

    private lateinit var startForResult: ActivityResultLauncher<Intent>
    private lateinit var viewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSituationsBinding.inflate(inflater, container, false)

        loadData()

        viewModel = _root_ide_package_.androidx.lifecycle.ViewModelProvider(requireActivity())
            .get(SharedViewModel::class.java)
        startForResult = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == AppCompatActivity.RESULT_OK) { // Use AppCompatActivity.RESULT_OK
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

        binding.btnUBPOP.setOnClickListener() {
//            val intentOP = Intent(context, UBPOPActivity::class.java)
//            startActivity(intentOP)
            Thread {
                val intent = Intent(
                    context,
                    OP_UBP_Activity::class.java
                )
                startForResult.launch(intent)
            }.start()
        }
        binding.btnUBPSLIDE.setOnClickListener() {
            Thread {
                val intent = Intent(
                    context,
                    SLIDE_UBP_Activity::class.java
                )
                startForResult.launch(intent)
            }.start()
        }
        binding.btnUBPMP.setOnClickListener() {
            Thread {
                val intent = Intent(
                    context,
                    MP_UBP_Activity::class.java
                )
                startForResult.launch(intent)
            }.start()
        }

        binding.iconAddFavoriteWound.setOnClickListener {
            if (binding.iconAddFavoriteWound.tag.toString() == "NotInFavorite") {
                binding.iconAddFavoriteWound.setImageResource(R.drawable.ic_favorite_filled)
                Log.d("IF",  binding.iconAddFavoriteWound.tag.toString() + "== NotInFavorite")
                binding.iconAddFavoriteWound.tag = "InFavorite"
            } else {
                binding.iconAddFavoriteWound.setImageResource(R.drawable.ic_favorite)
                Log.d("IF",  binding.iconAddFavoriteWound.tag.toString() + "!= NotInFavorite")
                binding.iconAddFavoriteWound.tag = "NotInFavorite"
            }
            saveData()
        }
        binding.iconAddFavoriteMite.setOnClickListener {
            if (binding.iconAddFavoriteMite.tag.toString() == "NotInFavorite") {
                binding.iconAddFavoriteMite.setImageResource(R.drawable.ic_favorite_filled)
                Log.d("IF",  binding.iconAddFavoriteMite.tag.toString() + "== NotInFavorite")
                binding.iconAddFavoriteMite.tag = "InFavorite"
            } else {
                binding.iconAddFavoriteMite.setImageResource(R.drawable.ic_favorite)
                Log.d("IF",  binding.iconAddFavoriteMite.tag.toString() + "!= NotInFavorite")
                binding.iconAddFavoriteMite.tag = "NotInFavorite"
            }
            saveData()
        }
        binding.iconAddFavoriteFire.setOnClickListener {
            if (binding.iconAddFavoriteFire.tag.toString() == "NotInFavorite") {
                binding.iconAddFavoriteFire.setImageResource(R.drawable.ic_favorite_filled)
                Log.d("IF",  binding.iconAddFavoriteFire.tag.toString() + "== NotInFavorite")
                binding.iconAddFavoriteFire.tag = "InFavorite"
            } else {
                binding.iconAddFavoriteFire.setImageResource(R.drawable.ic_favorite)
                Log.d("IF",  binding.iconAddFavoriteFire.tag.toString() + "!= NotInFavorite")
                binding.iconAddFavoriteFire.tag = "NotInFavorite"
            }
            saveData()
        }
        binding.iconAddFavoriteHypertension.setOnClickListener {
            if (binding.iconAddFavoriteHypertension.tag.toString() == "NotInFavorite") {
                binding.iconAddFavoriteHypertension.setImageResource(R.drawable.ic_favorite_filled)
                Log.d("IF",  binding.iconAddFavoriteHypertension.tag.toString() + "== NotInFavorite")
                binding.iconAddFavoriteHypertension.tag = "InFavorite"
            } else {
                binding.iconAddFavoriteHypertension.setImageResource(R.drawable.ic_favorite)
                Log.d("IF",  binding.iconAddFavoriteHypertension.tag.toString() + "!= NotInFavorite")
                binding.iconAddFavoriteHypertension.tag = "NotInFavorite"
            }
            saveData()
        }
        binding.iconAddFavoriteHypotension.setOnClickListener {
            if (binding.iconAddFavoriteHypotension.tag.toString() == "NotInFavorite") {
                binding.iconAddFavoriteHypotension.setImageResource(R.drawable.ic_favorite_filled)
                Log.d("IF",  binding.iconAddFavoriteHypotension.tag.toString() + "== NotInFavorite")
                binding.iconAddFavoriteHypotension.tag = "InFavorite"
            } else {
                binding.iconAddFavoriteHypotension.setImageResource(R.drawable.ic_favorite)
                Log.d("IF",  binding.iconAddFavoriteHypotension.tag.toString() + "!= NotInFavorite")
                binding.iconAddFavoriteHypotension.tag = "NotInFavorite"
            }
            saveData()
        }
        binding.iconAddFavoriteChoking.setOnClickListener {
            if (binding.iconAddFavoriteChoking.tag.toString() == "NotInFavorite") {
                binding.iconAddFavoriteChoking.setImageResource(R.drawable.ic_favorite_filled)
                Log.d("IF",  binding.iconAddFavoriteChoking.tag.toString() + "== NotInFavorite")
                binding.iconAddFavoriteChoking.tag = "InFavorite"
            } else {
                binding.iconAddFavoriteChoking.setImageResource(R.drawable.ic_favorite)
                Log.d("IF",  binding.iconAddFavoriteChoking.tag.toString() + "!= NotInFavorite")
                binding.iconAddFavoriteChoking.tag = "NotInFavorite"
            }
            saveData()
        }
        binding.iconAddFavoritePoisoning.setOnClickListener {
            if (binding.iconAddFavoritePoisoning.tag.toString() == "NotInFavorite") {
                binding.iconAddFavoritePoisoning.setImageResource(R.drawable.ic_favorite_filled)
                Log.d("IF",  binding.iconAddFavoritePoisoning.tag.toString() + "== NotInFavorite")
                binding.iconAddFavoritePoisoning.tag = "InFavorite"
            } else {
                binding.iconAddFavoritePoisoning.setImageResource(R.drawable.ic_favorite)
                Log.d("IF",  binding.iconAddFavoritePoisoning.tag.toString() + "!= NotInFavorite")
                binding.iconAddFavoritePoisoning.tag = "NotInFavorite"
            }
            saveData()
        }
        binding.iconAddFavoriteHand.setOnClickListener {
            if (binding.iconAddFavoriteHand.tag.toString() == "NotInFavorite") {
                binding.iconAddFavoriteHand.setImageResource(R.drawable.ic_favorite_filled)
                Log.d("IF",  binding.iconAddFavoriteHand.tag.toString() + "== NotInFavorite")
                binding.iconAddFavoriteHand.tag = "InFavorite"
            } else {
                binding.iconAddFavoriteHand.setImageResource(R.drawable.ic_favorite)
                Log.d("IF",  binding.iconAddFavoriteHand.tag.toString() + "!= NotInFavorite")
                binding.iconAddFavoriteHand.tag = "NotInFavorite"
            }
            saveData()
        }
        binding.iconAddFavoriteBone.setOnClickListener {
            if (binding.iconAddFavoriteBone.tag.toString() == "NotInFavorite") {
                binding.iconAddFavoriteBone.setImageResource(R.drawable.ic_favorite_filled)
                Log.d("IF",  binding.iconAddFavoriteBone.tag.toString() + "== NotInFavorite")
                binding.iconAddFavoriteBone.tag = "InFavorite"
            } else {
                binding.iconAddFavoriteBone.setImageResource(R.drawable.ic_favorite)
                Log.d("IF",  binding.iconAddFavoriteBone.tag.toString() + "!= NotInFavorite")
                binding.iconAddFavoriteBone.tag = "NotInFavorite"
            }
            saveData()
        }
        binding.iconAddFavoriteElectrical.setOnClickListener {
            if (binding.iconAddFavoriteElectrical.tag.toString() == "NotInFavorite") {
                binding.iconAddFavoriteElectrical.setImageResource(R.drawable.ic_favorite_filled)
                Log.d("IF",  binding.iconAddFavoriteElectrical.tag.toString() + "== NotInFavorite")
                binding.iconAddFavoriteElectrical.tag = "InFavorite"
            } else {
                binding.iconAddFavoriteElectrical.setImageResource(R.drawable.ic_favorite)
                Log.d("IF",  binding.iconAddFavoriteElectrical.tag.toString() + "!= NotInFavorite")
                binding.iconAddFavoriteElectrical.tag = "NotInFavorite"
            }
            saveData()
        }
        binding.iconAddFavoriteDrugs.setOnClickListener {
            if (binding.iconAddFavoriteDrugs.tag.toString() == "NotInFavorite") {
                binding.iconAddFavoriteDrugs.setImageResource(R.drawable.ic_favorite_filled)
                Log.d("IF",  binding.iconAddFavoriteDrugs.tag.toString() + "== NotInFavorite")
                binding.iconAddFavoriteDrugs.tag = "InFavorite"
            } else {
                binding.iconAddFavoriteDrugs.setImageResource(R.drawable.ic_favorite)
                Log.d("IF",  binding.iconAddFavoriteDrugs.tag.toString() + "!= NotInFavorite")
                binding.iconAddFavoriteDrugs.tag = "NotInFavorite"
            }
            saveData()
        }
        binding.iconAddFavoriteCPR.setOnClickListener {
            if (binding.iconAddFavoriteCPR.tag.toString() == "NotInFavorite") {
                binding.iconAddFavoriteCPR.setImageResource(R.drawable.ic_favorite_filled)
                Log.d("IF",  binding.iconAddFavoriteCPR.tag.toString() + "== NotInFavorite")
                binding.iconAddFavoriteCPR.tag = "InFavorite"
            } else {
                binding.iconAddFavoriteCPR.setImageResource(R.drawable.ic_favorite)
                Log.d("IF",  binding.iconAddFavoriteCPR.tag.toString() + "!= NotInFavorite")
                binding.iconAddFavoriteCPR.tag = "NotInFavorite"
            }
            saveData()
        }



        return binding.root
        }

    private fun saveData() {
        val sharedPreferences =  this.activity?.getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences?.edit()

        editor?.apply {
            putString("WOUND_STATUS", binding.iconAddFavoriteWound.tag.toString())
            putString("MITE_STATUS", binding.iconAddFavoriteMite.tag.toString())
            putString("FIRE_STATUS", binding.iconAddFavoriteFire.tag.toString())
            putString("HYPERTENSION_STATUS", binding.iconAddFavoriteHypertension.tag.toString())
            putString("HYPOTENSION_STATUS", binding.iconAddFavoriteHypotension.tag.toString())
            putString("CHOKING_STATUS", binding.iconAddFavoriteChoking.tag.toString())
            putString("POISONING_STATUS", binding.iconAddFavoritePoisoning.tag.toString())
            putString("HAND_STATUS", binding.iconAddFavoriteHand.tag.toString())
            putString("BONE_STATUS", binding.iconAddFavoriteBone.tag.toString())
            putString("ELECTRICAL_STATUS", binding.iconAddFavoriteElectrical.tag.toString())
            putString("DRUGS_STATUS", binding.iconAddFavoriteDrugs.tag.toString())
            putString("CPR_STATUS", binding.iconAddFavoriteCPR.tag.toString())


        }?.apply()
    }

    private fun loadData() {
        val sharedPreferences = this.activity?.getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val savedWound = sharedPreferences?.getString("WOUND_STATUS", "NotInFavorite")
        val savedMite = sharedPreferences?.getString("MITE_STATUS", "NotInFavorite")
        val savedFire = sharedPreferences?.getString("FIRE_STATUS", "NotInFavorite")
        val savedHypertension = sharedPreferences?.getString("HYPERTENSION_STATUS", "NotInFavorite")
        val savedHypotension = sharedPreferences?.getString("HYPOTENSION_STATUS", "NotInFavorite")
        val savedChoking = sharedPreferences?.getString("CHOKING_STATUS", "NotInFavorite")
        val savedPoisoning = sharedPreferences?.getString("POISONING_STATUS", "NotInFavorite")
        val savedHand = sharedPreferences?.getString("HAND_STATUS", "NotInFavorite")
        val savedBone = sharedPreferences?.getString("BONE_STATUS", "NotInFavorite")
        val savedElectrical = sharedPreferences?.getString("ELECTRICAL_STATUS", "NotInFavorite")
        val savedDrugs = sharedPreferences?.getString("DRUGS_STATUS", "NotInFavorite")
        val savedCPR = sharedPreferences?.getString("CPR_STATUS", "NotInFavorite")


        if (savedWound == "InFavorite") {
            binding.iconAddFavoriteWound.tag = savedWound
            binding.iconAddFavoriteWound.setImageResource(R.drawable.ic_favorite_filled)
        } else {
            binding.iconAddFavoriteWound.tag = "NotInFavorite"
            binding.iconAddFavoriteWound.setImageResource(R.drawable.ic_favorite)
        }
        if (savedMite == "InFavorite") {
            binding.iconAddFavoriteMite.tag = savedMite
            binding.iconAddFavoriteMite.setImageResource(R.drawable.ic_favorite_filled)
        } else {
            binding.iconAddFavoriteMite.tag = "NotInFavorite"
            binding.iconAddFavoriteMite.setImageResource(R.drawable.ic_favorite)
        }
        if (savedFire == "InFavorite") {
            binding.iconAddFavoriteFire.tag = savedFire
            binding.iconAddFavoriteFire.setImageResource(R.drawable.ic_favorite_filled)
        } else {
            binding.iconAddFavoriteFire.tag = "NotInFavorite"
            binding.iconAddFavoriteFire.setImageResource(R.drawable.ic_favorite)
        }
        if (savedHypertension == "InFavorite") {
            binding.iconAddFavoriteHypertension.tag = savedHypertension
            binding.iconAddFavoriteHypertension.setImageResource(R.drawable.ic_favorite_filled)
        } else {
            binding.iconAddFavoriteHypertension.tag = "NotInFavorite"
            binding.iconAddFavoriteHypertension.setImageResource(R.drawable.ic_favorite)
        }
        if (savedHypotension == "InFavorite") {
            binding.iconAddFavoriteHypotension.tag = savedHypotension
            binding.iconAddFavoriteHypotension.setImageResource(R.drawable.ic_favorite_filled)
        } else {
            binding.iconAddFavoriteHypotension.tag = "NotInFavorite"
            binding.iconAddFavoriteHypotension.setImageResource(R.drawable.ic_favorite)
        }
        if (savedChoking == "InFavorite") {
            binding.iconAddFavoriteChoking.tag = savedChoking
            binding.iconAddFavoriteChoking.setImageResource(R.drawable.ic_favorite_filled)
        } else {
            binding.iconAddFavoriteChoking.tag = "NotInFavorite"
            binding.iconAddFavoriteChoking.setImageResource(R.drawable.ic_favorite)
        }
        if (savedPoisoning == "InFavorite") {
            binding.iconAddFavoritePoisoning.tag = savedPoisoning
            binding.iconAddFavoritePoisoning.setImageResource(R.drawable.ic_favorite_filled)
        } else {
            binding.iconAddFavoritePoisoning.tag = "NotInFavorite"
            binding.iconAddFavoritePoisoning.setImageResource(R.drawable.ic_favorite)
        }
        if (savedHand == "InFavorite") {
            binding.iconAddFavoriteHand.tag = savedHand
            binding.iconAddFavoriteHand.setImageResource(R.drawable.ic_favorite_filled)
        } else {
            binding.iconAddFavoriteHand.tag = "NotInFavorite"
            binding.iconAddFavoriteHand.setImageResource(R.drawable.ic_favorite)
        }
        if (savedBone == "InFavorite") {
            binding.iconAddFavoriteBone.tag = savedBone
            binding.iconAddFavoriteBone.setImageResource(R.drawable.ic_favorite_filled)
        } else {
            binding.iconAddFavoriteBone.tag = "NotInFavorite"
            binding.iconAddFavoriteBone.setImageResource(R.drawable.ic_favorite)
        }
        if (savedElectrical == "InFavorite") {
            binding.iconAddFavoriteElectrical.tag = savedElectrical
            binding.iconAddFavoriteElectrical.setImageResource(R.drawable.ic_favorite_filled)
        } else {
            binding.iconAddFavoriteElectrical.tag = "NotInFavorite"
            binding.iconAddFavoriteElectrical.setImageResource(R.drawable.ic_favorite)
        }
        if (savedDrugs == "InFavorite") {
            binding.iconAddFavoriteDrugs.tag = savedDrugs
            binding.iconAddFavoriteDrugs.setImageResource(R.drawable.ic_favorite_filled)
        } else {
            binding.iconAddFavoriteDrugs.tag = "NotInFavorite"
            binding.iconAddFavoriteDrugs.setImageResource(R.drawable.ic_favorite)
        }
        if (savedCPR == "InFavorite") {
            binding.iconAddFavoriteCPR.tag = savedCPR
            binding.iconAddFavoriteCPR.setImageResource(R.drawable.ic_favorite_filled)
        } else {
            binding.iconAddFavoriteCPR.tag = "NotInFavorite"
            binding.iconAddFavoriteCPR.setImageResource(R.drawable.ic_favorite)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()
        // [button].setOnClickListener {navController.navigate(R.id.[fragment])}
    }
}