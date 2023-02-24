package com.example.thesport.presentation.home

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.thesport.R
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import java.util.*

@Destination
@RootNavGraph(start = true)
@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel,
) {
    //observer of stateFlow
    val matchupList = viewModel.listOfMatchups.collectAsState()
    val oddsMatchupMap = viewModel.mapOfMachupOdds.collectAsState()
    //val testingVal = viewModel.listOfGames.observe() FOR LIVE DATA

    Column {
        Button(onClick = {
            viewModel.homeScreenInfoDisplay()
            //viewModel.testApiCall()
        }) {
            Text(text = "Make API Call")
        }
        //viewModel.getListOfTodayGames()
        Spacer(Modifier.height(16.dp))
        Text(
            text = stringResource(R.string.today_games).uppercase(Locale.getDefault()),
            style = MaterialTheme.typography.h6,
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
