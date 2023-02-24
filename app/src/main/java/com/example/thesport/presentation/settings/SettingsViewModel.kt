package com.example.thesport.presentation.settings

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val prefs: SharedPreferences
): ViewModel(){

    private val _switchState = MutableStateFlow(prefs.getBoolean(SWITCH_STATE, false))
    val switchState: StateFlow<Boolean> = _switchState

    private val originalSwitchState = _switchState.value

    fun setSwitchState(newState: Boolean) {
        _switchState.value = newState
    }

    // only save in prefs when the user leaves the settings page
    // saves us from writing to shared prefs if the user decides to play with switch
    fun updateSwitchState() {
        if(switchState.value != originalSwitchState) {
            prefs.edit().putBoolean(SWITCH_STATE, switchState.value).apply()
            Log.v(TAG, "Odds switch state has been updated to: ${switchState.value} in prefs")
        }
    }

    companion object {
        const val TAG = "settings view model"
        const val SWITCH_STATE = "switch_state_key"
    }

}