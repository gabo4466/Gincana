package com.gincana

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gincana.ui.theme.GincanaTheme
import com.google.firebase.ktx.Firebase

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GincanaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen("Android")
                }
            }
        }
    }

    /*
    METHODS
     */
    private fun registerFireBase(email: TextFieldValue, password: TextFieldValue) {

    }

    /*
    COMPOSABLESexample
     */

    @Composable
    fun MainScreen(name: String) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column {
                Title("Inicio de sesión o registro")
                SignUpForm()
            }
        }
    }

    @Composable
    fun Title(title: String) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colors.primary)
        ) {
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
        var email by remember { mutableStateOf(TextFieldValue("costanzag1999@gmail.com")) }
        var password by remember { mutableStateOf(TextFieldValue("password")) }
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 100.dp)
        ) {
            Row (
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                TextField(
                    value = email,
                    onValueChange = { newValue ->
                        email = newValue
                    }
                )
            }
            Spacer(modifier = Modifier.size(20.dp))
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                TextField(
                    value = password,
                    onValueChange = { newValue ->
                        password = newValue
                    }
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
    fun DefaultPreview() {
        GincanaTheme {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {
                MainScreen("Android")
            }
        }
    }
}

