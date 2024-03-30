package com.nemanja02.catlist.model

data class Breed(
    val id: String,
    val name: String,
    val description: String,
    val alt_names: String,
    val temperament: String,
    val image: Image,
)

data class Image(
    val id: String,
    val url: String,
)