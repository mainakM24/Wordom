package com.example.wordom.domain.usecases

import com.example.wordom.domain.models.Word
import com.example.wordom.domain.repositories.WordRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetFavWordUseCase(
    private val repository : WordRepository
) {
    suspend operator fun invoke() : Flow<List<Word>> {
        return repository.getFavouriteWords()
    }
}