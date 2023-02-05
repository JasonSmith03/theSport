package com.example.thesport.presentation.home

import androidx.lifecycle.ViewModel
import com.example.thesport.domain.repository.SportRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class SettingScreenViewModel @Inject constructor(
    private val repository: SportRepository
): ViewModel(){

    private val _theme = MutableStateFlow(Boolean)
    val theme: MutableStateFlow<Boolean.Companion> = _theme

    fun checkThemeState(){

    }
}