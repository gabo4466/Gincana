package com.gincana.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.gincana.common.composables.BottomNav
import com.gincana.common.composables.Title
import com.gincana.ui.theme.GincanaTheme

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


    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxSize()) {


    }
}

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