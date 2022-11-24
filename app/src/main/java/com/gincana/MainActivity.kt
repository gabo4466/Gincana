package com.gincana

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

import com.gincana.navigation.AppNavigation

import com.gincana.ui.theme.GincanaTheme

class MainActivity : ComponentActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GincanaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AppNavigation()

                /*
                    val navigationController= rememberNavController()
                    NavHost(navController= navigationController, startDestination = "Home"){

                        composable("Auth"){ AuthScreen() }

                        composable("screen1"){ Screen1(navigationController) }
                        composable("screen2"){ Screen2(navigationController) }
                        composable("screen3"){ Screen3(navigationController) }

                    }*/
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GincanaTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            AppNavigation()
        }
    }
}
