package com.example.kotlin_app.presentation.configs

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
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
import com.example.kotlin_app.ui.theme.Red

@Composable
fun ConfigsPage(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
    Column(modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Header(navController = navController)
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .offset(y = (-50).dp),
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
                        .width(30.dp),
                    painter = painterResource(id = R.drawable.edit__account_icon),
                    contentDescription = null
                )
                Text(
                    modifier = Modifier
                        .padding( 10.dp, 0.dp, 0.dp, 0.dp)
                        .offset(y = (4).dp),
                    text = "Editar perfil",
                    color = Black,
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 26.sp,
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
                        .width(30.dp),
                    painter = painterResource(id = R.drawable.support__icon),
                    contentDescription = null
                )
                Text(
                    modifier = Modifier
                        .padding( 10.dp, 0.dp, 0.dp, 0.dp)
                        .offset(y = (4).dp),
                    text = "Suporte",
                    color = Black,
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 26.sp,
                        fontWeight = Bold,
                    )
                )
            }
            Spacer(modifier = Modifier.height(70.dp))
            Row(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Row(
                    Modifier
                        .background(
                            Red.copy(alpha = 0.05f),
                            shape = androidx.compose.foundation.shape.RoundedCornerShape(10.dp))
                        .fillMaxWidth(.4f)
                        .height(50.dp)
                        .clickable {
                            navController.navigate("signin")
                        },
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center

                ) {
                    Image(
                        modifier = Modifier
                            .width(30.dp),
                        painter = painterResource(id = R.drawable.logout__icon),
                        contentDescription = null
                    )
                    Text(
                        modifier = Modifier
                            .padding(10.dp, 0.dp, 0.dp, 0.dp),
                        text = "Sair",
                        color = Red,
                        style = androidx.compose.ui.text.TextStyle(
                            fontSize = 24.sp,
                            fontWeight = Bold,
                        )
                    )
                }
            }
        }
        Navbar(navbarSelected = 4, navController = navController)
    }
}
}