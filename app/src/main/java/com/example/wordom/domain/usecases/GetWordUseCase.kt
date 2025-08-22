package com.example.wordom.domain.usecases

import com.example.wordom.data.repositories.WordRepositoryImpl
import com.example.wordom.domain.models.Word
import com.example.wordom.domain.repositories.WordRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetWordUseCase {
    private val repository : WordRepository by lazy { WordRepositoryImpl() }

    operator fun invoke() = flow {
        val response = repository.getWordData()
        emit(response)
    }.catch {
        emit(Result.failure(it))
    }.flowOn(Dispatchers.IO)
}