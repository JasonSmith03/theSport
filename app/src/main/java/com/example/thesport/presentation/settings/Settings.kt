package com.example.thesport.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.thesport.presentation.settings.SettingsViewModel
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun SettingsPage(
//    modifier: Modifier = Modifier,
    viewModel: SettingsViewModel
) {

    val switchState = viewModel.switchState.collectAsState()

    Column {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            Text(text = "Change odds display")
            Switch(
                checked = switchState.value,
                onCheckedChange = {
                    viewModel.setSwitchState(!switchState.value)
                }
            )
        }
    }

    //execute this code when leaving the composable
    DisposableEffect(viewModel) {
        onDispose {
            viewModel.updateSwitchState()
        }
    }
}