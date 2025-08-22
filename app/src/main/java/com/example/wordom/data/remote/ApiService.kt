package com.example.wordom.data.remote

import com.example.wordom.BuildConfig
import com.example.wordom.data.remote.models.WordData
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/v4/words.json/wordOfTheDay")
    suspend fun fetchWordData(
        @Query("date") date: String,
        @Query("api_key") api: String = BuildConfig.API_KEY
    ) : WordData
}