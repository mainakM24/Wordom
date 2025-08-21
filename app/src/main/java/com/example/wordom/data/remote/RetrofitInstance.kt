package com.example.wordom.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance {
    fun getInstance() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.wordnik.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getApiService() : ApiService {
        return getInstance().create(ApiService::class.java)
    }
}