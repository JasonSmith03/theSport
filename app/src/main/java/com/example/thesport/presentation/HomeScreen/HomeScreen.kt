package com.example.thesport.presentation.HomeScreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import java.util.*
import com.example.thesport.R

const val TAG = "HomeScreen"
lateinit var viewModel: HomeScreenViewModel

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    viewModel = viewModel<HomeScreenViewModel>()

    val team1Logo = painterResource(id = R.drawable.leafs)
    val team2Logo = painterResource(id = R.drawable.avs)
    val descriptionTeam1 = "Toronto Maple Leafs"
    val descriptionTeam2 = "Colorado Avalanche"

    Column(modifier) {
        Button(onClick = {
//            viewModel.testApiCall()
            viewModel.apiStatus()
        }) {
            Text(text = "Make API Call")
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
            modifier = modifier
        ) {
            //TODO pass a list and send each team instance to create a card
            items(4) {
                GameCard(descriptionTeam1, descriptionTeam2, team1Logo, team2Logo)
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
            modifier = modifier
        ) {
            //TODO pass a list and send each team instance to create a card
            items(6) {
                BettingInfoCard(descriptionTeam1, descriptionTeam2, team1Logo, team2Logo)
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}