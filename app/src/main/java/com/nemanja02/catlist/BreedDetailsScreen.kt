package com.nemanja02.catlist

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController

class BreedDetailsScreen(breedId: String?, navController: NavHostController) {
    @Composable
    fun BreedDetailsScreen(breedId: String?, navController: NavController) {
        // TODO: Implement the UI for the breed details screen
        Text(text = "Breed Details Screen for breed ID: $breedId")
    }
}