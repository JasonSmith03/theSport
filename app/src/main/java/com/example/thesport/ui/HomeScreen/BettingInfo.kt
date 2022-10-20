package com.example.thesport.ui.HomeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thesport.ui.theme.TheSportTheme
import com.example.thesport.R

@Composable
fun BettingInfo(
    contentDescriptionTeam1: String,
    contentDescriptionTeam2: String,
    logoTeam1: Painter,
    logoTeam2: Painter,
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

@Preview(showBackground = true)
@Composable
fun BettingInfoPreview(){
    val team1Logo = painterResource(id = R.drawable.leafs)
    val team2Logo = painterResource(id = R.drawable.avs)
    val descriptionTeam1 = "Toronto Maple Leafs"
    val descriptionTeam2 = "Colorado Avalanche"
    BettingInfo(descriptionTeam1, descriptionTeam2, team1Logo, team2Logo)
}