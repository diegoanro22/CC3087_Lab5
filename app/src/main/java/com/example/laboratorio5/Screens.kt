package com.example.laboratorio5

sealed class Screens (val screens: String){
    data object Profile: Screens("profile")
    data object Details: Screens("details")
    data object Places: Screens("places")
    data object Favorite: Screens("favorite")
}