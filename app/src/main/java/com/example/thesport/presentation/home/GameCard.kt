package com.example.thesport.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.thesport.domain.model.Matchup
import com.example.thesport.presentation.destinations.*
import com.ramcosta.composedestinations.navigation.navigate

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun GameCard(
    matchup: Matchup,
    navController: NavController,
    modifier: Modifier = Modifier
){

    Card(
        modifier = modifier
            .width(250.dp)
            .height(100.dp)
            .clickable {  },
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp,
        onClick = {
            navController.navigate(GamEventsDestination)
        }
    ) {
        
        Column(modifier = Modifier
            .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceEvenly) {

            //Team 1
            Row(modifier = modifier
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly) {

                //team image
                AsyncImage(
                    model = matchup.homeLogo,
                    contentDescription = matchup.homeName,
                    modifier = modifier.size(40.dp).clip(CircleShape)
                )

                //team name
                Text(text = matchup.homeName, fontSize = 14.sp, fontFamily = FontFamily.Default)

                //team score
                Text(text = matchup.homeScore)
            }

            //Team 2
            Row(modifier = modifier
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly) {
                //team image
                AsyncImage(
                    model = matchup.awayLogo,
                    contentDescription = matchup.awayName,
                    modifier = modifier.size(40.dp).clip(CircleShape)
                )

                //team name
                Text(text = matchup.awayName, fontSize = 14.sp, fontFamily = FontFamily.Default)

                //team score
                Text(text = matchup.awayScore)
            }
        }
    }
}

@Composable
fun ScreenTwo() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = (0.25f * LocalContext.current.resources.displayMetrics.heightPixels).dp),
            color = Color.White
        ) {
            // Content of screen two
        }

        // Background with opacity
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height((0.25f * LocalContext.current.resources.displayMetrics.heightPixels).dp)
                .background(Color.Black.copy(alpha = 0.7f))
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun TodaysGamesPreview(){
//    TheSportTheme() {
//        GameCard(matchup., descriptionTeam2, team1Logo , team2Logo, homeName, awayName, homeScore, awayScore)
//    }
//}