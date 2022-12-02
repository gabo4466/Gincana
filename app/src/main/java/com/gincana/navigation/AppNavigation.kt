package com.gincana.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.gincana.LoginScreen
import com.gincana.SignUpScreen
import com.gincana.screens.AuthScreen
import com.gincana.screens.HomeScreen
import com.gincana.screens.JoinGameScreen


@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController , startDestination = AppScreens.AuthScreen.route ){
        composable(route= AppScreens.AuthScreen.route){
            AuthScreen(navController)
        }
        composable(route= AppScreens.LoginScreen.route){
            LoginScreen(navController)
        }
        composable(route= AppScreens.SignUpScreen.route){
            SignUpScreen(navController)
        }
        composable(route= AppScreens.HomeScreen.route){
            HomeScreen(navController)
        }
        composable(route= AppScreens.JoinGameScreen.route){
            JoinGameScreen(navController)
        }
    }
}