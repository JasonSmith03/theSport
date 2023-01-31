package com.example.thesport.presentation.home

import android.service.autofill.FieldClassification.Match
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.thesport.R
import com.example.thesport.domain.model.Matchup

@Composable
fun BettingInfoCard(
    matchup: Matchup,
    oddsList: MutableList<String>,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .width(400.dp)
            .height(100.dp),
        //       modifier = modifier,
        //shape = RoundedCornerShape(15.dp),
        shape = MaterialTheme.shapes.small
        //elevation = 5.dp
    ) {
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = modifier
            .fillMaxSize()
        ){
            Column(modifier = Modifier
                .width(250.dp)
                .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceEvenly) {

                //Team 1
                Row(modifier = modifier
                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween) {

                    //team image
                    AsyncImage(
                        model = matchup.homeLogo,
                        contentDescription = matchup.homeName,
                        modifier = modifier
                            .size(40.dp)
                            .clip(CircleShape)
                    )
//                    Image(painter = logoTeam1, contentDescription = contentDescriptionTeam1, contentScale = ContentScale.Crop, modifier = modifier
//                        .width(30.dp)
//                        .height(30.dp))

                    //team name
                    Text(text = matchup.homeName, fontSize = 14.sp, fontFamily = FontFamily.Default)

                    //team score
                    Text(text = matchup.homeScore)

                }
                //Team 2
                Row(modifier = modifier
                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween) {

                    //team image
                    AsyncImage(
                        model = matchup.awayLogo,
                        contentDescription = matchup.awayName,
                        modifier = modifier
                            .size(40.dp)
                            .clip(CircleShape)
                    )
//                    Image(painter = logoTeam2, contentDescription = contentDescriptionTeam2, contentScale = ContentScale.Crop, modifier = modifier
//                        .width(30.dp)
//                        .height(30.dp))

                    //team name
                    Text(text = matchup.awayName, fontSize = 14.sp, fontFamily = FontFamily.Default)

                    //team score
                    Text(text = matchup.awayScore)
                }
            }
            Column(modifier = modifier
                .width(100.dp)
                .fillMaxHeight(),
                verticalArrangement = Arrangement.Center) {
                Row(modifier = modifier
                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly) {
                    Text("Home")
                    Text("Away")
                }
                Row(modifier = modifier
                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly) {
                    Text(text = oddsList[0])
                    Text(text = oddsList[1])
                }
            }
        }

    }
}