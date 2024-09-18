package com.example.laboratorio5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.laboratorio5.ui.theme.Laboratorio5Theme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Laboratorio5Theme {
                MybottomAppBar()
            }
        }
    }
}


@Composable
fun MybottomAppBar(){
    val navigationController = rememberNavController()
    val context = LocalContext.current.applicationContext
    val selected = remember {
        mutableStateOf(Icons.Default.Home)
    }

    Scaffold (
        bottomBar = {
            BottomAppBar(
                containerColor = Color.Black
            ) {
                IconButton(onClick = {
                    selected.value = Icons.Default.Favorite
                    navigationController.navigate(Screens.Favorite.screens){
                        popUpTo(0)
                    }
                        }, modifier = Modifier.weight(1f)) {
                    Icon(Icons.Default.Favorite, contentDescription = null, modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.Favorite) Color.Blue else Color.Gray)

                }
                IconButton(onClick = {
                    selected.value = Icons.Default.Info
                    navigationController.navigate(Screens.Details.screens){
                        popUpTo(0)
                    }
                }, modifier = Modifier.weight(1f)) {
                    Icon(Icons.Default.Info, contentDescription = null, modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.Info) Color.Blue else Color.Gray)

                }
                IconButton(onClick = {
                    selected.value = Icons.Default.Place
                    navigationController.navigate(Screens.Places.screens){
                        popUpTo(0)
                    }
                }, modifier = Modifier.weight(1f)) {
                    Icon(Icons.Default.Place, contentDescription = null, modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.Place) Color.Blue else Color.Gray)

                }
                IconButton(onClick = {
                    selected.value = Icons.Default.Person
                    navigationController.navigate(Screens.Profile.screens){
                        popUpTo(0)
                    }
                }, modifier = Modifier.weight(1f)) {
                    Icon(Icons.Default.Person, contentDescription = null, modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.Person) Color.Blue else Color.Gray)

                }
            }
        }
    ){
        paddingValues ->
        NavHost(navController = navigationController,
            startDestination = Screens.Favorite.screens,
            modifier = Modifier.padding(paddingValues)){
            composable(Screens.Favorite.screens) { Favorite(navController = navigationController) }
            composable("${Screens.Details.screens}/{eventId}") { backStackEntry ->
                val eventId = backStackEntry.arguments?.getString("eventId")
                eventId?.let { Details(eventId = it.toInt()) }
            }
            composable(Screens.Places.screens){Places()}
            composable(Screens.Profile.screens){Profile()}
        }
    }

}



@Preview
@Composable
fun MyBootomBarPreview() {
    Laboratorio5Theme{
        MybottomAppBar()
    }

}