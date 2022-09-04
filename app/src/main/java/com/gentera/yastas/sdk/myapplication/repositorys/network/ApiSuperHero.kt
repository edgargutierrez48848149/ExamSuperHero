package com.gentera.yastas.sdk.myapplication.repositorys.network

import com.google.gson.JsonObject
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiSuperHero {
    @GET
    suspend fun getSuperHeroId(@Url url:String):JsonObject
}