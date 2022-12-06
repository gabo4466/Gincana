package com.gincana.screens

import android.annotation.SuppressLint
import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.gincana.common.composables.Title
import com.gincana.ui.theme.GincanaTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun WaitingForGameScreen(navController: NavController) {

    Scaffold(
        topBar = { Title(title = "Esperando...", navController = navController, false) },

        modifier = Modifier.fillMaxSize()

    ) {
        WaitingForGameBody()
    }
}

@Composable
fun WaitingForGameBody(){
    val rotation = remember { Animatable(0f) }
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize()) {
        Roulette()//TODO: HACER QUE SEA MOVIMIENTO INFINITO

    }



}

@Preview(showBackground = true)
@Composable
fun WaitingForGamePreview() {
    GincanaTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            val navController = rememberNavController()
            WaitingForGameScreen(navController = navController)
        }
    }
}