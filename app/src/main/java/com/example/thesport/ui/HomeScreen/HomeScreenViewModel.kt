package com.example.thesport.ui.HomeScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thesport.data.remote.TheSportRetrofitInstance
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException


class HomeScreenViewModel: ViewModel() {

    fun apiStatus() {
        viewModelScope.launch {
            val status = try {
                TheSportRetrofitInstance.api.getStatus()
            } catch (e: Exception) {
                Log.e(TAG, "exception while getting api status:")
                e // status = e
            }
            Log.d(TAG, "Status: $status")
            print("Status: $status")
        }
    }

    fun testApiCall() {
        viewModelScope.launch() {
            val response = try { //working api call for status
                TheSportRetrofitInstance.api.getLeagues(NHL)
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
            Log.d(TAG, "response: $response \n")
            Log.d(TAG, response.toString())
            print("response: $response")
        }
    }


    companion object {
        const val TAG = "HomeScreenViewModel"
        const val NHL = 57
    }
}