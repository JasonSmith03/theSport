package com.example.thesport

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.thesport.presentation.HomeScreen.HomeScreen
import com.example.thesport.presentation.ui.theme.TheSportTheme

const val TAG = "MainActivity"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TheSportTheme() {
                HomeScreen()
            }
        }
    }
}