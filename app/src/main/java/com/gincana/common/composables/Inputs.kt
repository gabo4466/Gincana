package com.gincana.common.composables

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

import com.google.android.material.R

@Composable
fun PasswordField(password: String, onVAlueChange: (String) -> Unit, label: String) {

    var passwordVisibility by remember { mutableStateOf(false) }

    val icon = if (passwordVisibility)
        painterResource(id = R.drawable.design_ic_visibility)
    else
        painterResource(R.drawable.design_ic_visibility_off)



    OutlinedTextField(

            value = password,
            onValueChange = onVAlueChange,
            label = { InputLabel(text = label, imageVector = Icons.Default.Lock) },
            singleLine = true,
            /*CAMBIAR COLORES*/
            colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = MaterialTheme.colors.secondary,
                    unfocusedBorderColor = MaterialTheme.colors.primary,

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

@Composable
fun InputLabel(text: String, imageVector: ImageVector) {
    Row {
        Icon(
                imageVector = imageVector,
                contentDescription = "Arrow Back"
        )
        Spacer(modifier = Modifier.width(8.dp))

        Text(text = text)
    }
}


@Composable
fun TextInputIcon(
        text: String,
        onVAlueChange: (String) -> Unit,
        label: String,
        imageVector: ImageVector,
        modifier: Modifier = Modifier
) {


    OutlinedTextField(
            value = text,
            onValueChange = onVAlueChange,
            label = { InputLabel(text = label, imageVector = imageVector) },
            singleLine = true,
            /*CAMBIAR  COLORES*/
            colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = MaterialTheme.colors.secondary,
                    unfocusedBorderColor = MaterialTheme.colors.primary,
            ),
            modifier = modifier.width(350.dp)

    )
}

@Composable
fun ErrorText(text: String, hidden: Boolean = true) {
    if (!hidden) {
        Text(text = text, color = MaterialTheme.colors.error)
    }
}


