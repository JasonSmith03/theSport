package com.example.thesport

import android.icu.text.CaseMap
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import com.example.thesport.data.remote.TheSportRetrofitInstance
import com.example.thesport.ui.theme.TheSportTheme
import kotlinx.coroutines.launch
import okhttp3.Headers
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.HttpException
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TheSportTheme{
                val team1Logo = painterResource(id = R.drawable.leafs)
                val team2Logo = painterResource(id = R.drawable.avs)
                val descriptionTeam1 = "Toronto Maple Leafs"
                val descriptionTeam2 = "Colorado Avalanche"

                val TAG = "MainActivity"

                Column(modifier = Modifier.fillMaxSize()) {

                        Button(onClick = {

                            lifecycleScope.launch(){
                                val response = try{
                                    TheSportRetrofitInstance.api.getLeagues()
                                }catch (e: IOException){
                                    Log.e(TAG, "Might not have internet")
                                    return@launch
                                }catch (e: HttpException){
                                    Log.e(TAG, "Unexpected response")
                                    return@launch
                                }
                                if(response.isSuccessful && response.body() != null){
                                    println(response)
                                }else {
                                    Log.e(TAG, "response not successful")
                                }
                            }

                        }) {
                            Text(text = "Make API Call")

                        }




                    Spacer(modifier = Modifier.height(150.dp))
                    LazyRow(modifier = Modifier
                        .fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                        items (4){
                            LiveMatchCard(descriptionTeam1, descriptionTeam2, team1Logo, team2Logo)
                        }
                    }
                    Spacer(modifier = Modifier.height(50.dp))
                    LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp)){
                        items(4){
                            MoneyLine(
                                contentDescriptionTeam1 = descriptionTeam1,
                                contentDescriptionTeam2 = descriptionTeam2,
                                logoTeam1 = team1Logo,
                                logoTeam2 = team2Logo)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun LiveMatchCard(
    contentDescriptionTeam1: String,
    contentDescriptionTeam2: String,
    logoTeam1: Painter,
    logoTeam2: Painter,
    modifier: Modifier = Modifier){

    Card(
        modifier = modifier
            .width(250.dp)
            .height(150.dp),
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
                Image(painter = logoTeam1, contentDescription = contentDescriptionTeam1, modifier = modifier
                    .width(30.dp)
                    .height(30.dp))

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
                Image(painter = logoTeam2, contentDescription = contentDescriptionTeam2, modifier = modifier
                    .width(30.dp)
                    .height(30.dp))

                //team name
                Text(text = "Colorado Avalanche", fontSize = 14.sp, fontFamily = FontFamily.Default)

                //team score
                Text(text = "1")
            }
        }
    }
}


@Composable
fun MoneyLine(
    contentDescriptionTeam1: String,
    contentDescriptionTeam2: String,
    logoTeam1: Painter,
    logoTeam2: Painter,
    modifier: Modifier = Modifier) {

    Card(
        modifier = modifier
            .width(400.dp)
            .height(150.dp),
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
                Image(painter = logoTeam1, contentDescription = contentDescriptionTeam1, modifier = modifier
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
                Image(painter = logoTeam2, contentDescription = contentDescriptionTeam2, modifier = modifier
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


@Preview (showBackground = true)
@Composable
fun prevImageCard(){
    TheSportTheme{
        val team1Logo = painterResource(id = R.drawable.leafs)
        val team2Logo = painterResource(id = R.drawable.avs)
        val descriptionTeam1 = "Toronto Maple Leafs"
        val descriptionTeam2 = "Colorado Avalanche"
        LazyColumn(modifier = Modifier
            .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            item (4){
                MoneyLine(descriptionTeam1, descriptionTeam2, team1Logo, team2Logo)
            }
        }
    }
}
