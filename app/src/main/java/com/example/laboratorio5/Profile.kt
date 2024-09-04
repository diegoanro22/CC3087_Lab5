package com.example.laboratorio5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.laboratorio5.ui.theme.Laboratorio5Theme

class Profile : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Laboratorio5Theme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
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
                    App_Profile(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun App_Profile(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Imagen de fondo
        Box(modifier = Modifier, contentAlignment = Alignment.Center){
            Image(
                painter = painterResource(id = R.drawable.fondo),
                contentDescription = "Background Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp) // Ajusta la altura según sea necesario
                    .clip(RoundedCornerShape(8.dp)) // Bordes redondeados

            )
            Image(
                painter = painterResource(id = R.drawable.dog2),
                contentDescription = "Background Image",
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(60.dp))
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Contenido del perfil
        Column(modifier = Modifier.fillMaxSize()) {
            ProfileActionRow(
                icon = Icons.Default.Person,
                text = "Edit Profile"
            )
            ProfileActionRow(
                icon = Icons.Default.Lock,
                text = "Reset Password"
            )
            ProfileActionRow(
                icon = Icons.Default.Notifications,
                text = "Notifications",
                hasSwitch = true
            )
            ProfileActionRow(
                icon = Icons.Default.Star,
                text = "Favorites"
            )
        }
    }
}

@Composable
fun ProfileActionRow(
    icon: ImageVector,
    text: String,
    hasSwitch: Boolean = false,
    modifier: Modifier = Modifier
) {
    // State to manage the switch
    var switchState by remember { mutableStateOf(false) }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
//            .background(Color.White)
            .clip(RoundedCornerShape(8.dp)) // Bordes redondeados para cada fila
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .padding(
                    end = 8.dp
                )
        )
        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
        )
        Spacer(modifier = Modifier.weight(1f))
        if (hasSwitch) {
            Switch(
                checked = switchState,
                onCheckedChange = { isChecked ->
                    switchState = isChecked
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewProfile() {
    Laboratorio5Theme {
        App_Profile(modifier = Modifier)
    }
}
