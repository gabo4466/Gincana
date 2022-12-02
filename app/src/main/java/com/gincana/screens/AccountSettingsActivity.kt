package com.gincana.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.gincana.R
import com.gincana.common.composables.Avatar
import com.gincana.common.composables.BottomNav
import com.gincana.common.composables.Title
import com.gincana.ui.theme.GincanaTheme
import com.gincana.ui.theme.Shapes

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AccountSettingsScreen(navController: NavController){
    GincanaTheme() {
        Scaffold(
            topBar = { Title(title ="Ajustes de cuenta", navController =navController)},
            bottomBar = { BottomNav(
                navController =navController)},
            modifier = Modifier.fillMaxSize()
        ){

            SettingsBody(navController)
        }
    }

}

@Composable
fun SettingsBody(navController: NavController) {


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
    ) {

        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .border(BorderStroke(2.dp, MaterialTheme.colors.primary), RoundedCornerShape(5.dp))
                .fillMaxWidth()
                .padding(10.dp)

        ){
            Row (
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)



            ){
                Text(text = "Datos públicos",style = MaterialTheme.typography.h5)
            }
            Divider(color = MaterialTheme.colors.primary, thickness = 1.dp)
            Row (
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)

            ){
                Avatar(R.drawable.avatar_1, size = 100.dp)
            }
            Row (
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ){
                Button(onClick = { /*TODO*/
                }, modifier = Modifier.width(300.dp)
                ) {
                    Text(text = "Cambiar avatar", style = MaterialTheme.typography.button)
                }
            }
        }

        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .border(BorderStroke(2.dp, MaterialTheme.colors.primary), RoundedCornerShape(5.dp))
                .fillMaxWidth()
                .padding(10.dp)

        ){
            Row (
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)

            ){
                Text(text = "Email", style = MaterialTheme.typography.h5)
            }
        }


    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview(showBackground = true)
@Composable

fun AccountSettingsPreview() {
    GincanaTheme {
        val navController = rememberNavController()
        Scaffold(
            topBar = { Title(title ="Ajustes de cuenta", navController =navController)},
            bottomBar = { BottomNav(
                navController =navController)},
            modifier = Modifier.fillMaxSize()
        ){

            SettingsBody(navController)
        }
    }
}