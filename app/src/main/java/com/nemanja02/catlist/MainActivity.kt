package com.nemanja02.catlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.nemanja02.catlist.model.BreedRepository
import com.nemanja02.catlist.ui.theme.CatlistTheme
import com.nemanja02.catlist.view.CatlistApp

class MainActivity : ComponentActivity() {

    private val repository = BreedRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CatlistTheme {
                CatlistApp(
                    selected = repository.getSelectedBreed()
                )
            }
        }
    }
}