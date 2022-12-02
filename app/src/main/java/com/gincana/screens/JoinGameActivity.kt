package com.gincana.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.*

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.gincana.ButtonAccces
import com.gincana.common.composables.BottomNav
import com.gincana.common.composables.TextInputIcon
import com.gincana.common.composables.Title
import com.gincana.ui.theme.GincanaTheme


@Composable
fun JoinGameScreen(navController: NavController) {

    Scaffold(topBar = { Title(title ="Unirse a una partida" , navController = navController)}, bottomBar = {
        BottomNav(navController = navController) },
        modifier = Modifier.fillMaxSize()
    ) {
        JoinGameBody(navController)

    }
}

@Composable
fun JoinGameBody(navControler: NavController){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        var gameCode by remember { mutableStateOf("") }

        TextInputIcon(gameCode, {gameCode = it}, "Código de partida", imageVector = Icons.Default.Info)

        Spacer(modifier = Modifier.size(20.dp))

        ButtonAccces("Unirse") { navControler.navigate("") }
    }
}

@Composable
fun ButtonAccces(text:String, onClick: ()->Unit) {

    Button(
        onClick = onClick, modifier = Modifier.width(350.dp)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.button
        )
    }
}

@Preview(showBackground = true)
@Composable
fun JoinGamePreview() {
    GincanaTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            val navController = rememberNavController()
            JoinGameScreen(navController)
        }
    }
}