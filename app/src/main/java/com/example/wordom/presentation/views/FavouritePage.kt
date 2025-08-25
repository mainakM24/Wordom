package com.example.wordom.presentation.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.wordom.presentation.viewmodels.FavouriteViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun FavouritePage(modifier : Modifier = Modifier) {
    val viewModel : FavouriteViewModel = koinViewModel<FavouriteViewModel>()
    val uiState = viewModel.uiState.collectAsState()

    if (uiState.value.isLoading) {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }

    if (uiState.value.error.isNotEmpty()) {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = uiState.value.error)
        }
    }

    uiState.value.data?.let { words ->
        LazyColumn {
            items(words){ word ->
                Text(word.name)
            }
        }
    }
}