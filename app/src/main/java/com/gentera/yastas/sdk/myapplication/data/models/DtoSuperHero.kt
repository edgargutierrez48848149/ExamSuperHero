package com.gentera.yastas.sdk.myapplication.data.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class DtoSuperHero(
    val response: String = "",
    val id: String = "",
    val name: String = "",
    val powerstats: PowerStats = PowerStats(),
    val biography: Biography = Biography(),
    val appearance: Appearance = Appearance(),
    val work: Work = Work(),
    val connections: Connections = Connections(),
    val image: Image = Image()
):Serializable

data class PowerStats(
    val intelligence: String = "",
    val strength: String = "",
    val speed: String = "",
    val durability: String = "",
    val power: String = "",
    val combat: String = ""
)

data class Biography(
    @SerializedName("full-name")
    val fullName: String = "",
    @SerializedName("alter-egos")
    val alterEgos: String = "",
    val aliases: List<String> = listOf(),
    @SerializedName("place-of-birth")
    val placeOfBirth: String = "",
    @SerializedName("first-appearance")
    val firstAppearance: String = "",
    val publisher: String = "",
    val alignment: String = ""
)

data class Appearance(
    val gender: String = "",
    val race: String = "",
    val height: List<String> = listOf(),
    val weight: List<String> = listOf(),
    @SerializedName("eye-color")
    val eyeColor: String = "",
    @SerializedName("hair-color")
    val hairColor: String = ""
)

data class Work(
    val occupation: String = "",
    val base: String = ""
)

data class Connections(
    @SerializedName("group-affiliation")
    val groupAffiliation: String = "",
    val relatives: String = ""
)

data class Image(
    val url: String = ""
)