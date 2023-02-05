package com.example.thesport.presentation.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thesport.domain.model.MenuItem
import com.example.thesport.presentation.home.destinations.HomeScreenDestination
import com.example.thesport.presentation.home.destinations.SettingsPageDestination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


@Composable
fun DrawerHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 64.dp),
        contentAlignment = Alignment.Center
    ){
        Text(text = "Menu", fontSize = 60.sp)
    }
}

@Composable
fun DrawerBody(
    items: List<MenuItem>,
    modifier: Modifier = Modifier,
    itemTextStyle: TextStyle = TextStyle(fontSize = 18.sp),
    onItemClick: (MenuItem) -> Unit
) {
    LazyColumn(modifier){
        items(items){ item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onItemClick(item)
                    }
                    .padding(16.dp)
            ){
                Icon(imageVector = item.icon, contentDescription = item.contentDescription)
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = item.title,
                    style = itemTextStyle,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Composable
fun DrawerContents(navigator: DestinationsNavigator) {
    DrawerHeader()
    DrawerBody(
        items = listOf(
            MenuItem(
                id = "Home",
                title = "Home",
                contentDescription = "Go to home screen",
                icon = Icons.Default.Home
            ),
            MenuItem(
                id = "Settings",
                title = "Settings",
                contentDescription = "Go to settings screen",
                icon = Icons.Default.Settings
            ),
        ),
        onItemClick = {
            //TODO NAVIGATE
            when(it.id){
                "Home" -> navigator.navigate(HomeScreenDestination)
                "Settings" -> navigator.navigate(SettingsPageDestination)
            }
            println("clicked on ${it.title}")
        }
    )
}