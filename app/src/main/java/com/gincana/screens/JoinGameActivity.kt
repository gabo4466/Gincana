package com.gincana.screens

import android.annotation.SuppressLint
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.gincana.ButtonAccces
import com.gincana.MainActivity
import com.gincana.common.composables.BottomNav
import com.gincana.common.composables.ErrorText
import com.gincana.common.composables.TextInputIcon
import com.gincana.common.composables.Title
import com.gincana.ui.theme.GincanaTheme
import com.gincana.viewModel.LoginViewModel


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun JoinGameScreen(navController: NavController) {
    val activity = LocalContext.current as MainActivity
    val viewModel: LoginViewModel by activity.viewModels()

    Scaffold(topBar = { Title(title = "Unirse a una partida", navController = navController) },
        bottomBar = {
            BottomNav(navController = navController)
        },
        modifier = Modifier.fillMaxSize()
    ) {
        JoinGameBody(navController, viewModel, activity)

    }
}

@Composable
fun JoinGameBody(navControler: NavController, viewModel: LoginViewModel, activity: MainActivity) {
    val isLoading by viewModel.isLoading().observeAsState(false)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        var gameCode by remember { mutableStateOf("") }
        var error by remember { mutableStateOf("") }
        var hidden by remember { mutableStateOf(true) }

        TextInputIcon(gameCode, {
            if (it.length == 4) gameCode = it
        }, "Código de partida", imageVector = Icons.Default.Info)

        ErrorText(text = error, hidden)

        Spacer(modifier = Modifier.size(20.dp))

        ButtonAccces("Unirse") {  }
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

@Preview(showBackground = true)
@Composable
fun JoinGamePreview() {
    GincanaTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            val navController = rememberNavController()
            JoinGameScreen(navController)
        }
    }
}