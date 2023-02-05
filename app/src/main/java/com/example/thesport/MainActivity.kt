package com.example.thesport

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.thesport.presentation.home.*
import com.example.thesport.presentation.home.destinations.HomeScreenDestination
import com.example.thesport.presentation.ui.theme.TheSportTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.manualcomposablecalls.composable
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TheSportTheme {
                DestinationsNavHost(navGraph = NavGraphs.root){
                    composable(HomeScreenDestination){
                        HomeScreen(navigator = destinationsNavigator)
                    }
                }
            }
        }
    }
}