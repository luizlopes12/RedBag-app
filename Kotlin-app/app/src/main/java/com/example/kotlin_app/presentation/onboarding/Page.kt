package com.example.kotlin_app.presentation.onboarding


import androidx.annotation.DrawableRes
import androidx.compose.material3.TextField
import com.example.kotlin_app.R

data class OnboardPage(
    val id: Int,
    val title: String,
    val description: String,
    val fullDescription: String,
    @DrawableRes val image: Int
)

val onboardingPages = listOf(
    OnboardPage(
        id = 0,
        title = "Passo a Passo",
        description = "Antes de entrar, gostaríamos de ajudar em sua experiência",
        fullDescription = "Clique no menu “Página inicial” para visualizar os dados gerais das suas análises.",
        image = R.drawable.onboarding__home,
    ),
    OnboardPage(
        id = 1,
        title = "Passo a Passo",
        description = "Antes de entrar, gostaríamos de ajudar em sua experiência",
        fullDescription = "Clique no menu “Análises” para realizar uma nova análise do seu animal.",
        image = R.drawable.onboarding__analyse
    ),
    OnboardPage(
        id = 2,
        title = "Passo a Passo",
        description = "Antes de entrar, gostaríamos de ajudar em sua experiência",
        fullDescription = "Clique no menu “Prontuários” para visualizar seu histórico de análise e seus prontuários digitais.",
        image = R.drawable.onboarding__imports
    ),
    OnboardPage(
        id = 3,
        title = "Passo a Passo",
        description = "Antes de entrar, gostaríamos de ajudar em sua experiência",
        fullDescription = "Clique no menu “Ajustes” para aplicar alterações em seu perfil, suporte e encerrar sua conta.",
        image = R.drawable.onboarding__config
    )

)
