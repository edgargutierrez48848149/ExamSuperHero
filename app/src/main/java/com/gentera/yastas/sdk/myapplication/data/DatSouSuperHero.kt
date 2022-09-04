package com.gentera.yastas.sdk.myapplication.data

import com.gentera.yastas.sdk.myapplication.repositorys.network.ApiSuperHero
import com.google.gson.JsonObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DatSouSuperHero(private val apiSuperHero: ApiSuperHero) {

    suspend fun getSuperHeroId(url:String):JsonObject{
        return withContext(Dispatchers.IO){
            apiSuperHero.getSuperHeroId(url)
        }
    }
}