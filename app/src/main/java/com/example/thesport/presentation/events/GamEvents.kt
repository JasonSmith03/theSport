package com.example.thesport.presentation.events

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thesport.R
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun GamEvents() {
    Column {
        Text(
            text = "Game Summary",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            textAlign = TextAlign.Center,
            textDecoration = TextDecoration.Underline
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

@Preview
@Composable
fun GamEventsPreview() {
    GamEvents()
}