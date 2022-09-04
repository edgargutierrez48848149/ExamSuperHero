package com.gentera.yastas.sdk.myapplication.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class VmNetwork:ViewModel() {

    private val networkIsConected = MutableLiveData<Boolean>()

    fun setIsConected(isConected: Boolean){
        networkIsConected.value = isConected
    }
    fun getIsConected(): LiveData<Boolean> {
        return networkIsConected
    }
}