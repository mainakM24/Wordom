package com.example.wordom.domain.repositories

import com.example.wordom.data.models.WordData
import com.example.wordom.domain.models.Word

interface WordRepository {
    suspend fun getWordData(): Result<Word>
}