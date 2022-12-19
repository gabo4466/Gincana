package com.gincana.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.rememberNavController
import com.gincana.MainActivity
import com.gincana.R
import com.gincana.common.composables.BottomNav
import com.gincana.common.composables.Title
import com.gincana.ui.theme.GincanaTheme
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions

import com.google.firebase.auth.FirebaseAuth


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(topBar = { Title(title = "Home", navController = navController, false) }, bottomBar = {
        BottomNav(
            navController = navController
        )
    }, modifier = Modifier.fillMaxSize()) {

        BodyHome(navController)
    }

}

@Composable
fun BodyHome(navController: NavController) {
    val auth = FirebaseAuth.getInstance()
    val activity = LocalContext.current as MainActivity
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {

        auth.currentUser?.displayName?.let { Text(text = "Bienvenido "+it) }
        Spacer(modifier = Modifier.size(30.dp))
        ButtonHome(text = "Unirse a partida") {
            navController.navigate("joingame_screen")
        }
        ButtonHome(text = "Cerrar sesión") {
            auth.signOut()
            val gso: GoogleSignInOptions =
                    GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                            .requestIdToken(activity.getString(R.string.default_web_client_id))
                            .requestEmail()
                            .build()
            val client = GoogleSignIn.getClient(activity, gso)
            Auth.GoogleSignInApi.signOut(client.asGoogleApiClient())
            navController.navigate("auth_screen")
        }
    }
}

@Composable
fun ButtonHome(text: String, onClick: () -> Unit) {

    Button(
        onClick = onClick, modifier = Modifier
            .width(350.dp)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.button
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    GincanaTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            val navController = rememberNavController()
            HomeScreen(navController)
        }
    }
}