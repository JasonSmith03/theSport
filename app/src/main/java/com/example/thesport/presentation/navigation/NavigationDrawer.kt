package com.example.thesport.presentation.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.DrawerValue
import androidx.compose.material.Icon
import androidx.compose.material.ModalDrawer
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.thesport.domain.model.MenuItem
import com.example.thesport.presentation.NavGraphs
import com.example.thesport.presentation.destinations.GamEventsDestination
import com.example.thesport.presentation.destinations.HomeScreenDestination
import com.example.thesport.presentation.destinations.SettingsPageDestination
import com.example.thesport.presentation.events.GamEvents
import com.example.thesport.presentation.home.AppBar
import com.example.thesport.presentation.home.HomeScreen
import com.example.thesport.presentation.home.HomeScreenViewModel
import com.example.thesport.presentation.home.SettingsPage
import com.example.thesport.presentation.settings.SettingsViewModel
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.manualcomposablecalls.composable
import com.ramcosta.composedestinations.navigation.navigate
import kotlinx.coroutines.launch


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
fun DrawerContents(homeScreenViewModel: HomeScreenViewModel, settingsViewModel: SettingsViewModel) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val navController = rememberNavController()
    val scope = rememberCoroutineScope()
    val menuItems = listOf(
        MenuItem(
            id = "Home",
            title = "Home",
            contentDescription = "Go to home screen",
            icon = Icons.Default.Home,
            destination = HomeScreenDestination
        ),
        MenuItem(
            id = "Settings",
            title = "Settings",
            contentDescription = "Go to settings screen",
            icon = Icons.Default.Settings,
            destination = SettingsPageDestination
        ),
    )

    ModalDrawer(
        drawerState = drawerState,
        gesturesEnabled = drawerState.isOpen,
        drawerContent = {
            DrawerHeader()
            DrawerBody(
                items = menuItems,
                onItemClick = {
                    navController.navigate(it.destination)
                    scope.launch {
                        drawerState.close()
                    }
                }
            )
        },
        content = {
            Scaffold(
                topBar = {
                    AppBar(
                        onNavigationIconClick = {
                            scope.launch {
                                drawerState.open()
                            }
                        }
                    )
                }
            ) {
                DestinationsNavHost(
                    modifier = Modifier.padding(it),
                    navGraph = NavGraphs.root,
                    navController = navController
                ) {
                    composable(HomeScreenDestination){
                        HomeScreen(homeScreenViewModel)
                    }
                    composable(SettingsPageDestination) {
                        SettingsPage(settingsViewModel)
                    }
                    composable(GamEventsDestination) {
                        GamEvents()
                    }
                }
            }
        }
    )
}