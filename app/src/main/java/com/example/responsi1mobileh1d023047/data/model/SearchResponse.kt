package com.example.responsi1mobileh1d023047.data.model

import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("area")
    val area: Area?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("shortName")
    val shortName: String?,
    @SerializedName("tla")
    val tla: String?,
    @SerializedName("crest")
    val crest: String?,
    @SerializedName("address")
    val address: String?,
    @SerializedName("website")
    val website: String?,
    @SerializedName("founded")
    val founded: Int?,
    @SerializedName("clubColors")
    val clubColors: String?,
    @SerializedName("venue")
    val venue: String?,
    @SerializedName("runningCompetitions")
    val runningCompetitions: List<Competition>?,
    @SerializedName("coach")
    val coach: Coach?,
    @SerializedName("squad")
    val squad: List<Player>?,
    @SerializedName("staff")
    val staff: List<Any>?,
    @SerializedName("lastUpdated")
    val lastUpdated: String?
)


data class Area(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("code")
    val code: String?,
    @SerializedName("flag")
    val flag: String?
)

data class Competition(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("code")
    val code: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("emblem")
    val emblem: String?
)

data class Coach(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("firstName")
    val firstName: String?,
    @SerializedName("lastName")
    val lastName: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("dateOfBirth")
    val dateOfBirth: String?,
    @SerializedName("nationality")
    val nationality: String?,
    @SerializedName("contract")
    val contract: Contract?
)

data class Contract(
    @SerializedName("start")
    val start: String?,
    @SerializedName("until")
    val until: String?
)

data class Player(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("position")
    val position: String?,
    @SerializedName("dateOfBirth")
    val dateOfBirth: String?,
    @SerializedName("nationality")
    val nationality: String?
)