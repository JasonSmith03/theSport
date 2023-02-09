package com.example.thesport

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.thesport.presentation.home.DrawerContents
import com.example.thesport.presentation.home.HomeScreenViewModel
import com.example.thesport.presentation.ui.theme.TheSportTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val homeScreenViewModel: HomeScreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TheSportTheme {
                DrawerContents(homeScreenViewModel)
            }
        }
    }
}