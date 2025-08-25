package com.example.wordom.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wordom.domain.models.Word
import com.example.wordom.domain.usecases.GetFavWordUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FavouriteViewModel(
    private val getFavWordUseCase: GetFavWordUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(FavUiState())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            getFavouriteWords()
        }
    }

    suspend fun getFavouriteWords() {
        getFavWordUseCase()
            .onStart { _uiState.update { FavUiState(isLoading = true) } }
            .onEach { result ->
                    _uiState.update { FavUiState(data = result) }
            }
            .catch { error ->
                _uiState.update { FavUiState(error = error.message.toString()) }
            }.launchIn(viewModelScope)
    }
}

data class FavUiState(
    val isLoading : Boolean = false,
    val error : String = "",
    val data : List<Word>? = null
)