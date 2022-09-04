package com.gentera.yastas.sdk.myapplication.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gentera.yastas.sdk.myapplication.repositorys.network.RepNetSuperHero

class VmFactory(private val repositoryMain: RepNetSuperHero): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(RepNetSuperHero::class.java).newInstance(repositoryMain)
    }
}