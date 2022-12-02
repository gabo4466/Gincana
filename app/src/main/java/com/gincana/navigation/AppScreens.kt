package com.gincana.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class AppScreens(val route: String,val icon: ImageVector?){
    object FirstScreen: AppScreens("auth_screen", Icons.Default.AccountCircle)
    object AuthScreen: AppScreens("login_screen",null)
    object SignUpScreen: AppScreens("signup_screen",null)
    object HomeScreen: AppScreens("home_screen",Icons.Default.Home)
}
