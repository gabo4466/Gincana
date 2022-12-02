package com.gincana


import android.nfc.Tag
import android.util.Log
import androidx.compose.foundation.layout.*

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

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
            var password by remember { mutableStateOf("") }
            var email by remember { mutableStateOf("") }
            var error by remember { mutableStateOf("") }
            var hidden by remember { mutableStateOf(true) }

            TextInputIcon(email,{ email = it },label = "Correo Electrónico", imageVector =Icons.Default.Email )
            
            Spacer(modifier = Modifier.size(20.dp))

            PasswordField(password,{password= it},"Contraseña")
            ErrorText(text = error,hidden)
            Spacer(modifier = Modifier.size(20.dp))

            ForgottenPasword(navController)

            Spacer(modifier = Modifier.size(20.dp))

            ButtonAccces("Acceder") { if(!CheckisEmpty(*arrayOf(email,password))) {
                error="Debes rellenar todos los campos"
                hidden=false
            } else if(!ValidateUser(email,password)){
            error="Correo electrónico o contraseña incorrectos"
            hidden=false
                }else{
            navController.navigate("home_screen")
        }}
             /*   if(!ValidateUser(email,password)){
                    error="Correo electrónico o contraseña incorrectos"
                    hidden=false
                    Log.d("error:",error)
                }else{
                    navController.navigate("home_screen")
                }

            }else{
                error="Debes rellenar todos los campos"
                hidden=false}

            }*/
        }
    }

    @Composable
    fun ErrorText(text:String,hidden: Boolean=true){
        if(!hidden){
            Text(text = text, color = MaterialTheme.colors.error)
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



    private fun CheckisEmpty(vararg inputs: String): Boolean {
        var valid:Boolean = false
        var contador: Int=0

        while(contador<inputs.size && valid){
            if (inputs.get(contador).isEmpty()) {
                valid = false
            }
            contador++
        }

        return valid
    }


private fun ValidateUser(email:String,password:String): Boolean{
    var valid : Boolean= false
    //TODO: hacer peticion a la base de datos
    val fakeEmail:String="pepe@gmail.com"
    val fakePassword:String="12345"
    if(email==(fakeEmail) && password==(fakePassword) ){
        valid=true
    }
    return valid
}

