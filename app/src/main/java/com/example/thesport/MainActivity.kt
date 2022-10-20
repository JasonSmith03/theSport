package com.example.thesport

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.thesport.ui.HomeScreen.GameCard
import com.example.thesport.ui.HomeScreen.HomeScreenViewModel
import com.example.thesport.ui.theme.TheSportTheme
import java.util.*

const val TAG = "MainActivity"
lateinit var viewModel: HomeScreenViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TheSportTheme() {
                Scaffold(
                ) { padding ->
                    HomeScreen(Modifier.padding(padding))
                }
            }
        }
    }
}


@Composable
fun BettingInfo(
    contentDescriptionTeam1: String,
    contentDescriptionTeam2: String,
    logoTeam1: Painter,
    logoTeam2: Painter,
    modifier: Modifier = Modifier) {

    Surface(
        modifier = modifier
            .width(400.dp)
            .height(100.dp),
 //       modifier = modifier,
        //shape = RoundedCornerShape(15.dp),
        shape = MaterialTheme.shapes.small
        //elevation = 5.dp
    ) {
        Column(modifier = Modifier
            .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceEvenly) {

            //Team 1
            Row(modifier = modifier
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly) {

                //team image
                Image(painter = logoTeam1, contentDescription = contentDescriptionTeam1, contentScale = ContentScale.Crop, modifier = modifier
                    .width(30.dp)
                    .height(30.dp))

                //team name
                Text(text = "Toronto Maple Leafs", fontSize = 14.sp, fontFamily = FontFamily.Default)

                //team score
                Text(text = "3", modifier = modifier
                    .width(30.dp)
                    .height(30.dp))

                //team spread
                Text(text = "+1.5", textAlign = TextAlign.Center, modifier = modifier
                    .width(40.dp)
                    .height(30.dp)
                    .background(Color.LightGray))

                //team money
                Text(text = "+108", textAlign = TextAlign.Center, modifier = modifier
                    .width(40.dp)
                    .height(30.dp)
                    .background(Color.LightGray))

                //team total
                Text(text = "0.7", textAlign = TextAlign.Center, modifier = modifier
                    .width(40.dp)
                    .height(30.dp)
                    .background(Color.LightGray))
            }
            //Team 2
            Row(modifier = modifier
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly) {

                //team image
                Image(painter = logoTeam2, contentDescription = contentDescriptionTeam2, contentScale = ContentScale.Crop, modifier = modifier
                    .width(30.dp)
                    .height(30.dp))

                //team name
                Text(text = "Colorado Avalanche", fontSize = 14.sp, fontFamily = FontFamily.Default)

                //team score
                Text(text = "3", modifier = modifier
                    .width(30.dp)
                    .height(30.dp))

                //team spread
                Text(text = "-1.5", textAlign = TextAlign.Center, modifier = modifier
                    .width(40.dp)
                    .height(30.dp)
                    .background(Color.LightGray))

                //team money
                Text(text = "-126", textAlign = TextAlign.Center, modifier = modifier
                    .width(40.dp)
                    .height(30.dp)
                    .background(Color.LightGray))

                //team total
                Text(text = "0.7", textAlign = TextAlign.Center, modifier = modifier
                    .width(40.dp)
                    .height(30.dp)
                    .background(Color.LightGray))
            }
        }
    }
}


@Composable
fun AlignTodaysGames(
    contentDescriptionTeam1: String,
    contentDescriptionTeam2: String,
    logoTeam1: Painter,
    logoTeam2: Painter,
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        //TODO pass a list and send each team instance to create a card
        items(4) {
            GameCard(contentDescriptionTeam1, contentDescriptionTeam2, logoTeam1, logoTeam2)
        }
    }
}

@Composable
fun AlignBettingInfo(
    contentDescriptionTeam1: String,
    contentDescriptionTeam2: String,
    logoTeam1: Painter,
    logoTeam2: Painter,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        //TODO pass a list and send each team instance to create a card
        items(6) {
            BettingInfo(contentDescriptionTeam1, contentDescriptionTeam2, logoTeam1, logoTeam2)
        }
    }
    Spacer(modifier = modifier
        .height(20.dp))
}

//Home section - Slot APIs
@Composable
fun HomeSection( // might be considered as "too refactored"
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier) {
        Text(
            text = stringResource(title).uppercase(Locale.getDefault()),
            style = MaterialTheme.typography.body1,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 8.dp)
                .padding(horizontal = 16.dp)
        )
        content()
    }
}

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
        HomeSection(title = R.string.today_games) {
            AlignTodaysGames(descriptionTeam1, descriptionTeam2, team1Logo, team2Logo)
        }
        HomeSection(title = R.string.betting_info) {
            AlignBettingInfo(descriptionTeam1, descriptionTeam2, team1Logo, team2Logo)
        }
        Spacer(Modifier.height(16.dp))
    }
}

@Preview (showBackground = true)
@Composable
fun TodaysGamesPreview(){
    TheSportTheme() {
        val team1Logo = painterResource(id = R.drawable.leafs)
        val team2Logo = painterResource(id = R.drawable.avs)
        val descriptionTeam1 = "Toronto Maple Leafs"
        val descriptionTeam2 = "Colorado Avalanche"
        GameCard(descriptionTeam1, descriptionTeam2, team1Logo , team2Logo)
    }
}

@Preview (showBackground = true)
@Composable
fun BettingInfoPreview(){
    TheSportTheme{
        val team1Logo = painterResource(id = R.drawable.leafs)
        val team2Logo = painterResource(id = R.drawable.avs)
        val descriptionTeam1 = "Toronto Maple Leafs"
        val descriptionTeam2 = "Colorado Avalanche"
        BettingInfo(descriptionTeam1, descriptionTeam2, team1Logo, team2Logo)
    }
}

@Preview (showBackground = true)
@Composable
fun AlignTodaysGamesPreview(){
    TheSportTheme{
        val team1Logo = painterResource(id = R.drawable.leafs)
        val team2Logo = painterResource(id = R.drawable.avs)
        val descriptionTeam1 = "Toronto Maple Leafs"
        val descriptionTeam2 = "Colorado Avalanche"
        AlignTodaysGames(descriptionTeam1, descriptionTeam2, team1Logo, team2Logo)
    }
}

@Preview (showBackground = true)
@Composable
fun AlignBettingInfoPreview(){
    TheSportTheme{
        val team1Logo = painterResource(id = R.drawable.leafs)
        val team2Logo = painterResource(id = R.drawable.avs)
        val descriptionTeam1 = "Toronto Maple Leafs"
        val descriptionTeam2 = "Colorado Avalanche"
        AlignBettingInfo(descriptionTeam1, descriptionTeam2, team1Logo, team2Logo)
    }
}
