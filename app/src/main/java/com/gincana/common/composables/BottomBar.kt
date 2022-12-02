package com.gincana.common.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.gincana.navigation.AppScreens


/*
@Composable
fun BottomBarWithFabDem() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNav(navController)
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        floatingActionButton = {
            FloatingActionButton(
                shape = CircleShape,
                onClick = {
                },
                contentColor = Color.White
            ) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "Add icon")
            }
        }
    ) {
        
    }
}

*/


@Composable
fun BottomNav(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination
    val items = listOf(
        AppScreens.HomeScreen,
        AppScreens.AccountSettingsScreen


    )
    BottomAppBar(cutoutShape = CircleShape) {
        Row() {
            items.forEachIndexed { index, it ->
                //if (index != 2) {
                    // Main item
                    BottomNavigationItem(
                        icon = {
                            it.icon?.let {
                                Icon(
                                    imageVector = it,
                                    contentDescription = "",
                                   // modifier = Modifier.size(35.dp),
                                    tint = Color.White

                                )
                            }
                        },
                        label = {
                            "Hola"
                        },
                        selected = currentRoute?.hierarchy?.any { it.route == it.route } == true,
                       // selectedContentColor = Color(R.color.purple_700),
                        unselectedContentColor = Color.White.copy(alpha = 0.4f),
                        onClick = {navController.navigate(it.route)}
                    )
                //} else {
                    // placeholder for center fab
                   /* BottomNavigationItem(
                        icon = {},
                        label = { },
                        selected = false,
                        onClick = { },
                        enabled = false
                    )*/
                //}
            }
        }

    }
}