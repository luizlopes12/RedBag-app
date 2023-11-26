package com.example.kotlin_app.presentation.register


import androidx.annotation.DrawableRes
import androidx.compose.material3.TextField
import com.example.kotlin_app.R

data class Page(
    val id: Int,
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

val pages = listOf(
    Page(
        id = 0,
        title = "Vamos lá!",
        description = "Como podemos chamá-lo(a)?",
        image = R.drawable.onboarding1,
    ),
    Page(
        id = 1,
        title = "Vamos lá!",
        description = "Digite o seu melhor email!",
        image = R.drawable.onboarding2
    ),
    Page(
        id = 2,
        title = "Vamos lá!",
        description = "Defina a sua senha",
        image = R.drawable.onboarding3
    )
)
