package com.gincana


import android.annotation.SuppressLint
import android.app.Activity
import android.graphics.drawable.Icon
import androidx.activity.viewModels
import android.nfc.Tag
import android.util.Log
import androidx.compose.foundation.layout.*

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.gincana.R
import com.gincana.common.composables.ErrorText

import com.gincana.common.composables.PasswordField
import com.gincana.common.composables.TextInputIcon
import com.gincana.common.composables.Title
import com.gincana.ui.theme.GincanaTheme
import com.gincana.viewModel.LoginViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LoginScreen(navController: NavController) {
    val activity = LocalContext.current as MainActivity
    val viewModel: LoginViewModel by activity.viewModels()
    val logged by viewModel.logged().observeAsState(false)
    val email by viewModel.email().observeAsState("")
    if (logged){
        Log.d("BUGHOME", "RECARGA")
        PopUpLogin(email) {
            navController.navigate("home_screen")
        }
    }
    Scaffold(
        topBar = { Title(title = "Inicio de sesión o registro", navController = navController) },
        modifier = Modifier.fillMaxSize()
    ) {
        LoginForm(navController, viewModel, activity)
    }
}


@Composable
fun LoginForm(navController: NavController, viewModel: LoginViewModel, activity: MainActivity) {
    val isLoading by viewModel.isLoading().observeAsState(false)
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

        ButtonAccces(text = "Acceder", icon = null) {
            /*
            TODO: Loguear por mail
             */
        }

        ButtonAccces(text = "Acceder con Google", icon = R.drawable.google_icon) {
            viewModel.logInWithGoogle(activity)
        }
        if (isLoading){
            CircularProgressIndicator()
        }
    }
}


@Composable
fun ButtonAccces(text: String, icon: Int?, onClick: () -> Unit) {

    Button(
        onClick = onClick, modifier = Modifier.width(350.dp)
    ) {
        if (icon != null){
            Icon(painter =  painterResource(id = icon), contentDescription = "")
            Spacer(modifier = Modifier.size(10.dp))
        }
        
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

@Composable
fun PopUpLogin(name: String, onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        text= {
            Text(
                text = "Has iniciado sesión con el email $name",
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onSurface
            )
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text(text = "Continuar")
            }
        },
        backgroundColor = MaterialTheme.colors.surface
    )
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



