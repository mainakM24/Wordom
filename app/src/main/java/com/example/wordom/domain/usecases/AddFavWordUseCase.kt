package com.example.wordom.domain.usecases

import com.example.wordom.domain.models.Word
import com.example.wordom.domain.repositories.WordRepository

class AddFavWordUseCase(
    private val repository: WordRepository
) {
    suspend operator fun invoke(word : Word) {
        return repository.insertFavouriteWord(word)
    }
}