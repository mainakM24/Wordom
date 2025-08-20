package com.example.wordom.data.repositories

import com.example.wordom.data.remote.RetrofitInstance
import com.example.wordom.domain.models.WordData
import com.example.wordom.domain.repositories.WordRepository
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class WordRepositoryImpl : WordRepository {

    private val apiService by lazy { RetrofitInstance.getApiService() }

    override suspend fun getWordData(): Result<WordData> {
        return try {

            val currentDate = LocalDate.now().format(
                DateTimeFormatter.ofPattern("yyyy-MM-dd")
            )
            val response = apiService.fetchWordData(currentDate)
            Result.success(response)

        } catch (e : Exception) {
            Result.failure(e)
        }
    }
}