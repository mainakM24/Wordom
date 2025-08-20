package com.example.wordom.data.remote

import com.example.wordom.BuildConfig
import com.example.wordom.domain.models.WordData
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("")
    suspend fun fetchWordData(
        @Query("date") date: String,
        @Query("api_key") api: String = BuildConfig.API_KEY
    ) : WordData
}