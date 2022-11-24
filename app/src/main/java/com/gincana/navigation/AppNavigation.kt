package com.gincana.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gincana.AuthScreen
import com.gincana.screens.FirstScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController , startDestination = AppScreens.FirstScreen.route){
        composable(route= AppScreens.FirstScreen.route){
            FirstScreen(navController)
        }
        composable(route= AppScreens.AuthScreen.route){
            AuthScreen(navController)
        }
    }
}