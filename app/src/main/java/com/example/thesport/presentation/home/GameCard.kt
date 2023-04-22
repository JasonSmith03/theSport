package com.example.thesport.presentation.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.thesport.domain.model.Matchup

@Composable
fun GameCard(
    matchup: Matchup,
    modifier: Modifier = Modifier,
    showGameEvents: () -> Unit
){

    Card(
        modifier = modifier
            .width(250.dp)
            .height(100.dp)
            .clickable { showGameEvents() },
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp,
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