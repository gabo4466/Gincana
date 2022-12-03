package com.gincana.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.gincana.R
import com.gincana.common.composables.*
import com.gincana.ui.theme.GincanaTheme
import com.gincana.ui.theme.Shapes

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AccountSettingsScreen(navController: NavController){
    GincanaTheme() {
        Scaffold(
            topBar = { Title(title ="Ajustes de cuenta", navController =navController)},
            bottomBar = { BottomNav(
                navController =navController)},
            modifier = Modifier.fillMaxSize()
        ){

            SettingsBody(navController)
        }
    }

}

@Composable
fun SettingsBody(navController: NavController) {
    var nickname by remember {
        mutableStateOf("pepito")
    }
    var email by remember {
        mutableStateOf("pepe@gmail.com")
    }
    var password by remember {
        mutableStateOf("")
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
            .verticalScroll(rememberScrollState())
            .padding(top = 30.dp, bottom = 30.dp)
    ) {

        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .border(BorderStroke(2.dp, MaterialTheme.colors.primary), RoundedCornerShape(5.dp))
                .fillMaxWidth()
                .padding(bottom = 30.dp)

        ){
            Row (
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ){
                Text(text = "Datos públicos",style = MaterialTheme.typography.h5)
            }
            Divider(color = MaterialTheme.colors.primary, thickness = 1.dp)
            Row (
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)

            ){
                Avatar(R.drawable.avatar_1, size = 100.dp)
            }
            Row (
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ){
                Button(onClick = { /*TODO*/
                }, modifier = Modifier.width(300.dp)
                ) {
                    Text(text = "Cambiar avatar", style = MaterialTheme.typography.button)
                }
            }
            Row (
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ){
                TextInputIcon(text = nickname, onVAlueChange = {nickname = it}, label = "Nickname", imageVector = Icons.Default.Person)
            }
            Row (
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ){
                Button(onClick = { /*TODO*/
                }, modifier = Modifier.width(300.dp)
                ) {
                    Text(text = "Actualizar perfil", style = MaterialTheme.typography.button)
                }
            }
        }
        
        Spacer(modifier = Modifier.size(25.dp))

        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .border(BorderStroke(2.dp, MaterialTheme.colors.primary), RoundedCornerShape(5.dp))
                .fillMaxWidth()
                .padding(10.dp)

        ){
            Row (
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)

            ){
                Text(text = "Datos privados", style = MaterialTheme.typography.h5)
            }
            Divider(color = MaterialTheme.colors.primary, thickness = 1.dp)
            Row (
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)

            ){
                TextInputIcon(text = email, onVAlueChange = {email = it}, label = "Email", imageVector = Icons.Default.Email )
            }
            Row (
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)

            ){
                PasswordField(password = password, onVAlueChange = {password = it}, label = "Contraseña")
            }
            Row (
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ){
                Button(onClick = { /*TODO*/
                }, modifier = Modifier.width(300.dp)
                ) {
                    Text(text = "Actualizar cuenta", style = MaterialTheme.typography.button)
                }
            }
        }


    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview(showBackground = true)
@Composable
fun AccountSettingsPreview() {
    GincanaTheme {
        val navController = rememberNavController()
        Scaffold(
            topBar = { Title(title ="Ajustes de cuenta", navController =navController)},
            bottomBar = { BottomNav(
                navController =navController)},
            modifier = Modifier.fillMaxSize()
        ){

            SettingsBody(navController)
        }
    }
}