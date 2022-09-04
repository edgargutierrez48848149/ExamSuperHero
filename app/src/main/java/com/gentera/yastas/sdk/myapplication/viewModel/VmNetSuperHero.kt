package com.gentera.yastas.sdk.myapplication.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.gentera.yastas.sdk.myapplication.core.ResponseStatus
import com.gentera.yastas.sdk.myapplication.repositorys.network.RepNetSuperHero
import kotlinx.coroutines.Dispatchers

class VmNetSuperHero(private val superHeroRepoNetSuperHero: RepNetSuperHero):ViewModel(){

    fun getSuperHeroId(url:String) = liveData(viewModelScope.coroutineContext + Dispatchers.Main){
        emit(ResponseStatus.Loaing())
        try {
            emit(ResponseStatus.Success(superHeroRepoNetSuperHero.getSuperHeroId(url)))
        }catch (e:Exception){
            emit(ResponseStatus.Error(e))
        }
    }
}