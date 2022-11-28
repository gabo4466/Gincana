package com.gincana.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.rememberNavController
import com.gincana.ui.theme.GincanaTheme



@Composable
fun HomeScreen(navController: NavController){
    Scaffold(modifier = Modifier.fillMaxSize()) {
        MainTitle(title = "Home")
        
    }

}

@Composable
fun MainTitle(title: String){
    TopAppBar(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = title,
            style = MaterialTheme.typography.h6,
            color = MaterialTheme.colors.onPrimary,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(10.dp)
        )
    }
}


@Composable
fun HomeButtons(navController: NavController){
    Button(onClick = { /*navController.navigate()TODO */}) {
        Text(text = "Crear Partida" )
    }
}
@Preview(showBackground = true)
@Composable
fun HomePreview() {
    GincanaTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            val navController = rememberNavController()
            HomeScreen(navController)
        }
    }
}