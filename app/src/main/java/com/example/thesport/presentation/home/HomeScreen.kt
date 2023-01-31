package com.example.thesport.presentation.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.thesport.R
import com.example.thesport.presentation.home.destinations.HomeScreenDestination
import com.example.thesport.presentation.home.destinations.ProfileDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.launch
import java.util.*

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Destination
@RootNavGraph(start = true)
@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = hiltViewModel(),
    navigator: DestinationsNavigator
) {
    //observer of stateFlow
    val matchupList = viewModel.listOfMatchups.collectAsState()
    val oddsMatchupMap = viewModel.mapOfMachupOdds.collectAsState()
    //val testingVal = viewModel.listOfGames.observe() FOR LIVE DATA


    Column() {
        Button(onClick = {
            viewModel.apiStatus()
        }) {
            Text(text = "Check Api Status")
        }
        Button(onClick = {
            viewModel.getListOfTodayGames()
            //viewModel.testApiCall()
        }) {
            Text(text = "Make API Call")
        }
        Button(onClick = {
            navigator.navigate(ProfileDestination)
        }) {
            Text(text = "Go to profile")
        }
        Spacer(Modifier.height(16.dp))
        Text(
            text = stringResource(R.string.today_games).uppercase(Locale.getDefault()),
            style = MaterialTheme.typography.body1,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 8.dp)
                .padding(horizontal = 16.dp)
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
        ) {

            Log.d("HOME SCREEN TAG", "matchupList: $matchupList")
            items(matchupList.value.size) {
                GameCard(matchupList.value[it])
            }
        }
        Spacer(Modifier.height(16.dp))
        Text(
            text = stringResource(R.string.betting_info).uppercase(Locale.getDefault()),
            style = MaterialTheme.typography.body1,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 8.dp)
                .padding(horizontal = 16.dp)
        )
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
        ) {
            items(oddsMatchupMap.value.size) {
                oddsMatchupMap.value[matchupList.value[it].matchupId]
                    ?.let { it1 -> BettingInfoCard(matchupList.value[it], it1) }
            }
        }
    }
}

@Destination
@Composable
fun Profile(navigator: DestinationsNavigator) {
   Button(onClick = { navigator.navigate(HomeScreenDestination) }) {
       Text(text = "Go home")
   }
}


@Preview
@Composable
fun HomeScreenPreview() {
    //HomeScreen(navigator = destinationsNavigator)
}