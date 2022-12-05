package com.gincana.screens

import android.annotation.SuppressLint
import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.gincana.common.composables.BottomNav
import com.gincana.common.composables.Title
import com.gincana.ui.theme.GincanaTheme
import com.google.android.material.R

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LobbyScreen(navController: NavController) {

    Scaffold(
        topBar = { Title(title = "Esperando...", navController = navController, false) },

        modifier = Modifier.fillMaxSize()
    
    ) {
    LobbyBody(navController)
    }
}

@Composable
fun LobbyBody(navController: NavController){
    Column( horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
        Members()
        Spacer(modifier = Modifier.size(200.dp))
        ButtonLeave(text ="Abandonar" , icon = R.drawable.mtrl_ic_cancel ) {
            navController.navigate("home_screen")
        }
    }

}

@Composable
fun Members(){
    Column(horizontalAlignment = Alignment.CenterHorizontally,modifier = Modifier.padding(top=16.dp)) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier=Modifier
                .width(300.dp)
                .background(color = MaterialTheme.colors.primarySurface)) {
            Text(text = "Miembros", color = MaterialTheme.colors.onPrimary)
        }
        
        Column(modifier = Modifier
           ) {
            Spacer(modifier = Modifier.size(350.dp))
        }
    }
}
@Composable
fun ButtonLeave(text: String, icon: Int?, onClick: () -> Unit) {

    Button(
        onClick = onClick, modifier = Modifier.width(350.dp)
    ) {
        if (icon != null){
            Icon(painter =  painterResource(id = icon), contentDescription = "")
            Spacer(modifier = Modifier.size(10.dp))
        }

        Text(
            text = text,
            style = MaterialTheme.typography.button
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LonginPreview() {
    GincanaTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            val navController = rememberNavController()
            LobbyScreen(navController = navController)
        }
    }
}