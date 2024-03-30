package com.nemanja02.catlist.view;


import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import com.nemanja02.catlist.model.Breed

sealed class AppScreen {
    data object CatlistScreen : AppScreen()
    data class CatScreen(val data: Breed?) : AppScreen()
};

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatlistApp(selected: Breed?) {
    var activeScreen: AppScreen by remember { mutableStateOf(AppScreen.CatlistScreen) }


    Scaffold(
        content = { paddingValues ->
            AnimatedContent(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                targetState = activeScreen,
                label = "MainContent",
            ) { currentScreen ->
                when (currentScreen) {
                    is AppScreen.CatScreen -> {
                        CatScreen(
                            selected    = selected,
                        )
                    }


                    AppScreen.CatlistScreen -> {
                        CatListScreen()
                    }

                }
            }
        }
    )
}
