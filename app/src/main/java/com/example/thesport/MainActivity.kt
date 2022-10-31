package com.example.thesport

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.thesport.presentation.Home.NavGraphs
import com.example.thesport.presentation.ui.theme.TheSportTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import dagger.hilt.android.AndroidEntryPoint

const val TAG = "MainActivity"

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TheSportTheme() {
                DestinationsNavHost(navGraph = NavGraphs.root)
            }
        }
    }
}