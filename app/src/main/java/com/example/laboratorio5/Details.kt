package com.example.laboratorio5


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.laboratorio5.ui.theme.Laboratorio5Theme

class Details : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Laboratorio5Theme {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    topBar = {
                        CenterAlignedTopAppBar(
                            title = { Text("Todo Eventos") },
                            actions = {
                                Icon(
                                    imageVector = Icons.Default.MoreVert,
                                    contentDescription = null
                                )
                            }
                        )
                    }
                ) { innerPadding ->
                    App_Details(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}


@Composable
fun App_Details(modifier: Modifier){
    val concerts = createConcerts()
    DetailsList(concerts = concerts, modifier = modifier)
}

@Composable
fun DetailsList(concerts: List<Concerts>, modifier: Modifier) {
    LazyColumn( modifier = modifier.fillMaxSize()) {
        items(concerts) { concert ->
            DetailsCard(concert = concert)
        }
    }

}

@Composable
fun DetailsCard(concert: Concerts) {
    val imageResId = imageMap[concert.image]
    Card(
        modifier = Modifier.padding(8.dp),
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
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
            Text(text = "Acerca de: \n" + concert.description)
            Row(modifier = Modifier.fillMaxWidth()) {
                Button(onClick = { /*TODO*/ },
                    modifier = Modifier.weight(1f).padding(end = 8.dp)) {
                    Text(text = "Favorite")
                }
                Button(onClick = { /*TODO*/ },
                    modifier = Modifier.weight(1f).padding(end = 8.dp)) {
                    Text(text = "Buy")
                }
            }

        }
    }
}
