package com.gincana

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.gincana.ui.theme.GincanaTheme
import com.google.firebase.ktx.Firebase



    /*
    METHODS
     */
    private fun registerFireBase(email: TextFieldValue, password: TextFieldValue) {

    }

    /*
    COMPOSABLESexample
     */

    @Composable
    fun AuthScreen(navController: NavController) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column {

                    Title("Inicio de sesión o registro",navController)
                    SignUpForm()
            }
        }
    }

    @Composable
    fun Title(title: String,navController: NavController) {
        TopAppBar(
          /*  modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colors.primary)*/
        ) {

            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Arrow Back", modifier = Modifier.clickable { navController.popBackStack() })
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = title,
                style = MaterialTheme.typography.h6,
                color = MaterialTheme.colors.onPrimary,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(10.dp)
            )

        }
    }

    @Composable
    fun SignUpForm() {
        var email by remember { mutableStateOf(TextFieldValue("")) }
        var password by remember { mutableStateOf(TextFieldValue("")) }
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 100.dp)
        ) {
            Row (
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text(text = "Email")},
                    /*CAMBIAR  COLORES*/
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Magenta,
                        unfocusedBorderColor = Color.Blue
                    )

                )
            }
            Spacer(modifier = Modifier.size(20.dp))
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                OutlinedTextField(

                    value = password,
                    onValueChange = {password= it},
                    label = { Text(text = "Password")},
                    /*CAMBIAR COLORES*/
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Magenta,
                        unfocusedBorderColor = Color.Blue
                    )

                )
            }
            Spacer(modifier = Modifier.size(20.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = {
                        registerFireBase(email, password)
                    }
                ) {
                    Text(
                        text = "Registrar",
                        style = MaterialTheme.typography.button
                    )
                }
                Button(
                    onClick = {
                        /*TODO*/
                    }) {
                    Text(
                        text = "Acceder",
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


