package com.example.responsi1mobileh1d023047.data.network

import com.example.responsi1mobileh1d023047.data.model.SearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface ApiService {
    @GET("v4/teams/{id}")
    suspend fun getTeamDetail(
        @Path("id") teamId: Int
    ): Response<SearchResponse>

    @GET("v4/teams/{id}")
    suspend fun getTeamDetails(
        @Path("id") id: Int,
        @Header("X-Auth-Token") token: String
    ): Response<SearchResponse>
}