package com.example.wordom.domain.repositories

import com.example.wordom.domain.models.Word
import kotlinx.coroutines.flow.Flow

interface WordRepository {
    suspend fun getWordData(): Result<Word>
    suspend fun getFavouriteWords(): Flow<List<Word>>
    suspend fun insertFavouriteWord(word: Word)
}