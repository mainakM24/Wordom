package com.example.wordom.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wordom.data.models.WordData
import com.example.wordom.domain.models.Word
import com.example.wordom.domain.usecases.GetWordUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class HomeViewModel : ViewModel(){
    private val getWordUseCase : GetWordUseCase by lazy { GetWordUseCase() }
    private val _uiState = MutableStateFlow(UiState())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            fetchWord()
        }
    }

    fun fetchWord() {
        getWordUseCase()
            .onStart { _uiState.update { UiState(isLoading = true) } }
            .onEach { result ->
                if (result.isSuccess) {
                    _uiState.update { UiState(data = result.getOrThrow()) }
                } else {
                    _uiState.update { UiState(error = result.exceptionOrNull()?.message.toString()) }
                }
            }.catch { error ->
                _uiState.update { UiState(error = error.message.toString()) }
            }.launchIn(viewModelScope)
    }
}

data class UiState(
    val isLoading : Boolean = false,
    val error : String = "",
    val data: Word? = null
)