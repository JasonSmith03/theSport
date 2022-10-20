package com.example.thesport

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import com.example.thesport.presentation.HomeScreen.HomeScreen
import com.example.thesport.ui.theme.TheSportTheme

const val TAG = "MainActivity"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TheSportTheme() {
                Scaffold(
                ) { padding ->
                    HomeScreen(Modifier.padding(padding))
                }
            }
        }
    }
}