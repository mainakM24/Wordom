package com.example.wordom.domain.repositories

import com.example.wordom.domain.models.WordData

interface WordRepository {
    suspend fun getWordData(): Result<WordData>
}