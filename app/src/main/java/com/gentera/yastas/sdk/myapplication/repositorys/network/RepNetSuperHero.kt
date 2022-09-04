package com.gentera.yastas.sdk.myapplication.repositorys.network

import com.gentera.yastas.sdk.myapplication.data.DatSouSuperHero
import com.gentera.yastas.sdk.myapplication.data.models.DtoSuperHero
import com.google.gson.Gson

class RepNetSuperHero(private val suppHerDatSou: DatSouSuperHero): IntRepSuperHero {

    private val gson = Gson()

    override suspend fun getSuperHeroId(url: String): DtoSuperHero {
        val jsonString = gson.toJson(suppHerDatSou.getSuperHeroId(url))
        return gson.fromJson(jsonString,DtoSuperHero::class.java)
    }
}