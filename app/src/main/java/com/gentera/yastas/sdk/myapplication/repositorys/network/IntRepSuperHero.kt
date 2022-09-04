package com.gentera.yastas.sdk.myapplication.repositorys.network

import com.gentera.yastas.sdk.myapplication.data.models.DtoSuperHero

interface IntRepSuperHero {
    
    suspend fun getSuperHeroId(url:String): DtoSuperHero
}