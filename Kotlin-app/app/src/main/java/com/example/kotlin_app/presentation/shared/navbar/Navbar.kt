package com.example.kotlin_app.presentation.shared.navbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.example.kotlin_app.R
import com.example.kotlin_app.ui.theme.Orange4
import com.example.kotlin_app.ui.theme.White


@Composable
fun Navbar(navbarSelected: Int, navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(White)
            .zIndex(10f),
        horizontalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 50.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .width(if (navbarSelected == 0) 80.dp else 50.dp)
                    .offset(y = (-40).dp)
                    .clickable {
                        navController.navigate("home")
                    },
                painter = painterResource(id = if (navbarSelected == 0) R.drawable.navbar_home_icon_active else R.drawable.navbar_home_icon),
                contentDescription = null,
            )
            Image(
                modifier = Modifier
                    .width(if (navbarSelected == 1) 80.dp else 50.dp)
                    .offset(y = (-40).dp)
                    .clickable {
                        navController.navigate("analyze")
                    },
                painter = painterResource(id = if (navbarSelected == 1) R.drawable.navbar_analisis_icon_active else R.drawable.navbar_analisis_icon),
                contentDescription = null
            )
            Image(
                modifier = Modifier
                    .width(if (navbarSelected == 2) 80.dp else 50.dp)
                    .offset(y = (-40).dp)
                    .clickable {
                        navController.navigate("imports")
                    },
                painter = painterResource(id = if (navbarSelected == 2) R.drawable.navbar_imports_icon_active else R.drawable.navbar_imports_icon),
                contentDescription = null
            )
        }
    }
}