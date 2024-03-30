package com.nemanja02.catlist.model

import androidx.compose.runtime.mutableStateOf

class BreedRepository {
    private val selectedBreedId = mutableStateOf<Breed?>(null)

    fun getSelectedBreed() = selectedBreedId.value
}