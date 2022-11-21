package com.gincana.screens



import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gincana.R
import com.gincana.ui.theme.GincanaTheme

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
                    MainScreen()
                }
            }
        }
    }



    /*
    COMPOSABLESexample
     */

    @Composable
    fun MainScreen() {
    Image(painter = painterResource(R.drawable.ic_launcher_foreground), contentDescription ="", modifier = Modifier.size(10.dp,10.dp))

    Buttons()

    }

    @Composable
    fun Buttons() {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(top = 700.dp)) {


            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
                Button(
                    onClick = {
                        /*TODO*/
                    },
                    modifier = Modifier.width(360.dp)
                ) {
                    Text(
                        text = "Iniciar Sesión",
                        style = MaterialTheme.typography.button
                    )
                }
            }

            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
                Button(
                    onClick = {
                        /*TODO*/
                    },
                    modifier = Modifier.width(360.dp)
                ) {
                    Text(
                        text = "Registrarse",
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
                MainScreen()
            }
        }
    }
}

