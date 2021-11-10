package com.praveen.androidcleanarchitecture.presentation.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun SeparatorSpacer(modifier: Modifier = Modifier) {
    Spacer(modifier = modifier.height(10.dp))
}

@Composable
fun SeparatorDivider(modifier: Modifier = Modifier, thickness: Dp = 1.dp) {
    SeparatorSpacer()
    Divider(
        modifier = modifier.fillMaxWidth(),
        thickness = thickness,
    )
    SeparatorSpacer()
}