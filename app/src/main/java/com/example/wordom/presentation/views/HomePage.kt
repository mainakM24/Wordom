package com.example.wordom.presentation.views

import android.text.Layout
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.wordom.presentation.viewmodels.HomeViewModel

@Composable
fun HomePage(modifier : Modifier) {
    val viewModel : HomeViewModel = viewModel<HomeViewModel>()
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

    uiState.value.data?.let { (name, partsOfSpeech, definition) ->
        Column(
            modifier = modifier.padding(32.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(horizontal = 8.dp)
            )

            Text(
                text = partsOfSpeech,
                style = MaterialTheme.typography.labelLarge,
                modifier = Modifier.padding(horizontal = 8.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = definition,
                modifier = Modifier.background(
                    color = MaterialTheme.colorScheme.surfaceBright,
                    shape = RoundedCornerShape(20)
                ).padding(16.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = {}, Modifier.fillMaxWidth() ,shape = RoundedCornerShape(20)) {
                Icon(Icons.Outlined.Favorite, contentDescription = "Add to Fav")
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text("Add to Favourite", fontWeight = FontWeight.ExtraBold, fontSize = 24.sp)
            }
        }
    }
}