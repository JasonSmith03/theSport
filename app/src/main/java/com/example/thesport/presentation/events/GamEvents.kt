package com.example.thesport.presentation.events

import android.graphics.drawable.Drawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.thesport.domain.model.Matchup
import com.example.thesport.presentation.ui.theme.TheSportTheme
import com.ramcosta.composedestinations.annotation.Destination
import com.example.thesport.R

//@Destination
@Composable
fun GameEventsScreen(
//    matchup: Matchup,
    modifier: Modifier = Modifier
) {
    val imagePainter: Painter = painterResource(id = R.drawable.avs)
    Column(modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(text = "1st Period", fontWeight = FontWeight.Bold)
        Column(modifier = Modifier
            .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Row(modifier = Modifier
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ){
                Image(
                    painter = imagePainter,
                    contentDescription = "avs",
                    contentScale = ContentScale.Crop,
                    modifier = modifier
                        .size(40.dp)
                        .clip(CircleShape)
                )
//                AsyncImage(
//                    model = matchup.homeLogo,
//                    contentDescription = matchup.homeName,
//                    modifier = modifier
//                        .size(40.dp)
//                        .clip(CircleShape)
//                )
                Column() {
                    Text(text = "Player name")
                    Text(text = "Player name , Player name")
                }
            }
        }
        Text(text = "2nd Period", fontWeight = FontWeight.Bold)
        Column(modifier = Modifier
            .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Row(modifier = Modifier
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ){
                Image(
                    painter = imagePainter,
                    contentDescription = "avs",
                    contentScale = ContentScale.Crop,
                    modifier = modifier
                        .size(40.dp)
                        .clip(CircleShape)
                )
//                AsyncImage(
//                     model = matchup.homeLogo,
//                    contentDescription = matchup.homeName,
//                    modifier = modifier
//                        .size(40.dp)
//                        .clip(CircleShape)
//                )
                Column() {
                    Text(text = "Player name")
                    Text(text = "Player name , Player name")
                }
            }
        }
        Text(text = "3rd Period")
        Column(modifier = Modifier
            .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Row(modifier = Modifier
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ){
                Image(
                    painter = imagePainter,
                    contentDescription = "avs",
                    contentScale = ContentScale.Crop,
                    modifier = modifier
                        .size(40.dp)
                        .clip(CircleShape)
                )
//                AsyncImage(
//                    model = matchup.homeLogo,
//                    contentDescription = matchup.homeName,
//                    modifier = modifier
//                        .size(40.dp)
//                        .clip(CircleShape)
//                )
                Column() {
                    Text(text = "Player name")
                    Text(text = "Player name , Player name")
                }
            }
        }
        Text(text = "Penalties")
        Column(modifier = Modifier
            .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Row(modifier = Modifier
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ){
                Image(
                    painter = imagePainter,
                    contentDescription = "avs",
                    contentScale = ContentScale.Crop,
                    modifier = modifier
                        .size(40.dp)
                        .clip(CircleShape)
                )
//                AsyncImage(
//                    model = matchup.homeLogo,
//                    contentDescription = matchup.homeName,
//                    modifier = modifier
//                        .size(40.dp)
//                        .clip(CircleShape))
                Column() {
                    Text(text = "Player name")
                    Text(text = "Comment")
                }
            }
        }
    }
}

@Preview (showBackground = true)
@Composable
fun previewGameEvents() {
        GameEventsScreen()
}