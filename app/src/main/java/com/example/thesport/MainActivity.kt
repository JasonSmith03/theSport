package com.example.thesport

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.core.graphics.toColor
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

    override fun onResume() {
        super.onResume()
        when(this.resources?.configuration?.uiMode?.and(Configuration.UI_MODE_NIGHT_MASK)){
            Configuration.UI_MODE_NIGHT_NO -> {window.statusBarColor = resources.getColor(R.color.purple_500, null)}
            else -> {window.statusBarColor = resources.getColor(R.color.black, null)}
        }
    }
}