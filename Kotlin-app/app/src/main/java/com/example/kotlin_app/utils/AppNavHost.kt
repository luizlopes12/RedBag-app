package com.example.kotlin_app.utils

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kotlin_app.MainViewModel
import com.example.kotlin_app.presentation.analisis.AnalisisPage
import com.example.kotlin_app.presentation.configs.ConfigsPage
import com.example.kotlin_app.presentation.home.HomePage
import com.example.kotlin_app.presentation.imports.ImportsPage
import com.example.kotlin_app.presentation.login.LoginPage
import com.example.kotlin_app.presentation.onboarding.OnBoardingScreen
import com.example.kotlin_app.presentation.profile.ProfilePage
import com.example.kotlin_app.presentation.register.RegisterScreen
import com.example.kotlin_app.presentation.results.ResultsPage

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun AppNavHost(navController: NavHostController, startDestination: String, context: Context){

    NavHost(navController = navController, startDestination = startDestination) {
        composable("signin") { LoginPage(navController) }
        composable("signup") { RegisterScreen(navController) }
        composable("home") { HomePage(navController) }
        composable("analyze") { AnalisisPage(navController, context) }
        composable("imports") { ImportsPage(navController) }
        composable("configs") { ConfigsPage(navController) }
        composable("profile") { ProfilePage(navController) }
        composable("onboarding") { OnBoardingScreen(navController) }
        composable("results") { ResultsPage(navController) }
    }
}