package com.gincana.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.gincana.LoginScreen
import com.gincana.screens.AuthScreen


@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController , startDestination = AppScreens.FirstScreen.route){
        composable(route= AppScreens.FirstScreen.route){
            AuthScreen(navController)
        }
        composable(route= AppScreens.AuthScreen.route){
            LoginScreen(navController)
        }
    }
}