package com.gincana

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

import com.gincana.common.composables.PasswordField
import com.gincana.common.composables.TextInputIcon
import com.gincana.common.composables.Title
import com.gincana.ui.theme.GincanaTheme


/*
METHODS
 */
    private fun registerFireBase(email: TextFieldValue, password: TextFieldValue) {

    }

    /*
    COMPOSABLESexample
     */

    @Composable
    fun SignUpScreen(navController: NavController) {

        Scaffold(topBar = { Title(title = "Registro", navController = navController) },modifier = Modifier.fillMaxSize()) {
            SignUpForm(navController)
        }
    }



    @Composable
    fun SignUpForm(navController: NavController) {
        var name by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var repeatPassword by remember { mutableStateOf("") }
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 100.dp)
        ) {
            TextInputIcon(text = name,{ name = it },label = "Nombre", imageVector =Icons.Default.Person )
            Spacer(modifier = Modifier.size(20.dp))
            TextInputIcon(email,{ email = it },label = "Correo Electrónico", imageVector =Icons.Default.Email )
            Spacer(modifier = Modifier.size(20.dp))
            PasswordField(password,{password= it},"Contraseña")
            Spacer(modifier = Modifier.size(20.dp))
            PasswordField(repeatPassword,{repeatPassword= it},"Repetir contraseña")
            Spacer(modifier = Modifier.size(20.dp))
            ButtonSignUp(text = "Registrarse") {navController.navigate("home_screen") }

        }
    }

@Composable
fun ButtonSignUp(text:String, onClick: ()->Unit) {

    Button(
        onClick = onClick, modifier = Modifier.width(350.dp)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.button
        )
    }
}

    @Preview(showBackground = true)
    @Composable
    fun SignupPreview() {
        GincanaTheme {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {
                val navController = rememberNavController()
                SignUpScreen(navController)
            }
        }
    }


