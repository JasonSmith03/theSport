package com.example.thesport.domain.model

import androidx.compose.ui.graphics.vector.ImageVector
import com.example.thesport.presentation.destinations.DirectionDestination

data class MenuItem(
    val id: String,
    val title: String,
    val icon: ImageVector,
    val contentDescription: String,
    val destination: DirectionDestination
)