package com.gincana.common.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.gincana.navigation.AppScreens

@Composable
fun BottomNav(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination
    val items = listOf(
        AppScreens.HomeScreen,
        AppScreens.AccountSettingsScreen


    )
    BottomAppBar(cutoutShape = CircleShape) {
        Row(
            modifier = Modifier.padding(10.dp)
        ) {
            items.forEachIndexed { index, it ->
                //if (index != 2) {
                // Main item
                BottomNavigationItem(
                    icon = {
                        it.icon?.let {
                            Icon(
                                imageVector = it,
                                contentDescription = "",
                                modifier = Modifier.size(35.dp),
                                tint = Color.White

                            )
                        }
                    },
                    selected = currentRoute?.hierarchy?.any { it.route == navController.currentBackStackEntry?.destination?.route } == true,
                    // selectedContentColor = Color(R.color.purple_700),
                    unselectedContentColor = Color.White.copy(alpha = 0.4f),
                    onClick = { navController.navigate(it.route) }
                )
            }
        }

    }
}