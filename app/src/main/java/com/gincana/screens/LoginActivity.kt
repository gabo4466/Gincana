package com.gincana

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.gincana.R

import com.gincana.common.composables.PasswordField
import com.gincana.common.composables.TextInputIcon
import com.gincana.common.composables.Title
import com.gincana.ui.theme.GincanaTheme

    @Composable
    fun LoginScreen(navController: NavController) {

        Scaffold(topBar = { Title(title ="Inicio de sesión o registro" , navController =navController)},
            modifier = Modifier.fillMaxSize()
        ) {
            LoginForm(navController)

        }
    }


//COMMON
   /* @Composable
    fun Title(title: String,navController: NavController) {
        TopAppBar(){

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
    }*/

    @Composable
    fun LoginForm(navController: NavController) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 100.dp)
        ) {
            TextInputIcon(text = "Correo Electrónico", imageVector =Icons.Default.Email )

            Spacer(modifier = Modifier.size(20.dp))

            PasswordField("Contraseña")

            Spacer(modifier = Modifier.size(20.dp))

            ForgottenPasword(navController)

            Spacer(modifier = Modifier.size(20.dp))

            ButtonAccces("Acceder") { navController.navigate("home_screen") }
        }
    }


    @Composable
    fun ButtonAccces(text:String, onClick: ()->Unit) {

            Button(
                onClick = onClick, modifier = Modifier.width(350.dp)
            ) {
                Text(
                    text = text,
                    style = MaterialTheme.typography.button
                )
            }
        }


    /*@Composable
    fun EmailField(){
        var email by remember { mutableStateOf(TextFieldValue("")) }

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { EmailLabel()},
                singleLine = true,
                *//*CAMBIAR  COLORES*//*
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Magenta,
                    unfocusedBorderColor = Color.Blue
                ),
                modifier = Modifier.width(350.dp)

            )
        }*/

/*
    @Composable
    fun PasswordField(){
        var password by remember { mutableStateOf(TextFieldValue("")) }

        var passwordVisibility by remember { mutableStateOf(false) }

        val icon = if (passwordVisibility)
            painterResource(id = com.google.android.material.R.drawable.design_ic_visibility)
        else
            painterResource(com.google.android.material.R.drawable.design_ic_visibility_off)


        OutlinedTextField(

            value = password,
            onValueChange = {password= it},
            label = { PasswordLabel()},
            singleLine = true,
            *//*CAMBIAR COLORES*//*
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Magenta,
                unfocusedBorderColor = Color.Blue,

                ),

            trailingIcon = {
                IconButton(onClick = {
                    passwordVisibility = !passwordVisibility
                }) {
                    Icon(
                        painter = icon,
                        contentDescription = "Visibility Icon"
                    )
                }
            },
            visualTransformation = if (passwordVisibility) VisualTransformation.None
            else PasswordVisualTransformation(),

            modifier = Modifier.width(350.dp)

        )
    }
*/
   /* @Composable
    fun EmailLabel(){
        Row() {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = "Arrow Back")
            Spacer(modifier = Modifier.width(5.dp))

            Text(text = "Correo Electrónico")
        }
    }*/
/*
    @Composable
    fun PasswordLabel(){
        Row() {
            Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = "Arrow Back")
            Spacer(modifier = Modifier.width(5.dp))

            Text(text = "Contraseña")
        }
    }*/

    @Composable
    fun ForgottenPasword(navController: NavController){
        Row(horizontalArrangement = Arrangement.End, modifier = Modifier.width(350.dp)){

            TextButton(onClick = {/* navController.navigate() TODO*/ }){ Text(text = "¿Has olvidado tu contraseña?")}

        }
    }


    @Preview(showBackground = true)
    @Composable
    fun LonginPreview() {
        GincanaTheme {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {
                val navController = rememberNavController()
                LoginScreen(navController)
            }
        }
    }


