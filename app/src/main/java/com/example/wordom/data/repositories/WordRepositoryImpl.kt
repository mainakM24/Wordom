package com.example.wordom.data.repositories

import android.content.Context
import com.example.wordom.data.local.WordomDatabase
import com.example.wordom.data.mappers.toDomainList
import com.example.wordom.data.remote.ApiService
import com.example.wordom.data.remote.RetrofitInstance
import com.example.wordom.data.remote.models.WordData
import com.example.wordom.domain.models.Word
import com.example.wordom.domain.repositories.WordRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class WordRepositoryImpl(
    private val apiService: ApiService,
    private val wordomDatabase: WordomDatabase
) : WordRepository {

    override suspend fun getWordData(): Result<Word> {
        return try {
            val currentDate = LocalDate.now().format(
                 DateTimeFormatter.ofPattern("yyyy-MM-dd")
            )
            val response = apiService.fetchWordData(currentDate)
            val wordResponse = Word(
                name = response.word,
                partsOfSpeech = response.definitions[0].partOfSpeech,
                definition = response.definitions[0].text,
                date = response.pdd
            )
            Result.success(wordResponse)
        } catch (e : Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getFavouriteWords(): Flow<List<Word>> {
        return wordomDatabase.getWordDao().getAllWord()
            .map { entities -> entities.toDomainList() }
    }
}