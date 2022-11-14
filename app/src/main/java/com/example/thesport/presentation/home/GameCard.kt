package com.example.thesport.presentation.home

import android.widget.ImageView
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.thesport.presentation.ui.theme.TheSportTheme
import com.example.thesport.R
import com.example.thesport.domain.model.Matchup

@OptIn(ExperimentalCoilApi::class)
@Composable
fun GameCard(
    matchup: Matchup,
    modifier: Modifier = Modifier
){
    
    Card(
        modifier = modifier
            .width(250.dp)
            .height(100.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {
        
        Column(modifier = Modifier
            .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceEvenly) {

            //Team 1
            Row(modifier = modifier
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly) {

                //team image
                Image(painter = rememberImagePainter(matchup.homeLogo), contentDescription = matchup.homeName, modifier = modifier
                    .size(40.dp)
                    .clip(CircleShape))
//                Image(painter = , contentDescription = matchup.homeName, contentScale = ContentScale.FillBounds,modifier = modifier
//                    .size(40.dp)
//                    .clip(CircleShape))

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
                Image(painter = rememberImagePainter(matchup.awayLogo), contentDescription = matchup.awayName, modifier = modifier
                    .size(40.dp)
                    .clip(CircleShape))
//                Image(painter = matchup.awayLogo, contentDescription = matchup.awayName, contentScale = ContentScale.FillBounds, modifier = modifier
//                    .size(40.dp)
//                    .clip(CircleShape))

                //team name
                Text(text = matchup.awayName, fontSize = 14.sp, fontFamily = FontFamily.Default)

                //team score
                Text(text = matchup.awayScore)
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun TodaysGamesPreview(){
//    TheSportTheme() {
//        GameCard(matchup., descriptionTeam2, team1Logo , team2Logo, homeName, awayName, homeScore, awayScore)
//    }
//}