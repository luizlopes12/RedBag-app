package com.example.kotlin_app.presentation.shared.header

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.kotlin_app.R
import com.example.kotlin_app.ui.theme.Black

@Composable
fun Header(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.End
    ) {
        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(id = R.drawable.login_top_illustration),
            contentDescription = null
        )
        Image(
            modifier = Modifier
                .width(40.dp)
                .offset(y = (-90).dp, x = (-10).dp)
                .clickable {
                    navController.navigate("configs")
                },
            painter = painterResource(id = R.drawable.config__icon),
            contentDescription = null
        )
        Text(
            text = "23 de Novembro",
            modifier = Modifier
                .offset(y = (-105).dp, x = (-130).dp),
            color = Black,
            style = androidx.compose.ui.text.TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            ))
    }
}