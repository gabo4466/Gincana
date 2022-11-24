package com.gincana.navigation

sealed class AppScreens(val route: String){
    object FirstScreen: AppScreens("auth_screen")
    object AuthScreen: AppScreens("login_screen")
}
