package com.konstudio.firstaid.Situations

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    val crntPage = MutableLiveData<Int>()
    val txtHome = MutableLiveData<Int>()
    val txtSearch = MutableLiveData<Int>()
    val txtSituations = MutableLiveData<Int>()
}