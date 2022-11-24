package com.gincana.screens



import androidx.compose.foundation.Image

import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.gincana.R
import com.gincana.ui.theme.GincanaTheme



    @Composable
    fun AuthScreen(navController: NavController){
        Scaffold(modifier = Modifier.fillMaxSize()) {

            BodyContent(navController)
        }
    }


    /*
    COMPOSABLESexample
     */

    @Composable
    fun BodyContent(navController: NavController) {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxSize()) {

            Spacer(modifier = Modifier.height(100.dp))
            
                Image(painter = painterResource(R.drawable.reuleta), contentDescription ="", modifier = Modifier
                    .clip(shape = CircleShape)
                    .size(300.dp))







                Buttons(navController)
            

        }


   }

    @Composable
    fun Buttons(navController: NavController) {

        Column(modifier = Modifier.padding(bottom = 50.dp)) {

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = {
                        /*TODO*/
                        navController.navigate("login_screen")
                    },
                    modifier = Modifier.width(360.dp)
                ) {
                    Text(
                        text = "Iniciar Sesión",
                        style = MaterialTheme.typography.button
                    )
                }
            }

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = {
                        /*TODO*/
                    },
                    modifier = Modifier.width(360.dp)
                ) {
                    Text(
                        text = "Registrarse",
                        style = MaterialTheme.typography.button
                    )
                }
            }
        }
    }



    @Preview(showBackground = true)
    @Composable

    fun Preview() {
        GincanaTheme {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {
                val navController = rememberNavController()
                AuthScreen(navController)
            }
        }
    }

