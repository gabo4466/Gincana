package com.gincana.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
    ) {

        Row (
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .border(BorderStroke(2.dp, MaterialTheme.colors.primary), RoundedCornerShape(5.dp))
                .fillMaxWidth()
                .padding(10.dp)

        ){
            Text(text = "Avatar", style = MaterialTheme.typography.h5)
        }
        Row (
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .border(BorderStroke(2.dp, MaterialTheme.colors.primary), RoundedCornerShape(5.dp))
                .fillMaxWidth()
                .padding(10.dp)

        ){
            Avatar()
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