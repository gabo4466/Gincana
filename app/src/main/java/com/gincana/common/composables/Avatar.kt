package com.gincana.common.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Avatar(image: Int, size: Dp) {
    Image(
        painter = painterResource(id = image),
        contentDescription = "Avatar",
        modifier = Modifier
            .size(size)
            .clip(shape = CircleShape)
            .border(border = BorderStroke(2.dp, MaterialTheme.colors.primary), shape = CircleShape)
    )
}