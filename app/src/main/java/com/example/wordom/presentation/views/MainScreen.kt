package com.example.wordom.presentation.views

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.wordom.presentation.ui.theme.redditMonoFamily

@ExperimentalMaterial3Api
@Composable
fun MainScreen(modifier: Modifier = Modifier) {

    var selectedItem by remember { mutableStateOf("Home") }
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "WorDom",
                        style = MaterialTheme.typography.titleLarge
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                )
            )
        },
        bottomBar = {
           NavigationBar {
               NavigationBarItem(
                   selected = selectedItem == "Home",
                   onClick = { selectedItem = "Home" },
                   icon = { Icon(imageVector =  Icons.Default.Home, contentDescription = "Icon") },
                   label = { Text("Home") }
               );
               NavigationBarItem(
                   selected = selectedItem == "Favourite",
                   onClick = { selectedItem = "Favourite" },
                   icon = { Icon(imageVector =  Icons.Default.Favorite, contentDescription = "Icon") },
                   label = { Text("Favourite") }
               );
               NavigationBarItem(
                   selected = selectedItem == "Setting",
                   onClick = { selectedItem = "Setting" },
                   icon = { Icon(imageVector =  Icons.Default.Settings, contentDescription = "Icon") },
                   label = { Text("Setting") }
               );
           }
       }
    ) { innerPadding ->
        when (selectedItem) {
            "Home" -> HomePage(modifier = Modifier.padding(innerPadding).fillMaxSize())
            "Favourite" -> FavouritePage(modifier = Modifier.padding(innerPadding).fillMaxSize())
            "Setting" -> SettingPage(modifier = Modifier.padding(innerPadding))
        }
    }
}