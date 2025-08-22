package com.example.wordom.domain.repositories

import com.example.wordom.domain.models.Word

interface WordRepository {
    suspend fun getWordData(): Result<Word>
    suspend fun getFavouriteWords(): Result<List<Word>>
}