package com.gincana.screens



import android.util.Log
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable

import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.gincana.R
import com.gincana.ui.theme.GincanaTheme
import kotlinx.coroutines.launch
import java.util.logging.Logger
import kotlin.math.log


@Composable
    fun AuthScreen(navController: NavController){
        Scaffold(modifier = Modifier.fillMaxSize()) {

            BodyContent(navController)
        }
    }



@Composable
fun Roulette(){
    var spin=false
    var flag by rememberSaveable {
        mutableStateOf(spin)
    }
    val rotation = remember { Animatable(0f) }
    val scope = rememberCoroutineScope()


    var modifier= Modifier
        .clip(shape = CircleShape)
        .size(300.dp).rotate(rotation.value)
        .clickable {
                scope.launch {
                    rotation.animateTo(
                        targetValue = 180f,
                        animationSpec = tween(1000, easing = LinearEasing)
                    )
                    flag = !flag
                    rotation.animateTo(
                        targetValue = 360f,
                        animationSpec = tween(1000, easing = LinearEasing)
                    )
                    rotation.snapTo(0f)
                }
        }


    Image(painter = painterResource(R.drawable.ruleta), contentDescription ="", modifier=modifier)
}
    /*
    COMPOSABLESexample
     */

    @Composable
    fun BodyContent(navController: NavController) {


        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxSize()) {

            Spacer(modifier = Modifier.height(100.dp))
            
            Roulette()
            Buttons(navController)
        }
   }

    @Composable
    fun Buttons(navController: NavController) {

        Column(modifier = Modifier.padding(bottom = 50.dp)) {

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = {
                        /*TODO*/
                        navController.navigate("login_screen")
                    },
                    modifier = Modifier.width(360.dp)
                ) {
                    Text(
                        text = "Iniciar Sesión",
                        style = MaterialTheme.typography.button
                    )
                }
            }

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = {
                        navController.navigate("signup_screen")
                    },
                    modifier = Modifier.width(360.dp)
                ) {
                    Text(
                        text = "Registro",
                        style = MaterialTheme.typography.button
                    )
                }
            }
        }
    }



    @Preview(showBackground = true)
    @Composable

    fun AuthPreview() {
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

