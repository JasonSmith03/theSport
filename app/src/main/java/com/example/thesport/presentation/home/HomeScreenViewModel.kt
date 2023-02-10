package com.example.thesport.presentation.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thesport.domain.model.Matchup
import com.example.thesport.domain.repository.SportRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.Month
import java.util.*
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val repository: SportRepository
): ViewModel() {

//    private val _listOfMatchups =  MutableLiveData<MutableList<Matchup>>()
//    val listOfMatchups: LiveData<MutableList<Matchup>> = _listOfMatchups

    private val _listOfMatchups = MutableStateFlow(mutableListOf<Matchup>())
    val listOfMatchups: StateFlow<MutableList<Matchup>> = _listOfMatchups

    private val _mapOfMatchupOdds = MutableStateFlow(HashMap<Int, MutableList<String>>())
    val mapOfMachupOdds: StateFlow<HashMap<Int, MutableList<String>>> = _mapOfMatchupOdds

    @SuppressLint("SimpleDateFormat", "WeekBasedYear")
    fun getListOfTodayGames(){
        viewModelScope.launch {
            //working api call for status
             val apiResponse = try {
                 //DATE TIME FORMAT: YYYY-MM-DDThh:mm:ss.mss
                 // API NEEDS 2 DIGITS FOR THE DATE, ANYTHING < 10 NEEDS TO HAVE A 0 IN FRONT
                 val currentDate = LocalDateTime.now()
                 var currentSeason = currentDate.year

                 val UTCdate = getCurrentUTC()
                 Log.d(TAG, "show testigns ${UTCdate}")

                 //Handles year change for NHL season
                 if (currentDate.month < Month.JULY){
                     currentSeason = currentDate.year - 1
                 }

                 //call repository of the Domain layer which will get data from repository of the data layer (Business logic)
                 _listOfMatchups.value = repository.getListOfMatchups(NHL, currentSeason, UTCdate.toString().substring(0, 10))
                 Log.d(TAG, "GOT LIST OF GAMES JUST BEFORE CALLING FOR ODDS")
                 //, BOOKMAKER, BET
                 _mapOfMatchupOdds.value = repository.getOdds(NHL, currentSeason, BOOKMAKER, BET)


                 Log.d(TAG, _listOfMatchups.value.toString())
                 Log.d(TAG, _mapOfMatchupOdds.value.toString())
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

    fun getCurrentUTC(): String? {
        val time = Calendar.getInstance().time
        val outputFmt = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        outputFmt.timeZone = TimeZone.getTimeZone("UTC")
        return outputFmt.format(time)
    }


    companion object {
        const val TAG = "HomeScreenViewModel"
        const val NHL = 57
        const val BOOKMAKER = 3
        const val BET = 1
    }
}