package com.example.thesport.presentation.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thesport.domain.model.GameResponse
import com.example.thesport.domain.model.Games
import com.example.thesport.domain.model.Matchup
import com.example.thesport.domain.repository.SportRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import java.time.LocalDateTime
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val repository: SportRepository
): ViewModel() {

    private val _listOfMatchups =  MutableLiveData<MutableList<Matchup>>()
    val listOfMatchups: LiveData<MutableList<Matchup>> = _listOfMatchups

    private val _listOfGames =  MutableLiveData<Games>()
    val listOfGames: LiveData<Games> = _listOfGames

    fun getListOfTodayGames(){
        viewModelScope.launch {
            //working api call for status
             val apiResponse = try {
                //DATE TIME FORMAT: YYYY-MM-DDThh:mm:ss.mss
                val currentDate = LocalDateTime.now()
                _listOfMatchups.value = repository.getListOfMatchups(NHL, currentDate.year, currentDate.year.toString() + "-" + currentDate.monthValue.toString() + "-" + currentDate.dayOfMonth.toString())
                //_listOfGames.value = repository.getGame(NHL, currentDate.year, currentDate.year.toString() + "-" + currentDate.monthValue.toString() + "-" + currentDate.dayOfMonth.toString())

            } catch (e: IOException) {
                Log.e(TAG, "Might not have internet")
                return@launch
            } catch (e: HttpException) {
                Log.e(TAG, "Unexpected response")
                return@launch
            } catch (e: Exception) {
                Log.e(TAG, "exception while handling api request: $e")
                return@launch
            }
            // this response variable is of type Kotlin.Unit
            // unable to access data object params form here
            Log.d(TAG, "response: $apiResponse \n")
            Log.d(TAG, apiResponse.toString())
            print("response: $apiResponse")
        }
    }


    fun apiStatus() {
        viewModelScope.launch {
            val status = try {
                repository.getApiStatus()
            } catch (e: Exception) {
                Log.e(TAG, "exception while getting api status:")
                e // status = e
            }
            Log.d(TAG, "Status: $status")
            print("Status: $status")
        }
    }

//    fun testApiCall() {
//        viewModelScope.launch() {
//            val response = try { //working api call for status
//                repository.getLeague(NHL)
//                repository.getGame(NHL, 2022, "2022-11-11")
//            } catch (e: IOException) {
//                Log.e(TAG, "Might not have internet")
//                return@launch
//            } catch (e: HttpException) {
//                Log.e(TAG, "Unexpected response")
//                return@launch
//            } catch (e: Exception) {
//                Log.e(TAG, "exception while handling api request: $e")
//                return@launch
//            }
//
//            // this response variable is of type Kotlin.Unit
//            // unable to access data object params form here
//            Log.d(TAG, "response: $response \n")
//            Log.d(TAG, response.toString())
//            print("response: $response")
//        }
//    }


    companion object {
        const val TAG = "HomeScreenViewModel"
        const val NHL = 57
    }
}