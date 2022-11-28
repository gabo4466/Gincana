package com.gincana.navigation

sealed class AppScreens(val route: String){
    object FirstScreen: AppScreens("auth_screen")
    object AuthScreen: AppScreens("login_screen")
    object SignUpScreen: AppScreens("signup_screen")
    object HomeScreen: AppScreens("home_screen")
}
