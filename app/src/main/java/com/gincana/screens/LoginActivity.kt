package com.gincana


import android.annotation.SuppressLint
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
import com.gincana.R
import com.gincana.common.composables.ErrorText

import com.gincana.common.composables.PasswordField
import com.gincana.common.composables.TextInputIcon
import com.gincana.common.composables.Title
import com.gincana.ui.theme.GincanaTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LoginScreen(navController: NavController) {

    Scaffold(
        topBar = { Title(title = "Inicio de sesión o registro", navController = navController) },
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
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 100.dp)
    ) {
        var password by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var error by remember { mutableStateOf("") }
        var hidden by remember { mutableStateOf(true) }

        TextInputIcon(
            email,
            { email = it },
            label = "Correo Electrónico",
            imageVector = Icons.Default.Email
        )

        Spacer(modifier = Modifier.size(20.dp))

        PasswordField(password, { password = it }, "Contraseña")
        ErrorText(text = error, hidden)
        Spacer(modifier = Modifier.size(20.dp))

        ForgottenPasword(navController)

        Spacer(modifier = Modifier.size(20.dp))

        ButtonAccces("Acceder") {
            if (!checkisEmpty(*arrayOf(email, password))) {
                if (validateUser(email, password)) {
                    navController.navigate("home_screen")
                } else {

                    error = "Correo electrónico o contraseña incorrectos"
                    hidden = false
                    Log.d("error:", error)
                }

            } else {
                error = "Debes rellenar todos los campos"
                hidden = false
                Log.d("error:", error)
            }
        }
    }
}


@Composable
fun ButtonAccces(text: String, onClick: () -> Unit) {

    Button(
        onClick = onClick, modifier = Modifier.width(350.dp)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.button
        )
    }
}

@Composable
fun ForgottenPasword(navController: NavController) {
    Row(horizontalArrangement = Arrangement.End, modifier = Modifier.width(350.dp)) {

        TextButton(onClick = {/* navController.navigate() TODO*/ }) { Text(text = "¿Has olvidado tu contraseña?") }

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


fun checkisEmpty(vararg inputs: String): Boolean {
    var empty: Boolean = false
    var contador: Int = 0
    Log.d("Funcion checkinputs", "ENTRO VAMOS ARGENTINA VAMOS MESSI CARAJO")
    while (contador < inputs.size && !empty) {
        Log.d("Input", inputs[contador])
        if (inputs[contador].isEmpty()) {
            empty = true
            Log.d("EMPTYINPUT", inputs[contador])
        }
        contador++
    }

    return empty
}


fun validateUser(email: String, password: String): Boolean {
    var valid: Boolean = false
    //TODO: hacer peticion a la base de datos
    val fakeEmail: String = "pepe@gmail.com"
    val fakePassword: String = "12345"
    if (email == fakeEmail && password == fakePassword) {
        valid = true
    }
    return valid
}

