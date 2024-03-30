package com.nemanja02.catlist.view

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Composable
import com.nemanja02.catlist.model.Breed


private val topBarContainerColor = Color.LightGray.copy(alpha = 0.5f)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatScreen(selected: Breed?) {
    Text(text = "CatScreen")
}