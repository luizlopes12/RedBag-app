package com.example.kotlin_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kotlin_app.presentation.home.HomePage
import com.example.kotlin_app.presentation.login.LoginPage
import com.example.kotlin_app.presentation.register.OnBoardingScreen
import com.example.kotlin_app.ui.theme.KotlinappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            KotlinappTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "signin") {
                    composable("signin") { LoginPage(navController) }
                    composable("signup") { OnBoardingScreen(navController) }
                    composable("home") { HomePage(navController) }
                }
            }
        }
    }
}