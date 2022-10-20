package com.example.thesport.ui.HomeScreen

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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GameCard(
    contentDescriptionTeam1: String,
    contentDescriptionTeam2: String,
    logoTeam1: Painter,
    logoTeam2: Painter,
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
                Image(painter = logoTeam1, contentDescription = contentDescriptionTeam1, contentScale = ContentScale.FillBounds,modifier = modifier
                    .size(40.dp)
                    .clip(CircleShape))

                //team name
                Text(text = "Toronto Maple Leafs", fontSize = 14.sp, fontFamily = FontFamily.Default)

                //team score
                Text(text = "3")
            }

            //Team 2
            Row(modifier = modifier
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly) {

                //team image
                Image(painter = logoTeam2, contentDescription = contentDescriptionTeam2, contentScale = ContentScale.FillBounds, modifier = modifier
                    .size(40.dp)
                    .clip(CircleShape))

                //team name
                Text(text = "Colorado Avalanche", fontSize = 14.sp, fontFamily = FontFamily.Default)

                //team score
                Text(text = "3")
            }
        }
    }
}