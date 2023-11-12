package com.example.kotlin_app.presentation.configs

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.kotlin_app.R
import com.example.kotlin_app.presentation.shared.header.Header
import com.example.kotlin_app.presentation.shared.navbar.Navbar
import com.example.kotlin_app.ui.theme.Black
import com.example.kotlin_app.ui.theme.Gray

@Composable
fun ConfigsPage(navController: NavController) {
    Column(modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Header(navController = navController)
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        ) {
            Row(){
                Image(
                    modifier = Modifier
                        .width(60.dp),
                    painter = painterResource(id = R.drawable.user__icon),
                    contentDescription = null
                )
            }
            Row() {
                Text(
                    text = "Sua conta",
                    color = Black,
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 45.sp,
                        fontWeight = Bold,
                    )
                )
            }
            Spacer(modifier = Modifier.padding(2.dp))
            Row() {
                Text(
                    text = "Veja as informações sobre sua conta, edite seus dados pessoais e configurações.",
                    color = Gray,
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 20.sp,
                        fontWeight = Normal,
                    )
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
            Row(
                Modifier
                    .clickable {
                    navController.navigate("home")
                },
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.End
            ) {
                Image(
                    modifier = Modifier
                        .width(35.dp),
                    painter = painterResource(id = R.drawable.edit__account_icon),
                    contentDescription = null
                )
                Text(
                    modifier = Modifier
                        .padding( 10.dp, 0.dp, 0.dp, 0.dp),
                    text = "Editar perfil",
                    color = Black,
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 28.sp,
                        fontWeight = Bold,
                    )
                )
            }
            Spacer(modifier = Modifier.height(25.dp))
            Row(
                Modifier
                    .clickable {
                        navController.navigate("home")
                    },
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.End
            ) {
                Image(
                    modifier = Modifier
                        .width(35.dp),
                    painter = painterResource(id = R.drawable.edit__account_icon),
                    contentDescription = null
                )
                Text(
                    modifier = Modifier
                        .padding( 10.dp, 0.dp, 0.dp, 0.dp),
                    text = "Suporte",
                    color = Black,
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 28.sp,
                        fontWeight = Bold,
                    )
                )
            }
            Spacer(modifier = Modifier.height(80.dp))
        }
        Navbar(navbarSelected = 4, navController = navController)
    }
}