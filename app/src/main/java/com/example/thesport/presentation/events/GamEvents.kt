package com.example.thesport.presentation.events

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.thesport.R
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun GamEvents() {
    val screenHeight = LocalConfiguration.current.screenHeightDp

    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height((screenHeight * 0.25f).dp)
                .background(Color.Black.copy(alpha = 0.7f))
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 8.dp),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            items(3) {
                EventField(
                    title = "Period #",
                    painter = painterResource(id = R.drawable.avs),
                    content = "Player Name\n(Player Name, Player Name)"
                )
            }
            item {
                EventField(
                    title = "Penalties",
                    painter = painterResource(id = R.drawable.avs),
                    content = "Player Name\n(Hooking: 15:02)"
                )
            }
        }
    }
}

@Composable
fun EventField (title: String, painter: Painter, content: String) {
    Column(
        modifier = Modifier
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = title,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.padding(vertical = 16.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            Arrangement.SpaceAround
        ) {
            Image(
                painter = painter,
                contentDescription = "avs",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth(7/10f),
                text = content
            )
        }
    }
}

//
////@Destination
//@Composable
//fun GameEventsScreen(
////    matchup: Matchup,
//    modifier: Modifier = Modifier
//) {
//    val imagePainter: Painter = painterResource(id = R.drawable.avs)
//    Column(modifier = Modifier
//        .fillMaxSize(),
//        verticalArrangement = Arrangement.SpaceEvenly
//    ) {
//        Text(text = "1st Period", fontWeight = FontWeight.Bold)
//        Column(modifier = Modifier
//            .fillMaxWidth(),
//            verticalArrangement = Arrangement.SpaceEvenly
//        ) {
//            Row(modifier = Modifier
//                .fillMaxWidth(),
//                horizontalArrangement = Arrangement.SpaceEvenly
//            ){
//                Image(
//                    painter = imagePainter,
//                    contentDescription = "avs",
//                    contentScale = ContentScale.Crop,
//                    modifier = modifier
//                        .size(40.dp)
//                        .clip(CircleShape)
//                )
////                AsyncImage(
////                    model = matchup.homeLogo,
////                    contentDescription = matchup.homeName,
////                    modifier = modifier
////                        .size(40.dp)
////                        .clip(CircleShape)
////                )
//                Column() {
//                    Text(text = "Player name")
//                    Text(text = "Player name , Player name")
//                }
//            }
//        }
//        Text(text = "2nd Period", fontWeight = FontWeight.Bold)
//        Column(modifier = Modifier
//            .fillMaxWidth(),
//            verticalArrangement = Arrangement.SpaceEvenly
//        ) {
//            Row(modifier = Modifier
//                .fillMaxWidth(),
//                horizontalArrangement = Arrangement.SpaceEvenly
//            ){
//                Image(
//                    painter = imagePainter,
//                    contentDescription = "avs",
//                    contentScale = ContentScale.Crop,
//                    modifier = modifier
//                        .size(40.dp)
//                        .clip(CircleShape)
//                )
////                AsyncImage(
////                     model = matchup.homeLogo,
////                    contentDescription = matchup.homeName,
////                    modifier = modifier
////                        .size(40.dp)
////                        .clip(CircleShape)
////                )
//                Column() {
//                    Text(text = "Player name")
//                    Text(text = "Player name , Player name")
//                }
//            }
//        }
//        Text(text = "3rd Period")
//        Column(modifier = Modifier
//            .fillMaxWidth(),
//            verticalArrangement = Arrangement.SpaceEvenly
//        ) {
//            Row(modifier = Modifier
//                .fillMaxWidth(),
//                horizontalArrangement = Arrangement.SpaceEvenly
//            ){
//                Image(
//                    painter = imagePainter,
//                    contentDescription = "avs",
//                    contentScale = ContentScale.Crop,
//                    modifier = modifier
//                        .size(40.dp)
//                        .clip(CircleShape)
//                )
////                AsyncImage(
////                    model = matchup.homeLogo,
////                    contentDescription = matchup.homeName,
////                    modifier = modifier
////                        .size(40.dp)
////                        .clip(CircleShape)
////                )
//                Column() {
//                    Text(text = "Player name")
//                    Text(text = "Player name , Player name")
//                }
//            }
//        }
//        Text(text = "Penalties")
//        Column(modifier = Modifier
//            .fillMaxWidth(),
//            verticalArrangement = Arrangement.SpaceEvenly
//        ) {
//            Row(modifier = Modifier
//                .fillMaxWidth(),
//                horizontalArrangement = Arrangement.SpaceEvenly
//            ){
//                Image(
//                    painter = imagePainter,
//                    contentDescription = "avs",
//                    contentScale = ContentScale.Crop,
//                    modifier = modifier
//                        .size(40.dp)
//                        .clip(CircleShape)
//                )
////                AsyncImage(
////                    model = matchup.homeLogo,
////                    contentDescription = matchup.homeName,
////                    modifier = modifier
////                        .size(40.dp)
////                        .clip(CircleShape))
//                Column() {
//                    Text(text = "Player name")
//                    Text(text = "Comment")
//                }
//            }
//        }
//    }
//}
//
//@Preview (showBackground = true)
//@Composable
//fun previewGameEvents() {
//        GameEventsScreen()
//}