package com.gincana.common.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp

@Composable
fun Avatar(image: Int, size: Dp) {
    Image(painter = painterResource(id = image), contentDescription = "Avatar", modifier = Modifier.size(size))
}