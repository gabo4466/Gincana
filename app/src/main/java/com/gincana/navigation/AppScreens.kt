package com.gincana.navigation

sealed class AppScreens(val route: String){
    object FirstScreen: AppScreens("home_screen")
    object AuthScreen: AppScreens("auth_screen")
}
