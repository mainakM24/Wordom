package com.example.wordom.data.repositories

import com.example.wordom.data.remote.RetrofitInstance
import com.example.wordom.data.models.WordData
import com.example.wordom.domain.models.Word
import com.example.wordom.domain.repositories.WordRepository
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class WordRepositoryImpl : WordRepository {

    private val apiService by lazy { RetrofitInstance.getApiService() }

    override suspend fun getWordData(): Result<Word> {
        return try {
            val currentDate = LocalDate.now().format(
                 DateTimeFormatter.ofPattern("yyyy-MM-dd")
            )
            val response = apiService.fetchWordData(currentDate)
            val wordResponse = Word(
                name = response.word,
                partsOfSpeech = response.definitions[0].partOfSpeech,
                definition = response.definitions[0].text
            )
            Result.success(wordResponse)
        } catch (e : Exception) {
            Result.failure(e)
        }
    }
}