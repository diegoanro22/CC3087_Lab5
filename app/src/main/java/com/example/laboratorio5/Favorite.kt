package com.example.laboratorio5

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Favorite(navController: NavHostController) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        App(modifier = Modifier.padding(innerPadding), navController = navController)
    }
}

@Composable
fun App(modifier: Modifier, navController: NavController) {
    val concerts = createConcerts()
    ConcertsList(concerts = concerts, modifier = modifier, navController = navController)
}

@Composable
fun ConcertsList(concerts: List<Concerts>, modifier: Modifier, navController: NavController) {
    Column(modifier = modifier.fillMaxSize()) {
        // Sección "Your Favorites"
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = "Your Favorites",
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(12.dp),
            )
            HorizontalDivider(thickness = 2.dp, color = MaterialTheme.colorScheme.onSurfaceVariant)

            LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                items(concerts.filter { it.favorite }) { concert ->
                    ConcertCard(concert = concert, navController = navController)
                }
            }
        }

        // Espacio entre secciones
        Spacer(modifier = Modifier.height(32.dp))

        // Sección "All Concerts"
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = "All Concerts",
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(12.dp),
            )
            HorizontalDivider(thickness = 2.dp, color = MaterialTheme.colorScheme.onSurfaceVariant)

            LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                items(concerts) { concert ->
                    ConcertCard(concert = concert, navController = navController)
                }
            }
        }
    }
}




@Composable
fun ConcertCard(concert: Concerts, navController: NavController) {
    val imageResId = imageMap[concert.image]
    Card(
        modifier = Modifier.padding(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)
            .clickable {
                navController.navigate("${Screens.Details.screens}/${concert.id}")
            }) {
            imageResId?.let { painterResource(id = it) }?.let {
                Image(
                    painter = it,
                    contentDescription = concert.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = concert.name, fontWeight = FontWeight.Bold)
            Text(text = concert.date)
            Text(text = concert.location)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = concert.description)
        }
    }
}


